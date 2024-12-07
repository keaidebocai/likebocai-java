package com.likebocai.oauth.dto;

import com.likebocai.common.validation.constraints.DecryptRuleByLength;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @program: likebocai-java
 * @description: 接收用户登录信息
 * @author: LikeBocai
 * @create: 2024/12/7 16:33
 **/
@Schema(name = "UserLoginDTO", title = "用户登录信息", description = "接收用户从前端传来的用户密码等")
@Data
public class UserLoginDTO {

    @Schema(name = "userName", title = "用户名", description = "6-30位的用户名", minLength = 6, maxLength = 30)
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 30, message = "用户名的长度需在6-30")
    private String userName;

    @Schema(name = "password", title = "密码", description = "密文密码")
    @NotBlank(message = "密码不能为空")
    @DecryptRuleByLength(minLength = 5, maxLength = 10, message = "密码的长度需在{minLength}-{maxLength}位", fileName = "timeStamp")
    private String password;

    @Schema(name = "timeStamp", title = "时间戳", description = "毫秒级")
    @NotNull(message = "时间戳不能为空")
    private Long timeStamp;

}
