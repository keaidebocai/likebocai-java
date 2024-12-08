package com.likebocai.common.converter;

import com.likebocai.common.context.ValidationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
@Slf4j
/**
 * @author: LikeBocai
 * @description: 用于重写read方法，获取对象后将它存到上下文中
**/
public class ValidationHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 调用父类方法进行常规的 JSON -> Java 对象转换
        Object result = super.read(type, contextClass, inputMessage);
        log.debug("RequestBodyHttpMessageConverter -> read -> 解析json转为对象");

        // 无侵入式的将转换后的对象存储到 ThreadLocal 中
        if (result != null) {
            // 将转换后的对象存入 ThreadLocal
            ValidationContext.setRequestBody(result);
            log.debug("RequestBodyHttpMessageConverter 将转换后的对象存入 ThreadLocal");
        }

        // 不要改变对象，返回对象给下文
        return result;
    }
}
