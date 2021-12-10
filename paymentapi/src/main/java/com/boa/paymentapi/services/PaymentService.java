package com.boa.paymentapi.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.boa.paymentapi.models.Payment;
import com.boa.paymentapi.repositories.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
    @Autowired
	private PaymentRepository paymentRepository;
	

    private boolean status;
  //1. General topic with string payload
	
  	@Value(value = "${payment.topic.name}")
      private String paymentTopicName;
  	
  	@Autowired
      private KafkaTemplate<String, Payment> kafkaTemplate;
  	
  	public void sendMessage(long transactionId) 
	{
		
		Payment payment=paymentRepository.findById(transactionId).orElse(null);
		//publishing the data
		
		ListenableFuture<SendResult<String, Payment>> future 
			= this.kafkaTemplate.send(paymentTopicName, payment);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, Payment>>() {
            @Override
            public void onSuccess(SendResult<String, Payment> result) {
            	log.info("Sent message: " + payment.getOrder().getOrderId() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            	System.out.println("Sent message: " + payment.getOrder().getOrderAmount()
            			+ " with offset: " + result.getRecordMetadata().offset());
           // status=true;
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	log.error("Unable to send Payment Details : " + payment.getTransactionId(), ex);
              // status=false;
            }
       });
		
	}

	
}
