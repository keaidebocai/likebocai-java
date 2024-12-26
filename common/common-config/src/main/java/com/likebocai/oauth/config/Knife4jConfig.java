package com.likebocai.oauth.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    /**
     * mall-product 产品api分组
    **/
    @Bean
    public GroupedOpenApi blogTestApi() {
        return GroupedOpenApi.builder()
                .group("oauth-登录模块")
                .pathsToMatch("/**")
                .build();
    }
    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("菠菜的小窝-oauth-接口文档")
                        .version("3.0.0")
                        .description("菠菜的小窝-oauth-接口文档")
                        .contact(new Contact().name("likebocai"))
                        .termsOfService("https://www.likebocai.com")
                        .contact(
                                new Contact()
                                        .name("likebocai")
                                        .url("https://www.likebocai.com")
                                        .email("likebocai@qq.com")
                        )
                );
    }
}
