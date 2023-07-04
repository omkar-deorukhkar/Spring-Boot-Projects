package com.ip.res4j.serviceb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class ServiceBController {

    @GetMapping("/message")
    public String getMessage() throws InterruptedException {
//        Thread.sleep(5000);
        return "Service A has called Service B !!";
    }
}
