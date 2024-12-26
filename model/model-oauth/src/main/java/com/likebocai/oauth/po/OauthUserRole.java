package com.likebocai.oauth.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author likebocai
 * @date 2024/12/26 10:56
 * @description: 角色权限表
 */
@Getter
@Setter
@ToString
public class OauthUserRole {
    /**
     * 角色权限表,主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 逻辑删除(1: 删除,0:未删除)
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
