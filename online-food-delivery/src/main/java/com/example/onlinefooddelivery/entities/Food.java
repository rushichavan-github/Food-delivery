package com.example.onlinefooddelivery.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private long foodId;
	@NotNull
	private String foodName;
	@NotNull
	private double foodCost;
	private int quantity;
	@OneToOne
	@JoinColumn(name = "category_Id")
	private Category category;
	
	
}
