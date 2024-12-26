package com.likebocai.oauth.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 角色表
* @TableName oauth_role
*/
@Getter
@Setter
@ToString
public class OauthRolePO implements Serializable {

    /**
    * 角色表,主键
    */
    private Long id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String roleDesc;
    /**
    * 角色是否有效(1: 有效,0: 无效)
    */
    private Integer isActive;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
    /**
    * 逻辑删除(1: 删除,0:未删除)
    */
    private Integer deleted;
}
