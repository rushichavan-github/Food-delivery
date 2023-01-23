package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public interface FoodService {

	Food addFoodItem(@Valid Food food)throws FoodAlreadyExistsException;

	Food updateFoodItem(@Valid Food food)throws NoFoodFoundException;

	Food fetchById(@Min(1) long id)throws NoFoodFoundException;

	List<Food> fetchAllFoodItems();

	String deleteFoodById(@Min(1) long id)throws NoFoodFoundException;

}
