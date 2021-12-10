package com.boa.paymentapi.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "Payments")
public class Payment {
    @Id
	private long transactionId;
	private boolean paymentStatus;
	private PaymentMode paymentMode;
	private Order order;
}
