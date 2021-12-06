package com.boa.customerdataapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerdataapi.models.Address;
import com.boa.customerdataapi.models.Customer;
import com.boa.customerdataapi.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired 
	private CustomerRepository customerRepository;
    
    //crud
    //insert
    public Customer saveCustomer(Customer customer) {
    	
    	
    	if(customer.getAddresses().size()>0) {
    		for(Address address : customer.getAddresses()) {
    			address.setCustomer(customer);
    		}
    	}
    	
    	return this.customerRepository.save(customer);
    	
    }
    
    //select
    
    public List<Customer> getAllCustomers(){
    	return this.customerRepository.findAll();
    }
    
    
    public Customer getCustomerById(long customerId) {
    	return this.customerRepository.findById(customerId).orElse(null);
    }
    
    
    //delete
    
    public boolean deleteCustomerById(long customerId) {
    	this.customerRepository.deleteById(customerId);
    	boolean status=false;
    	if(getCustomerById(customerId)==null)
    	  status=true;
    	return status;
    }
    
}
