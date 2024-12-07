package com.likebocai.common.exception;

import com.likebocai.common.result.Result;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: likebocai-java
 * @description: 全局异常处理
 * @author: LikeBocai
 * @create: 2024/8/30 13:18
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 自定义异常处理
    @ExceptionHandler(LikeBocaiException.class)
    public Result error(LikeBocaiException e) {
        return Result.build(null,e.getResultCodeEnum());
    }

    // 数据校验异常处理
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Result<?> handleValidException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Map<String,StringBuilder> messageMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            messageMap.putIfAbsent(field, new StringBuilder());
            messageMap.computeIfPresent(field,(k,v) -> v.append(message).append(";"));
        }
        return Result.build(messageMap,400,"请校验参数");
    }

}
