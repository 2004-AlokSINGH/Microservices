package com.payBook.orderMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payBook.orderMicroservice.common.Payment;
import com.payBook.orderMicroservice.common.TransactionRequest;
import com.payBook.orderMicroservice.common.TransactionResponse;
import com.payBook.orderMicroservice.entity.Order;
import com.payBook.orderMicroservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderserv;
	
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest req) {		
		return orderserv.saveOrder(req);
		
		// do a rest call to payemnt and pass order id
		
	}

}
