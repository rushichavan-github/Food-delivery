package com.example.onlinefooddelivery.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "cart_id")
		private long cartId;
		private double price;
		private int quantity;
		@OneToOne
		@JoinColumn(name = "customer_id")
		private Customer customer;
		@OneToMany
		private List<Food> foodItem=new ArrayList<>();
}
