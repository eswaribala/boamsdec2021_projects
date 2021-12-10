package com.boa.shippingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.boa.shippingapi.facades.ShippingFacade;
import com.boa.shippingapi.models.Payment;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableBinding(ShippingFacade.class)
public class ShippingapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingapiApplication.class, args);
	}

	@StreamListener(target = ShippingFacade.INPUT)
    public void handlePayment(@Payload Payment payment) {
     log.info("invoked.....");   
	 log.info("Received Payment details: {}",payment);
    }

}
