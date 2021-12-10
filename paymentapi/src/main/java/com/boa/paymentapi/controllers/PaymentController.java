package com.boa.paymentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.paymentapi.models.Payment;
import com.boa.paymentapi.services.PaymentService;


@RestController

public class PaymentController {
   @Autowired
	private PaymentService paymentService;
	  
    @PostMapping("/payments/{transactionId}")

    public ResponseEntity<?> publishData(@PathVariable("transactionId") String transactionId){
    	
    	 this.paymentService.sendMessage(Long.parseLong(transactionId));
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Payment Details Published");
    }
}
