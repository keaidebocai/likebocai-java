package com.likebocai.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    FEIGN_FAIL(207, "远程调用失败"),
    UPDATE_ERROR(204, "数据更新失败"),

    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    SIGN_ERROR(300, "签名错误"),
    SIGN_OVERDUE(301, "签名已过期"),
    VALIDATECODE_ERROR(218 , "验证码错误/已过期"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    ACCOUNT_ERROR(214, "账号不正确"),
    PASSWORD_ERROR(215, "密码不正确"),
    PHONE_CODE_ERROR(215, "手机验证码不正确"),
    LOGIN_MOBLE_ERROR( 216, "账号不正确"),
    ACCOUNT_STOP( 216, "账号已停用"),
    NODE_ERROR( 217, "该节点下有子节点，不可以删除"),

    COB_NEW_ORDER_FAIL( 217, "抢单失败"),
    MAP_FAIL( 217, "地图服务调用失败"),
    PROFITSHARING_FAIL( 217, "分账调用失败"),
    NO_START_SERVICE( 217, "未开启代驾服务，不能更新位置信息"),
    DRIVER_START_LOCATION_DISTION_ERROR( 217, "距离代驾起始点1公里以内才能确认"),
    DRIVER_END_LOCATION_DISTION_ERROR( 217, "距离代驾终点2公里以内才能确认"),
    IMAGE_AUDITION_FAIL( 217, "图片审核不通过"),
    AUTH_ERROR( 217, "认证通过后才可以开启代驾服务"),
    FACE_ERROR( 250, "当日未进行人脸识别"),

    COUPON_EXPIRE( 250, "优惠券已过期"),
    COUPON_LESS( 250, "优惠券库存不足"),
    COUPON_USER_LIMIT( 250, "超出领取数量"),

    // 4xx
    /**
     * @author likebocai
     * @date 2024/12/20 16:18
     * @description: 429 账号被封禁5分钟,请稍后再试.
     */
    ACCOUNT_BAN(429,"账号被封禁5分钟,请稍后再试."),

    /**
     * @author likebocai
     * @date 2024/12/20 16:45
     * @description: 400 账户不存在/密码错误
     */
    LOGIN_ERROR(400,"账户不存在/密码错误"),
    /**
     * @author likebocai
     * @date 2024/12/26 15:14
     * @description: 401 没有权限
     */
    NOT_PERMISSION(401,"没有权限"),
    /**
     * @author likebocai
     * @date 2024/12/26 15:15
     * @description: 用户名已存在
     */
    USER_NAME_EXIST(402,"用户名已存在"),
    /**
     * @author likebocai
     * @date 2024/12/26 15:17
     * @description: 昵称已存在
     */
    NICK_NAME_EXIST(403,"昵称已存在"),
    /**
     * @author likebocai
     * @date 2024/12/26 15:19
     * @description: 404 资源未被找到
     */
    NOT_FOUND_404(404,"资源未被找到"),
    /**
     * @author likebocai
     * @date 2024/12/26 15:17
     * @description: 邮箱已被注册过
     */
    EMAIL_ALREADY(405,"邮箱已被注册"),
    // 5xx
    /**
     * @author likebocai
     * @date 2024/12/20 16:31
     * @description: 后台出错,请联系管理员.
     */
    SYSTEM_ERROR(500,"后台出错,请联系管理员."),
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
