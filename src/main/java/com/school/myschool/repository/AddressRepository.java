package com.school.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.myschool.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	
}
