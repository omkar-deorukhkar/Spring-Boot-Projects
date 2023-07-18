package com.demo.addressservice.repository;

import com.demo.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "SELECT addr.id, addr.lane1, addr.lane2, addr.zipcode FROM demoservice.address addr INNER JOIN demoservice.employee emp ON addr.employee_id=emp.id WHERE emp.id= :employeeId")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
