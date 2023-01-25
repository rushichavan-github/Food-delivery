package com.example.onlinefooddelivery.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.FoodOutOfStockException;
import com.example.onlinefooddelivery.exceptions.NoCartFoundException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;
import com.example.onlinefooddelivery.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartServ;
	
	
	
	@PostMapping("/addItem/{foodId}/{customerId}")
    public ResponseEntity<Cart> addItemToCart(@RequestBody Cart cart, @PathVariable long foodId,
            @PathVariable long customerId) throws FoodAlreadyExistsException {
        Cart addToCart = cartServ.addItemToCart(cart, foodId,customerId);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }
	
	@PutMapping("/updateItem/{foodId}")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart, @PathVariable long foodId) throws NoCartFoundException{
		 Cart addToCart = cartServ.updateCart(cart, foodId);
	        return new ResponseEntity<>(addToCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItem/{cartId}/{foodId}")
	public ResponseEntity<Cart> removeItem(@PathVariable long cartId,@PathVariable long foodId) throws NoCartFoundException, NoFoodFoundException{
		Cart removeFromCart = cartServ.removeItem(cartId,foodId);
		return new ResponseEntity<>(removeFromCart,HttpStatus.OK);
	}
	
	@DeleteMapping("/clearCart/{cartId}")
	public ResponseEntity<Cart> clearCart(@PathVariable long cartId) throws NoCartFoundException{
		Cart empCart=cartServ.clearCart(cartId);
		return new ResponseEntity<>(empCart,HttpStatus.OK);
	}
	
	
}
