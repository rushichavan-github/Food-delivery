package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;
import com.example.onlinefooddelivery.repositories.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Override
	public Food addFoodItem(Food food) throws FoodAlreadyExistsException {
		if(foodRepo.existsById(food.getFoodId()))
			throw new FoodAlreadyExistsException();
		Food addedFood = foodRepo.save(food); 
		return addedFood;
	}

	@Override
	public Food updateFoodItem(Food food) throws NoFoodFoundException {
		if(foodRepo.existsById(food.getFoodId())) {
		Food updatefood = foodRepo.save(food);
		return updatefood;
		}
		else {
			throw new NoFoodFoundException();
		}
		
	}

	@Override
	public Food fetchById(long id) throws NoFoodFoundException {
		if(foodRepo.existsById(id))
			return foodRepo.findById(id).get();
		else {
			throw new NoFoodFoundException();
		}
	}

	@Override
	public List<Food> fetchAllFoodItems() {
		return foodRepo.findAll();
	}

	@Override
	public String deleteFoodById(long id) throws NoFoodFoundException {
		if(foodRepo.existsById(id)) {
			foodRepo.deleteById(id);
			return "Food item deleted Successfully";
		}
		else {
			throw new NoFoodFoundException();
		}
	}

}
