package com.example.onlinefooddelivery.services;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.entities.Food;

public interface CartService {

	Cart addItemToCart(Cart cart, Food food);

	Cart increaseQuantity(Cart cart, Food food, int quantity);

	Cart decreaseQuantity(Cart cart, Food food, int quantity);

	Cart removeItem(Cart cart, Food food);

	Cart clearCart(Cart cart);


}
