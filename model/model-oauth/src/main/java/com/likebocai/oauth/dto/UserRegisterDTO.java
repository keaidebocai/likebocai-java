package com.likebocai.oauth.dto;

import com.likebocai.common.validation.constraints.DecryptRuleByLength;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author likebocai
 * @date 2024/12/26 11:05
 * @description: 用户注册接收类
 */
@Data
@Schema(name = "UserRegisterDTO", title = "用户注册信息", description = "接收用户从前端传来的注册信息等")
public class UserRegisterDTO {

    private Long id;

    @Schema(name = "userName", title = "用户名", description = "6-30位的用户名", minLength = 6, maxLength = 30)
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 30, message = "用户名的长度需在6-30")
    private String userName;

    @Schema(name = "password", title = "密码", description = "密文密码")
    @NotBlank(message = "密码不能为空")
    @DecryptRuleByLength(minLength = 8, maxLength = 16, message = "密码的长度需在{minLength}-{maxLength}位", fileName = "timeStamp")
    private String password;

    @Schema(name = "timeStamp", title = "时间戳", description = "毫秒级")
    @NotNull(message = "时间戳不能为空")
    private Long timeStamp;

    @Schema(name = "nickName", title = "昵称", description = "6-30位的昵称", minLength = 6, maxLength = 30)
    @NotBlank(message = "昵称不能为空")
    @Length(min = 2, max = 30, message = "昵称的长度需在6-30")
    private String nickName;

    @Schema(name = "userEmail", title = "邮箱", description = "用户注册用邮箱")
    @Email(message = "邮箱格式不正确")
    @Length(min = 8, max = 100, message = "邮箱长度不得小于8位")
    private String userEmail;

    @Schema(name = "userSex", title = "性别", description = "用户性别")
    @Min(value = 0, message = "0: 未知,1: 男,2: 女, 3: 阿帕奇武装直升机")
    @Max(value = 3, message = "0: 未知,1: 男,2: 女, 3: 阿帕奇武装直升机")
    private Integer userSex;

    @Schema(name = "emailCode", title = "邮箱验证码", description = "5分钟内的邮箱验证码")
    @NotBlank(message = "邮箱验证码不能为空")
    @Length(min = 6, max = 6, message = "邮箱验证码必须为6位")
    private String emailCode;

}
