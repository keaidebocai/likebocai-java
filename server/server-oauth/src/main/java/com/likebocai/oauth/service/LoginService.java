package com.likebocai.oauth.service;

import com.likebocai.common.result.Result;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.dto.UserRegisterDTO;
import com.likebocai.oauth.vo.UserLoginVO;

/**
 * @program: likebocai-java
 * @description: 登陆页面的相关接口
 * @author: LikeBocai
 * @create 2024/12/7 11:38
 **/

public interface LoginService {

    /**
     * @description:  用户登陆接口
     * @param: userLoginDTO
     * @return: com.likebocai.common.result.Result<com.likebocai.oauth.vo.UserLoginVO>
     * @author likebocai
     * @date: 2025/3/7 17:29
     */
    Result<UserLoginVO> login(UserLoginDTO userLoginDTO);

    /**
     * @description: 用户注册接口
     * @param: userRegisterDTO
     * @return: com.likebocai.common.result.Result<java.lang.Object>
     * @author likebocai
     * @date: 2025/3/7 17:28
     */
    Result<Object> register(UserRegisterDTO userRegisterDTO);

    /**
     * @description: 发送邮箱验证码
     * @param: email
     * @return: com.likebocai.common.result.Result<java.lang.Object>
     * @author likebocai
     * @date: 2025/3/7 17:27
     */
    Result<Object> sendEmailCode(String email);
}
