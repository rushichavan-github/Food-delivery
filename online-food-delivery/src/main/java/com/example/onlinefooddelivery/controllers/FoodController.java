package com.example.onlinefooddelivery.controllers;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;
import com.example.onlinefooddelivery.services.FoodService;

@RestController
@RequestMapping("/foodItem")
public class FoodController {
	
	@Autowired
	private FoodService foodServ;
	
	@PostMapping("/add")
	public ResponseEntity<Food> addFoodItem(@RequestBody Food food) throws FoodAlreadyExistsException{
		Food savedFood = foodServ.addFoodItem(food);
		return new ResponseEntity<Food>(savedFood,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Food> updateFoodItem(@RequestBody Food food) throws NoFoodFoundException{
		Food updFood = foodServ.updateFoodItem(food);
		return new ResponseEntity<Food>(updFood,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Food> fetchById(@PathVariable long id) throws NoFoodFoundException{
		Food food = foodServ.fetchById(id);
		return new ResponseEntity<Food>(food,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Food>> fetchAllFoodItem(){
		return new ResponseEntity<List<Food>>(foodServ.fetchAllFoodItems(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFoodById(@PathVariable long id) throws NoFoodFoundException{
		String string = foodServ.deleteFoodById(id);
		return new ResponseEntity<String>(string,HttpStatus.ACCEPTED);
	}
}
