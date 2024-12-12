package com.payBook.orderMicroservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Data
@Table(name="ORDER_DB")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	
	@Id
	private int id;
	private String name;
	private int qty;
	private double price;

}
