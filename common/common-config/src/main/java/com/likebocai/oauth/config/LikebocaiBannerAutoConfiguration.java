package com.likebocai.oauth.config;

import com.likebocai.oauth.banner.BannerApplicationRunnerBak;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author likebocai
 * @description: Banner的自动配置类
 * @date 2025/3/19 16:12
 */
@AutoConfiguration
public class LikebocaiBannerAutoConfiguration {


    @Bean
    public BannerApplicationRunnerBak bannerApplicationRunner() {
        return new BannerApplicationRunnerBak();
    }
}
