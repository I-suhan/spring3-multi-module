package com.suhan.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.suhan"})
@EntityScan(basePackages = "com.suhan.*.entity")
public class SuApplication {

    public static void main(String[] args) {
        log.info("system start!");
        SpringApplication.run(SuApplication.class, args);
    }
}
