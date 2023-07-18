package com.demo.employeeservice.service;

import com.demo.employeeservice.entity.Address;
import com.demo.employeeservice.entity.Employee;
import com.demo.employeeservice.models.EmployeeResponse;
import com.demo.employeeservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(addressBaseUrl).build();
    }

    public EmployeeResponse getEmployeeById(int id){
        Optional<Employee> employee = employeeRepository.findById(id);
//        EmployeeResponse employeeResponse = new EmployeeResponse();

        EmployeeResponse employeeResponse = modelMapper.map(employee.get(), EmployeeResponse.class);
        Address address = restTemplate.getForObject("/address/{id}", Address.class, id);
        employeeResponse.setAddress(address);

//        employeeResponse.setEmpId(employee.get().getEmpId());
//        employeeResponse.setName(employee.get().getName());
//        employeeResponse.setEmail(employee.get().getEmail());
//        employeeResponse.setBloodGroup(employee.get().getBloodGroup());

        return employeeResponse;
    }
}
