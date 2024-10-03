package com.likebocai.common.exception;

import com.likebocai.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @program: likebocai-java
 * @description: 菠菜想你抛出了个异常
 * @author: LikeBocai
 * @create: 2024/8/30 13:29
 **/
@Data
public class LikeBocaiException extends RuntimeException {
    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public LikeBocaiException(ResultCodeEnum resultCodeEnum) {
        // 覆盖父类的 resultCodeEnum
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

}
