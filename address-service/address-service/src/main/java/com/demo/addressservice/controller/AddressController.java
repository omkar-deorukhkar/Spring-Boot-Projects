package com.demo.addressservice.controller;

import com.demo.addressservice.entity.Address;
import com.demo.addressservice.repository.AddressRepository;
import com.demo.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{empId}")
    public ResponseEntity<Address> getAddressByEmployeeId(@PathVariable("empId") int id){
        Address addressByEmployeeId = addressService.findAddressByEmployeeId(id);
        return new ResponseEntity<>(addressByEmployeeId, HttpStatus.OK);
    }
}
