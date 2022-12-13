package com.amsidh.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class HealthController {

    @Value("${spring.application.name:default-service}")
    private String serviceName;

    public HealthController() {
        log.info("Loading HealthController class");
    }

    @GetMapping
    public String healthCheck() {
        log.info("Inside healthCheck of class HealthController of {}", serviceName);
        return String.format("Service %s is up and running", serviceName);
    }
}
