package com.likebocai.blog.dto;

import jakarta.validation.constraints.Max;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @program: likebocai-java
 * @description:
 * @author: LikeBocai
 * @create: 2024/8/30 13:50
 **/
@Data
public class TestDto {

    @Length(max = 6,message = "必须在0~6位")
    private String name;

    @Length(max = 3,message = "必须在0~3位")
    private String password;
}
