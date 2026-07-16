package com.cognizant.countryapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryApiApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CountryApiApplication.class, args);
        LOGGER.info("Country API started on port 8083");
    }
}
