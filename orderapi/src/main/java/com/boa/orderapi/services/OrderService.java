package com.boa.orderapi.services;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.orderapi.facades.OrderFacade;
import com.boa.orderapi.models.Order;

@Service
public class OrderService {

	private OrderFacade orderFacade;
	
	public OrderService(OrderFacade _orderFacade) {
		
		this.orderFacade=_orderFacade;
		}
	
	
	public boolean publishOrder(Order order) {
		MessageChannel messageChannel = orderFacade.outboundInventory();
	       return  messageChannel.send(MessageBuilder
	                .withPayload(order)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());


	}
	
}
