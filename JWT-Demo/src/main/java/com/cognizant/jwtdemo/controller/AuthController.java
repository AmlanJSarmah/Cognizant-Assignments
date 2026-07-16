package com.cognizant.jwtdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwtdemo.model.JwtResponse;
import com.cognizant.jwtdemo.service.JwtService;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtService jwtService;

    @GetMapping("/authenticate")
    public JwtResponse authenticate(Authentication authentication) {
        LOGGER.info("Start");
        String username = authentication.getName();
        String token = jwtService.generateToken(username);
        LOGGER.info("End");
        return new JwtResponse(token);
    }
}
