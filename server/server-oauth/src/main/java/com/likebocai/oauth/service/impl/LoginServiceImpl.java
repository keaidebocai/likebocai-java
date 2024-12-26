package com.likebocai.oauth.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.likebocai.common.constant.enums.RedisKeyEnum;
import com.likebocai.common.result.Result;
import com.likebocai.common.result.ResultCodeEnum;
import com.likebocai.common.utils.AESUtils;
import com.likebocai.common.utils.SnowflakeIdGenerator;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.dto.UserRegisterDTO;
import com.likebocai.oauth.mapper.OauthUserMapper;
import com.likebocai.oauth.po.OauthUserPO;
import com.likebocai.oauth.service.LoginService;
import com.likebocai.oauth.vo.UserLoginVO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: likebocai-java
 * @description: 登陆页面的相关接口实现类
 * @author: LikeBocai
 * @create: 2024/12/7 11:38
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private OauthUserMapper oauthUserMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplateString;

    @Resource
    private SnowflakeIdGenerator snowflakeIdGenerator;

    @Override
    public Result<UserLoginVO> login(UserLoginDTO userLoginDTO) {
        // 检查此用户名是否在5分钟内登陆失败超过5次
        Integer isCheck = (Integer) redisTemplateString
                .opsForValue()
                .get(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
        if (isCheck == null) {
            redisTemplateString
                    .opsForValue()
                    .set(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()),
                            1,
                            RedisKeyEnum.TIME_OUT_FIVE,
                            TimeUnit.MINUTES);
        } else if (isCheck > 5) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_BAN);
        }

        // 数据库查询该账号下的信息
        OauthUserPO oauthUserPO = oauthUserMapper.getOauthUserInfoByUserName(userLoginDTO.getUserName());

        // 用户名是否存在
        if (oauthUserPO == null || StringUtils.isEmpty(oauthUserPO.getUserName())) {
            redisTemplateString
                    .opsForValue()
                    .increment(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
            return Result.build(null,ResultCodeEnum.LOGIN_ERROR);
        }

        // 对比密码是否相等
        // 1.解密密码
        String cipherTextByMD5 = null;
        try {
            String plainText = AESUtils.decrypt128(
                            userLoginDTO.getPassword(),
                            AESUtils.getSecretKeySpec128(userLoginDTO.getTimeStamp().toString()),
                            AESUtils.getIvParameterSpec128(userLoginDTO.getTimeStamp().toString()));
            cipherTextByMD5 = AESUtils.md5Encrypt(plainText);
        } catch (Exception e) {
            redisTemplateString
                    .opsForValue()
                    .increment(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
            return Result.build(null,ResultCodeEnum.SYSTEM_ERROR);
        }

        // if 报错 redis错误次数 +1
        if (!oauthUserPO.getPassword().equals(cipherTextByMD5)) {
            redisTemplateString
                    .opsForValue()
                    .increment(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
            return Result.build(null,ResultCodeEnum.LOGIN_ERROR);
        }
        // else 返回 双token
        // accout_token
        String account = UUID.randomUUID().toString().replace("-","");
        // refresh_token
        String refresh = UUID.randomUUID().toString().replace("-","");
        UserLoginVO userLoginVO = new UserLoginVO(account,refresh);
        // 30min
         redisTemplateString
                 .opsForValue()
                 .set(RedisKeyEnum.ACCOUNT_TOKEN.concat(account),
                         "accout_token",
                         RedisKeyEnum.TIME_OUT_FIVE,
                         TimeUnit.MINUTES);
         // 15 day
        redisTemplateString
                .opsForValue()
                .set(RedisKeyEnum.ACCOUNT_TOKEN.concat(refresh),
                        "refresh_token",
                        RedisKeyEnum.TIME_OUT_FIFTEEN,TimeUnit.DAYS);
        return Result.build(userLoginVO,200,"成功!");
    }

    @Override
    public Result register(UserRegisterDTO userRegisterDTO) {
        // 1. 确保用户信息唯一
        // 1.1 用户名是否重复
        Integer userNameCount = oauthUserMapper.getCountByFileName("user_name", userRegisterDTO.getUserName());
        if (userNameCount > 0) {
            return Result.build(null,ResultCodeEnum.USER_NAME_EXIST);
        }
        // 1.2 昵称是否重复
        Integer nickNameCount =  oauthUserMapper.getCountByFileName("nick_name", userRegisterDTO.getNickName());
        if (nickNameCount > 0) {
            return Result.build(null,ResultCodeEnum.NICK_NAME_EXIST);
        }

        // 1.4 redis 邮箱验证码是否正确或是否超时
        Object emailCodeByRedis = redisTemplateString.opsForValue().get(RedisKeyEnum.EMAIL_CODE.concat(userRegisterDTO.getUserEmail()));
        if (emailCodeByRedis == null || !userRegisterDTO.getEmailCode().equals(emailCodeByRedis.toString())) {
            return Result.build(null,ResultCodeEnum.VALIDATECODE_ERROR);
        }
        // 1.4 邮箱是否重复
        Integer emailCount = oauthUserMapper.getCountByFileName("user_email", userRegisterDTO.getUserEmail());
        if (emailCount > 0) {
            return Result.build(null,ResultCodeEnum.EMAIL_ALREADY);
        }

        // 2.注册用户
        // 2.1 解密密码
        // 2.2 密码MD5加密放进密码
        String cipherTextByMD5 = null;
        try {
            String plainText = AESUtils.decrypt128(
                    userRegisterDTO.getPassword(),
                    AESUtils.getSecretKeySpec128(userRegisterDTO.getTimeStamp().toString()),
                    AESUtils.getIvParameterSpec128(userRegisterDTO.getTimeStamp().toString()));
            cipherTextByMD5 = AESUtils.md5Encrypt(plainText);
        } catch (Exception e) {
            return Result.build(null,ResultCodeEnum.SYSTEM_ERROR);
        }
        userRegisterDTO.setPassword(cipherTextByMD5);
        // 2.3 生成id
        long userId = snowflakeIdGenerator.nextId();
        userRegisterDTO.setId(userId);
        // 2.4 插入
        int rows = oauthUserMapper.userRegister(userRegisterDTO);
        if (rows <= 0) {
            return Result.build(null,ResultCodeEnum.SYSTEM_ERROR);
        }
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
