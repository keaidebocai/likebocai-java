package com.likebocai.oauth.service.impl;

import com.likebocai.common.result.Result;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.service.LoginService;
import com.likebocai.oauth.vo.UserLoginVO;
import org.springframework.stereotype.Service;

/**
 * @program: likebocai-java
 * @description: 登陆页面的相关接口实现类
 * @author: LikeBocai
 * @create: 2024/12/7 11:38
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Result<UserLoginVO> login(UserLoginDTO userLoginDTO) {
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setAccessToken("123");
        userLoginVO.setRefreshToken("456");
        return Result.build(userLoginVO,200,"成功!");
    }
}
