package com.likebocai.common.validation;

import com.likebocai.common.validation.constraints.DecryptRuleByLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @program: likebocai-java
 * @description: 解密后的校验规则
 * @author: LikeBocai
 * @create: 2024/12/7 19:35
 **/

public class DecryptLengthValidation implements ConstraintValidator<DecryptRuleByLength,String> {

    private int minLength;

    private int maxLength;

    private String fileName;

    @Override
    public void initialize(DecryptRuleByLength constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
        this.fileName = constraintAnnotation.fileName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO: 这里写将加密内容还原后，判断原内容的长短
        // TODO: 难点为 怎么获取到该类的时间戳来进行解密
        if (value == null || value.length() < minLength || value.length() > maxLength) {
            return false;
        }
        return true;
    }
}
