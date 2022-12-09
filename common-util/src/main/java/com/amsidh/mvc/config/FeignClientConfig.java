package com.amsidh.mvc.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
