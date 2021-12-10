package com.boa.paymentapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.paymentapi.models.Payment;

public interface PaymentRepository extends MongoRepository<Payment,Long>{

}
