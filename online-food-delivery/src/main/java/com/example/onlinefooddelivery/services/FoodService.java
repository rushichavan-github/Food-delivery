package com.example.onlinefooddelivery.services;

import java.util.List;

import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;

public interface FoodService {

	Food addFoodItem(Food food)throws FoodAlreadyExistsException;

	Food updateFoodItem(Food food)throws NoFoodFoundException;

	Food fetchById(long id)throws NoFoodFoundException;

	List<Food> fetchAllFoodItems();

	String deleteFoodById(long id)throws NoFoodFoundException;

}
