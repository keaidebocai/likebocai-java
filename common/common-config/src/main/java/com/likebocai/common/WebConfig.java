package com.likebocai.common;

import com.likebocai.common.converter.ValidationHttpMessageConverter;
import com.likebocai.common.interceptor.ValidationInterceptor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private ValidationHttpMessageConverter validationHttpMessageConverter;
    @Resource
    private ValidationInterceptor validationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO: 这里建议后面好好规划一下url路径，缩小该拦截器的范围
        registry.addInterceptor(validationInterceptor).addPathPatterns("/api/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 将自定义的消息转换器添加到 Spring MVC 的消息转换器列表中
        converters.add(validationHttpMessageConverter);
    }
}
