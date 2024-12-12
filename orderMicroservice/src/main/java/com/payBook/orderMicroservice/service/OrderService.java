package com.payBook.orderMicroservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payBook.orderMicroservice.common.Payment;
import com.payBook.orderMicroservice.common.TransactionRequest;
import com.payBook.orderMicroservice.common.TransactionResponse;
import com.payBook.orderMicroservice.entity.Order;
import com.payBook.orderMicroservice.repository.OrderRepository;




@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest req) {
		
			
		String response="";
		
		Order order=req.getOrder();
		Payment payment=req.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		

		// rest call
		Payment payResponse=template.postForObject("http://localhost:9091/payment/doPayment", payment, Payment.class);
		
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(payResponse.getPaymentStatus());
		

		response = payResponse.getPaymentStatus().equals("success") ? "payment processing success" : "Failure in payment Api";

		orderRepo.save(order);
		
		
		return new TransactionResponse(order,payResponse.getTransactionId(),payResponse.getAmount(),response);
		
	}

}
