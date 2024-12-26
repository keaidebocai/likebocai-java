package com.likebocai.common;

import com.likebocai.common.utils.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author likebocai
 * @date 2024/12/26 15:38
 * @description: TODO
 */
@Component
public class SnowflakeConfig {

    @Value("${snowflake.data-center-id}")
    private long dataCenterId;

    @Value("${snowflake.machine-id}")
    private long machineId;

    @Bean
    public SnowflakeIdGenerator snowflakeIdGenerator() {
        return new SnowflakeIdGenerator(dataCenterId, machineId);
    }
}
