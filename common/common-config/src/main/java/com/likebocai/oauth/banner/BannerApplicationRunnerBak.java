package com.likebocai.oauth.banner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author likebocai
 * @description: 项目启动成功后，提供文档相关的地址
 * @date 2025/3/19 15:54
 */
@Slf4j
public class BannerApplicationRunnerBak implements ApplicationRunner {
    /**
     * @description:  编写Banner显示
     * @param: args
     * @return: void
     * @author likebocai
     * @date: 2025/3/19 15:57
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(
                " ██████████   ███████   ███████     ███████        1.这里我未来要用来检查权限表中是否有初始化数据，如果没有我就会插入!\n" +
                "░░░░░██░░░   ██░░░░░██ ░██░░░░██   ██░░░░░██       \n" +
                "    ░██     ██     ░░██░██    ░██ ██     ░░██  ██  \n" +
                "    ░██    ░██      ░██░██    ░██░██      ░██      \n" +
                "    ░██    ░██      ░██░██    ░██░██      ░██  ██  \n" +
                "    ░██    ░░██     ██ ░██    ██ ░░██     ██       \n" +
                "    ░██     ░░███████  ░███████   ░░███████        \n" +
                "    ░░       ░░░░░░░   ░░░░░░░     ░░░░░░░         \n");
    }
}
