package com.boa.shippingapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ShippingFacade {

	String INPUT = "shipping-in";
	   
    @Input(INPUT)
    MessageChannel inboundInventory();

}
