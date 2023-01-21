package com.example.onlinefooddelivery.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
		@Column(name = "cart_id")
		private long cartId;
		@OneToOne
		@JoinColumn(name = "customer_id")
		private Customer customer;
		@OneToMany
		private List<Food> foodItem;
}
