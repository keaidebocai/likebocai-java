package com.likebocai.common.interceptor;

import com.likebocai.common.context.ValidationContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class ValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 这里肯定没上下文，打个日志给你看看
        log.debug("RequestBodyInterceptor -> preHandle");
        Object threadLocalObject = ValidationContext.getRequestBody();
        if (threadLocalObject != null) {
            log.info("你要是看到我，那就出大问题了" + threadLocalObject);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.debug("RequestBodyInterceptor -> postHandle -> clear");
        // 请求处理完后清理 ThreadLocal
        ValidationContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.debug("RequestBodyInterceptor -> afterCompletion -> clear");
        // 请求完成后清理 ThreadLocal
        ValidationContext.clear();
    }
}
