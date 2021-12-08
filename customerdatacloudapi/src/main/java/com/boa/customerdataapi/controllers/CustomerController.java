package com.boa.customerdataapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerdataapi.models.Customer;
import com.boa.customerdataapi.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@RefreshScope
@Slf4j
public class CustomerController {
    @Autowired
	private CustomerService customerService;    
    @Value("${message}")
    private String message;
    @PostMapping({"/v1.0", "/v1.1"})
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
    	
    	if(this.customerService.saveCustomer(customer)!=null)
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
    	
    }
    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping({"/v1.0", "/v1.1"})
    public List<Customer> fetchAllCustomers(){
    	//test message change
    	log.info("Message Modified in Github"+message);
    	return this.customerService.getAllCustomers();
    }
    
    @GetMapping({"/v1.0/{customerId}", "/v1.1/{customerId}"})
    public Customer fecthCustomerById(@PathVariable("customerId") long customerId){
    	return this.customerService.getCustomerById(customerId);
    }
    
    @DeleteMapping({"/v1.0/{customerId}", "/v1.1/{customerId}"})
    public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId){
    	if(this.customerService.deleteCustomerById(customerId))
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer Deleted");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Deleted");
    }
}
