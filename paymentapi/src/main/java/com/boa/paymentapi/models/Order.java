package com.boa.paymentapi.models;

import lombok.Data;
@Data
public class Order {
	private long orderId;
	private String orderDate;
	private long orderAmount;
}
