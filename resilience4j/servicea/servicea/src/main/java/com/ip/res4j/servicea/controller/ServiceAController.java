package com.ip.res4j.servicea.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;
    private static final String SERVICE_A = "serviceA";
    private String url = "http://localhost:8081/b/message";
    int Count=0;
    @GetMapping("/message")
//    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "getMessageCallback")
//    @Retry(name = SERVICE_A)
    @RateLimiter(name = SERVICE_A)
    public String getMessage(){
        Count++;
        System.out.println("COUNT : " + Count);
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    public String getMessageCallback(Exception e){
        return "This is a fallback method for method A";
    }
}
