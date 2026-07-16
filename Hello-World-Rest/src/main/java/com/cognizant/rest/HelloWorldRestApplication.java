package com.cognizant.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldRestApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldRestApplication.class, args);
        LOGGER.info("Hello World REST application started on port 8083");
    }
}
