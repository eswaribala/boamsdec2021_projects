package com.boa.customerdataapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerdataapi.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
