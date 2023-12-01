package com.suhan.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.suhan"})
public class SuApplication {

    public static void main(String[] args) {
        log.info("system start!");
        SpringApplication.run(SuApplication.class, args);
    }
}
