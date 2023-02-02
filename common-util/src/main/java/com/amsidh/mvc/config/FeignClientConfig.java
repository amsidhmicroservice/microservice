package com.amsidh.mvc.config;

import com.amsidh.mvc.feign.logger.FeignCustomLogger;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class FeignClientConfig {

    @Bean
    Logger feignLoggerLevel() {
        return new FeignCustomLogger();
    }

}
