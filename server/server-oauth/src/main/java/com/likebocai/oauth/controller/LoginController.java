package com.likebocai.oauth.controller;

import com.likebocai.common.result.Result;
import com.likebocai.oauth.dto.UserLoginDTO;
import com.likebocai.oauth.dto.UserRegisterDTO;
import com.likebocai.oauth.service.LoginService;
import com.likebocai.oauth.vo.UserLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @author likebocai
     * @date 2024/12/26 16:40
     * @description: 注册接口 权限问题扔给申请权限的审批或者交给日后的自己
     */
    @Operation(summary = "注册接口", description = "注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        return loginService.register(userRegisterDTO);
    }

    /**
     * @description: 发送邮箱验证码
     * @param: email
     * @return: com.likebocai.common.result.Result<java.lang.Object>
     * @author likebocai
     * @date: 2025/3/7 17:26
     */
    @Operation(summary = "邮箱验证码", description = "发送邮箱验证码")
    @GetMapping("/email")
    public Result<Object> sendEmailCode(@Email(message = "邮箱格式错误") String email) {
        return loginService.sendEmailCode(email);
    }
}
