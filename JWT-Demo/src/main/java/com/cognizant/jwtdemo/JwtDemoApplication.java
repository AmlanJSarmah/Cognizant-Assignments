package com.cognizant.jwtdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
        LOGGER.info("JWT Demo application started on port 8090");
    }
}
