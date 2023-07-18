package com.demo.employeeservice.repository;

import com.demo.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

}
