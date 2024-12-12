package com.payBook.paymentMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payBook.paymentMicroservice.entity.Payment;

public interface PaymentRepository  extends JpaRepository<Payment,Integer>{

}
