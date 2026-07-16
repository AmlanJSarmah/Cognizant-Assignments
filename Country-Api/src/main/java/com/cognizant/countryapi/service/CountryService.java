package com.cognizant.countryapi.service;

import org.springframework.stereotype.Service;

import com.cognizant.countryapi.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {

    public Country getCountry(String code) {
        Map<String, Country> beans = new org.springframework.context.support
            .ClassPathXmlApplicationContext("country.xml")
            .getBeansOfType(Country.class);

        for (Country c : beans.values()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}
