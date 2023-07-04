package com.ip.res4j.servicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceaApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplateBean(){
		return new RestTemplate();
	}

}
