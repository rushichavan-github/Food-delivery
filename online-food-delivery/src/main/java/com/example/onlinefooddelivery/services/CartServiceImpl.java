package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Cart addItemToCart(Cart cart, Food food) {
		// TODO Auto-generated method stub
		Cart repoCart = cartRepo.findById(cart.getCartId()).get();
		List<Food> tempFood = repoCart.getFoodItem();
		tempFood.add(food);
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
 		return repoCart;
	}

	@Override
	public Cart increaseQuantity(Cart cart, Food food, int quantity) {
		// TODO Auto-generated method stub
		Cart repoCart = cartRepo.findById(cart.getCartId()).get();
		List<Food> tempFood = repoCart.getFoodItem();
		for(Food foo: tempFood) {
			if(foo.getFoodId()==food.getFoodId()) {
				int quant = foo.getQuantity();
				foo.setQuantity(quant+quantity);
				break;
			}
		}
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public Cart decreaseQuantity(Cart cart, Food food, int quantity) {
		// TODO Auto-generated method stub
		Cart repoCart = cartRepo.findById(cart.getCartId()).get();
		List<Food> tempFood = repoCart.getFoodItem();
		for(Food foo: tempFood) {
			if(foo.getFoodId()==food.getFoodId()) {
				int quant = foo.getQuantity();
				foo.setQuantity(Math.max((quant-quantity),0));
				break;
			}
		}
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public Cart removeItem(Cart cart, Food food) {
		// TODO Auto-generated method stub
		Cart repoCart = cartRepo.findById(cart.getCartId()).get();
		List<Food> tempFood = repoCart.getFoodItem();
		tempFood.remove(food);
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public Cart clearCart(Cart cart) {
		// TODO Auto-generated method stub
		Cart repoCart = cartRepo.findById(cart.getCartId()).get();
		List<Food> tempFood = repoCart.getFoodItem();
		tempFood.clear();
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}


}
