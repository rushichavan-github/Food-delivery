package com.example.onlinefooddelivery.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order_details")
public class Order{
		@Id
		private long orderId;
		private LocalDate orderDate;
		private String orderStatus;
		private long cartId;
		
		@ManyToOne
		@JoinColumn(name="customer_id")
		private Customer customer;
}
