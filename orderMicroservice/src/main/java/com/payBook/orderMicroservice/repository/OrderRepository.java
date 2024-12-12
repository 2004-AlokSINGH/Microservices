package com.payBook.orderMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payBook.orderMicroservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
