package com.example.onlinefooddelivery.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.repositories.FoodRepository;
import com.example.onlinefooddelivery.services.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartServ;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@PostMapping("/addItemToCart/{itemId}")
	public ResponseEntity<Cart> addItenToCart(@RequestBody Cart cart,@PathVariable long itemId){
		Food food =  foodRepo.findById(itemId).get();
		Cart addToCart= cartServ.addItemToCart(cart,food);
		if(addToCart==null) {
			return new ResponseEntity("Sorry ! item not added to cart",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(addToCart,HttpStatus.OK);
	}
	
	@PutMapping("/increaseQuantity/{itemId}/{quantity}")
	public ResponseEntity<Cart> increaseQuantity(@RequestBody Cart cart,@PathVariable long itemId,@PathVariable int quantity){
		Food food = foodRepo.findById(itemId).get();
		Cart incQntCart= cartServ.increaseQuantity(cart,food,quantity);
		if(incQntCart==null) {
			return new ResponseEntity("Sorry ! item not added to cart",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(incQntCart,HttpStatus.OK);
	}
	
	@PutMapping("/decreaseQuantity/{itemId}/{quantity}")
	public ResponseEntity<Cart> deccreaseQuantity(@RequestBody Cart cart,@PathVariable long itemId,@PathVariable int quantity){
		Food food = foodRepo.findById(itemId).get();
		Cart decQntCart= cartServ.decreaseQuantity(cart,food,quantity);
		if(decQntCart==null) {
			return new ResponseEntity("Sorry ! item not added to cart",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(decQntCart,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItemFromCart/{itemId}")
	public ResponseEntity<Cart> removeItem(@RequestBody Cart cart,@PathVariable long itemId){
		Food food = foodRepo.findById(itemId).get();
		Cart removeFromCart = cartServ.removeItem(cart,food);
		return new ResponseEntity<Cart>(removeFromCart,HttpStatus.OK);
	}
	
	@DeleteMapping("/clearCart")
	public ResponseEntity<Cart> clearCart(@RequestBody Cart cart){
		Cart empCart=cartServ.clearCart(cart);
		return new ResponseEntity<Cart>(empCart,HttpStatus.OK);
	}
	
	
}
