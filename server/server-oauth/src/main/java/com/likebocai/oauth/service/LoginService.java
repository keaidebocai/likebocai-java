package com.likebocai.oauth.service;

import com.likebocai.common.result.Result;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.vo.UserLoginVO;

/**
 * @program: likebocai-java
 * @description: 登陆页面的相关接口
 * @author: LikeBocai
 * @create 2024/12/7 11:38
 **/

public interface LoginService {
    Result<UserLoginVO> login(UserLoginDTO userLoginDTO);
}
