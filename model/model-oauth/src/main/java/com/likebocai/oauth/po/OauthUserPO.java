package com.likebocai.oauth.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 用户基本的信息表
* @TableName oauth_user
*/
@Getter
@Setter
@ToString
public class OauthUserPO implements Serializable {

    /**
    * 主键，雪花算法
    */
    private Long id;
    /**
    * 用户名,用于登录
    */
    private String userName;
    /**
    * 加密后的密码(Argon2复合加密，设置为128位)
    */
    private String password;
    /**
     * 用户昵称，用于显示
     */
    private String nickName;
    /**
    * 用户的邮箱
    */
    private String userEmail;
    /**
    * 性别(0: 未知,1: 男,2: 女, 3: 阿帕奇武装直升机)
    */
    private Integer userSex;
    /**
    * 用户的角色信息
    */
    private Long roleId;
    /**
    * 用户账户状态(0: 正常,1: 审核中,2: 封禁)
    */
    private Integer userStatus;
    /**
    * 逻辑删除(1: 删除,0:未删除)
    */
    private Integer isDeleted;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更改时间
    */
    private LocalDateTime updateTime;
}
