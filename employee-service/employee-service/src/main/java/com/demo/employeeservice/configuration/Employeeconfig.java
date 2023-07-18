package com.demo.employeeservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Employeeconfig {
    @Bean
    public ModelMapper getModelMapperBean(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate getRestTemplateBean(){
        return new RestTemplate();
    }
}
