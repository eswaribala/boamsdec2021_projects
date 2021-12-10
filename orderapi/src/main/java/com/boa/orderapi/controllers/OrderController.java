package com.boa.orderapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.orderapi.models.Order;
import com.boa.orderapi.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
    
    @PostMapping({"/v1.0", "/v1.1"})

    public ResponseEntity<?> publishData(@RequestBody Order order){
    	
    	if(this.orderService.publishOrder(order))
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Order Published "+order.getOrderId());
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order Not Published");
    }
    
}
