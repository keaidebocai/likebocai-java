package com.likebocai.oauth.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 权限表
* @TableName oauth_permission
*/
@Getter
@Setter
@ToString
public class OauthPermissionPO implements Serializable {

    /**
    * 权限表,主键
    */
    private Long id;
    /**
    * 权限名称
    */
    private String permissionName;
    /**
    * 权限描述
    */
    private String permissionDesc;
    /**
    * 该权限下所需要的uri
    */
    private String permissionUri;
    /**
    * 权限是否有效(1: 有效,0: 无效)
    */
    private Integer isActive;
    /**
    * 逻辑删除(1: 删除,0:未删除)
    */
    private Integer isDeleted;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
}
