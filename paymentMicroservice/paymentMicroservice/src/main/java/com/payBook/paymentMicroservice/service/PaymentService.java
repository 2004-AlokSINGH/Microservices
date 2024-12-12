package com.payBook.paymentMicroservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payBook.paymentMicroservice.entity.Payment;
import com.payBook.paymentMicroservice.repository.PaymentRepository;

@Service
public class PaymentService {
	
	
	@Autowired
	private PaymentRepository payRepo;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		String k=UUID.randomUUID().toString();

		payment.setTransactionId(k);
		return payRepo.save(payment);
		
	}
	
	public String paymentProcessing() {
	    // api should be 3rd party payment gateway
	    return new Random().nextBoolean() ? "success" : "false";
	}


}
