package com.likebocai.oauth.po;

import java.io.Serializable;
import java.util.Date;

/**
* 角色权限关联表
* @TableName oauth_role_permission
*/
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
    private Integer isDeleted;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
}
