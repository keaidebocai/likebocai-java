package com.likebocai.oauth.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.time.LocalDateTime;

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
    //此注解用来接收字符串类型的参数封装成LocalDateTime类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //此注解将date类型数据转成字符串响应出去
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", shape = JsonFormat.Shape.STRING)
    // 反序列化
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    // 序列化
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;
    /**
    * 用户的IP地址，适配IPv4和IPv6
    */
    private byte[] ipAdder;
}
