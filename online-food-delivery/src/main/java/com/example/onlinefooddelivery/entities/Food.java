package com.example.onlinefooddelivery.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	@Id	
	@Column(name = "food_id")
	private long foodId;
	@NotNull
	private String foodName;
	@NotNull
	private double foodCost;
	private int quantity;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "catId")
	private Category category;
	
	
}
