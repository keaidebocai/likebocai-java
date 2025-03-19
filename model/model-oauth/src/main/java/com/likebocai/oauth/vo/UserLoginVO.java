package com.likebocai.oauth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: likebocai-java
 * @description: 用户登录返回的参数
 * @author: LikeBocai
 * @create: 2024/12/7 17:22
 **/
@Schema(name = "UserLoginVO", title = "用户登录返回体", description = "双token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO {

    @Schema(name = "accessToken", title = "token", description = "过期时间较短，储存用户信息权限")
    private String accessToken;

    @Schema(name = "refreshToken", title = "刷新token", description = "过期时间较长，不储存额外信息，只储存用户id")
    private String refreshToken;

}
