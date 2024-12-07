package com.likebocai.common.validation.constraints;

import com.likebocai.common.validation.DecryptLengthValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DecryptLengthValidation.class)
public @interface DecryptRuleByLength {

    String message() default "此数据输入格式有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @author: LikeBocai
     * @description: 最小长度
    */
    int minLength() default 0;

    /**
     * @author: LikeBocai
     * @description: 最大长度
    */
    int maxLength() default 2147483647;

    /**
     * @author: LikeBocai
     * @description: 根据该字段进行解密
    */
    String fileName() default "";

}
