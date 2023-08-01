package com.studentdata.studentdata.repository;

import com.studentdata.studentdata.entity.Address; //  get student from the entity/Address.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // learn more about repository
public interface AddressRepository extends JpaRepository<Address,String> {
    
}
