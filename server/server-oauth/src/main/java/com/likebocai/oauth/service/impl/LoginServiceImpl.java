package com.likebocai.oauth.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.likebocai.common.constant.enums.RedisKeyEnum;
import com.likebocai.common.result.Result;
import com.likebocai.common.result.ResultCodeEnum;
import com.likebocai.common.utils.AESUtils;
import com.likebocai.oauth.dto.UserLoginDTO;
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

    @Override
    public Result<UserLoginVO> login(UserLoginDTO userLoginDTO) {
        // 检查此用户名是否在5分钟内登陆失败超过5次
        Long isCheck = (Long) redisTemplateString.opsForValue().get(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
        if (isCheck == null) {
            redisTemplateString
                    .opsForValue()
                    .set(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()),
                            1L,
                            RedisKeyEnum.TIME_OUT_FIVE,
                            TimeUnit.MINUTES);
        } else if (isCheck > 5L) {
            Result.build(null, ResultCodeEnum.ACCOUNT_BAN);
        }

        // 数据库查询该账号下的信息
        OauthUserPO oauthUserPO = oauthUserMapper.getOauthUserInfoByUserName(userLoginDTO.getUserName());

        // 用户名存在
        if (oauthUserPO == null || StringUtils.isEmpty(oauthUserPO.getUserName())) {
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
            return Result.build(null,ResultCodeEnum.SYSTEM_ERROR);
        }

        // if 报错 redis错误次数 +1
        if (!oauthUserPO.getPassword().equals(cipherTextByMD5)) {
            redisTemplateString.opsForValue().increment(RedisKeyEnum.LOGIN_CHECK_NUMBER.concat(userLoginDTO.getUserName()));
            return Result.build(null,ResultCodeEnum.LOGIN_ERROR);
        }
        // else 返回 双token
        // accout_token
        String account = UUID.randomUUID().toString().replace("-","");
        // refresh_token
        String refresh = UUID.randomUUID().toString().replace("-","");
        UserLoginVO userLoginVO = new UserLoginVO(account,refresh);
        // 30min
         redisTemplateString.opsForValue().set(RedisKeyEnum.ACCOUNT_TOKEN.concat(account),"accout_token",RedisKeyEnum.TIME_OUT_FIVE,TimeUnit.MINUTES);
         // 15 day
        redisTemplateString.opsForValue().set(RedisKeyEnum.ACCOUNT_TOKEN.concat(refresh),"refresh_token",RedisKeyEnum.TIME_OUT_FIFTEEN,TimeUnit.DAYS);
        return Result.build(userLoginVO,200,"成功!");
    }
}
