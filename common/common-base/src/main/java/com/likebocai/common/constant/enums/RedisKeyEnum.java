package com.likebocai.common.constant.enums;

import lombok.Getter;

/**
 * @program: likebocai-java
 * @description: redis key 的前缀
 * @author: LikeBocai
 * @create: 2024/12/7 11:38
 **/
@Getter
public enum RedisKeyEnum {

    /**
     * @author likebocai
     * @date 2024/12/20 15:51
     * @description: 用户登录次数检查
     */
    LOGIN_CHECK_NUMBER("login:check"),

    /**
     * @author likebocai
     * @date 2024/12/20 16:50
     * @description: 用户临时令牌
     */
    ACCOUNT_TOKEN("account"),

    /**
     * @author likebocai
     * @date 2024/12/20 16:51
     * @description: 用户的刷新令牌
     */
    REFRESH_TOKEN("refresh"),

    /**
     * @author likebocai
     * @date 2024/12/26 16:09
     * @description: 邮箱验证码
     */
    EMAIL_CODE("emailCode"),
    ;

    /**
     * @author likebocai
     * @date 2024/12/20 16:04
     * @description: redis key 为 5 过期时间
     */
    public static final Long TIME_OUT_FIVE = 5L;

    public static final Long TIME_OUT_THIRTY = 30L;

    public static final Long TIME_OUT_FIFTEEN = 15L;

    private final String prefix ;

    RedisKeyEnum(String prefix) {
        this.prefix = prefix;
    }

    public String concat(Object context) {
        return this.prefix + ":" + context.toString();
    }

    public String concat(Object... values) {
        StringBuffer sb = new StringBuffer(45);
        sb.append(this.prefix);
        for (Object value : values) {
            sb.append(":").append(value.toString());
        }
        return sb.toString();
    }

}
