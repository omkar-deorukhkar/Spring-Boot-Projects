package com.demo.addressservice.service;

import com.demo.addressservice.entity.Address;
import com.demo.addressservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findAddressByEmployeeId(int id){
        Address addressByEmployeeId = addressRepository.findAddressByEmployeeId(id);
        return addressByEmployeeId;
    }
}
