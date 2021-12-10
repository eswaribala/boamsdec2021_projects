package com.boa.orderapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderFacade {

	String OUTPUT = "order-out";
	   
    @Output(OUTPUT)
    MessageChannel outboundInventory();

}
