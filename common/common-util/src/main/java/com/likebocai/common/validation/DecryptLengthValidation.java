package com.likebocai.common.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.likebocai.common.context.ValidationContext;
import com.likebocai.common.utils.AESUtils;
import com.likebocai.common.validation.constraints.DecryptRuleByLength;
import jakarta.annotation.Resource;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @program: likebocai-java
 * @description: 解密后的校验规则
 * @author: LikeBocai
 * @create: 2024/12/7 19:35
 **/
@Slf4j
public class DecryptLengthValidation implements ConstraintValidator<DecryptRuleByLength,String> {

    private int minLength;

    private int maxLength;

    private String fileName;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void initialize(DecryptRuleByLength constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
        this.fileName = constraintAnnotation.fileName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 1.这里写将加密内容还原后，判断原内容的长短
        // 2.难点为 怎么获取到该类的时间戳来进行解密
        Object requestBody = ValidationContext.getRequestBody();
        Map<String,Object> fileNameMap = objectMapper.convertValue(requestBody,Map.class);
        String fileValue = fileNameMap.get(fileName).toString();
        String plainText = null;
        try {
            plainText = AESUtils.decrypt128(value, AESUtils.getSecretKeySpec128(fileValue), AESUtils.getIvParameterSpec128(fileValue));
        } catch (Exception e) {
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        }

        if (plainText == null || plainText.length() < minLength || plainText.length() > maxLength) {
            return false;
        }
        return true;
    }
}
