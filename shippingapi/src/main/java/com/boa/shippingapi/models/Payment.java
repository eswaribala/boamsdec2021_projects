package com.boa.shippingapi.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;


import lombok.Data;
@Data

public class Payment {
    @Id
	private long transactionId;
	private boolean paymentStatus;
	private PaymentMode paymentMode;
	private Order order;
}
