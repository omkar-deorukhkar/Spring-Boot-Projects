package com.demo.employeeservice.controller;

import com.demo.employeeservice.entity.Employee;
import com.demo.employeeservice.models.EmployeeResponse;
import com.demo.employeeservice.repository.EmployeeRepository;
import com.demo.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/info/")
    public String getInfo(){
        return "Employee Service is running";
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") int id){
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
}
