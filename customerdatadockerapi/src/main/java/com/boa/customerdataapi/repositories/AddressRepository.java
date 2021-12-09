package com.boa.customerdataapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerdataapi.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
