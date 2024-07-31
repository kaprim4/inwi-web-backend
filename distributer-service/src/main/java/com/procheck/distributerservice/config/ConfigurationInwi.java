package com.procheck.distributerservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationInwi {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
