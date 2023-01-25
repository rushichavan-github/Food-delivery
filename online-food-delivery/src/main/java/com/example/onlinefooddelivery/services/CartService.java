package com.example.onlinefooddelivery.services;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.FoodOutOfStockException;
import com.example.onlinefooddelivery.exceptions.NoCartFoundException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;

import jakarta.validation.constraints.Min;

@Validated
public interface CartService {

	Cart addItemToCart(Cart cart,@Min(1) long foodId, long customerId)throws FoodAlreadyExistsException;

	Cart removeItem(@Min(1)long cartId,@Min(1) long foodId)throws NoCartFoundException, NoFoodFoundException;

	Cart clearCart(@Min(1)long cartId)throws NoCartFoundException;

	Cart updateCart(Cart cart, long foodId)throws NoCartFoundException;


}
