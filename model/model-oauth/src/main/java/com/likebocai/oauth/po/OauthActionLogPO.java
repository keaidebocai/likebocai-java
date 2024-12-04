package com.likebocai.oauth.po;

import lombok.*;

import java.io.Serializable;

import java.util.Date;

/**
* 用户行为记录日志表
* @TableName oauth_action_log
*/
@Getter
@Setter
@ToString
public class OauthActionLogPO implements Serializable {

    /**
    * 用户行为记录日志表,主键
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 行为类型，例如：0: 登录,1: 查看页面, 2:更新操作
    */
    private Integer actionType;
    /**
    * 具体行为，页面路径，或更新的接口信息
    */
    private String actionDetail;
    /**
    * 国家
    */
    private String userNation;
    /**
    * 省份
    */
    private String userProvince;
    /**
    * 城市
    */
    private String userCity;
    /**
    * 所在区
    */
    private String userDistrict;
    /**
    * 用户的设备信息或浏览器标识
    */
    private String userAgent;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 用户的IP地址，适配IPv4和IPv6
    */
    private byte[] ipAdder;
}
