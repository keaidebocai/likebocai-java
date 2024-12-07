package com.likebocai.oauth.controller;

import com.likebocai.common.result.Result;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.service.LoginService;
import com.likebocai.oauth.vo.UserLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: likebocai-java
 * @description: 登录相关控制层
 * @author: LikeBocai
 * @create: 2024/12/7 11:39
 **/
@RestController
@Tag(name = "登录页面相关接口",description = "登陆界面相关接口")
@RequestMapping("/api/v3/oauth")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Operation(summary = "登录接口",description = "返回用户的token")
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        return loginService.login(userLoginDTO);
    }

}
