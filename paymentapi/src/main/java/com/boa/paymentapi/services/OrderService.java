package com.boa.paymentapi.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.boa.paymentapi.models.Order;
import com.boa.paymentapi.models.Payment;
import com.boa.paymentapi.models.PaymentMode;
import com.boa.paymentapi.repositories.PaymentRepository;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
    @Autowired
	private PaymentRepository paymentRespository;
	
    @KafkaListener(topics = "${order.topic.name}", 
			groupId = "${order.topic.group.id}")
    public void consume(String message) {
		log.info(String.format("Message recieved -> %s", message));
		
		Gson gson=new Gson();
		
		Order order= gson.fromJson(message, Order.class);
		
		  
		log.info(""+order.getOrderId());
		
		Payment payment=new Payment();
		payment.setTransactionId(new Random().nextInt(10000000));
		payment.setPaymentMode(PaymentMode.Cash);
		payment.setPaymentStatus(true);
		payment.setOrder(order);
		this.paymentRespository.save(payment);
		
	}


}
