package com.likebocai.oauth.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 角色权限关联表
* @TableName oauth_role_permission
*/
@Getter
@Setter
@ToString
public class OauthRolePermission implements Serializable {

    /**
    * 角色权限关联表
    */
    private Long id;
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 权限id
    */
    private Long permissionId;
    /**
    * 逻辑删除(1: 删除,0:未删除)
    */
    private Integer deleted;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
}
