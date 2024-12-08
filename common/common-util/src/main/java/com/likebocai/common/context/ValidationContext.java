package com.likebocai.common.context;


public class ValidationContext {

    private static final ThreadLocal<Object> requestBody = new ThreadLocal<>();

    public static void setRequestBody(Object body) {
        requestBody.set(body);
    }

    public static Object getRequestBody() {
        return requestBody.get();
    }

    public static void clear() {
        requestBody.remove();
    }
}
