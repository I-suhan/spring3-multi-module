package com.suhan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.suhan"})
public class SuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuApplication.class, args);
    }
}
