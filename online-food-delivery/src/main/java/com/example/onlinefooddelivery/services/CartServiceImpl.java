package com.example.onlinefooddelivery.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Cart;
import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.entities.Food;
import com.example.onlinefooddelivery.exceptions.FoodAlreadyExistsException;
import com.example.onlinefooddelivery.exceptions.FoodOutOfStockException;
import com.example.onlinefooddelivery.exceptions.NoCartFoundException;
import com.example.onlinefooddelivery.exceptions.NoFoodFoundException;
import com.example.onlinefooddelivery.repositories.CartRepository;
import com.example.onlinefooddelivery.repositories.CustomerRepository;
import com.example.onlinefooddelivery.repositories.FoodRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Override
    public Cart addItemToCart(Cart cart, long foodId, long customerId) throws FoodAlreadyExistsException {

        Optional<Food> foodItem = foodRepo.findById(foodId);
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()) {
            cart.setCustomer(customer.get());
        }
        if (foodItem.isPresent()) {
            cart.setFoodItem(Arrays.asList(foodItem.get()));
        }
        return cartRepo.save(cart);
    }
	
	@Override
	public Cart updateCart(Cart cart, long foodId) throws NoCartFoundException {
		if(!cartRepo.existsById(cart.getCartId())) {
			throw new NoCartFoundException();
			}
		  Optional<Food> foodItem = foodRepo.findById(foodId);
		  if (foodItem.isPresent()) {
			  Food food1 = foodRepo.findById(foodId).get();
			  List<Food> foodlist = cart.getFoodItem();  
			  foodlist.add(food1);
			  cart.setFoodItem(foodlist);
	        }
		return cartRepo.save(cart);
	}

	@Override
	public Cart removeItem(long cartId, long itemId) throws NoCartFoundException, NoFoodFoundException {
		if(!cartRepo.existsById(cartId)) {
			throw new NoCartFoundException();
		}
		Cart cart = cartRepo.findById(cartId).get();
		Food food = foodRepo.findById(itemId).get();
		List<Food> tempFood = cart.getFoodItem();
		if(tempFood.contains(food)) {
			tempFood.remove(food);
			cart.setFoodItem(tempFood);
		}
		return cartRepo.save(cart);
	}

	@Override
	public Cart clearCart(long cartId) throws NoCartFoundException {
		if(!cartRepo.existsById(cartId)) {
			throw new NoCartFoundException();
		}
		Cart repoCart = cartRepo.findById(cartId).get();
		List<Food> tempFood = repoCart.getFoodItem();
		tempFood.clear();
		repoCart.setPrice(0);
		repoCart.setQuantity(0);
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	


}
