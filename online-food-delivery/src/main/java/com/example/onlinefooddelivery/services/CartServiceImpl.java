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

import jakarta.validation.constraints.Max;

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
	public Cart increaseQuantity(long cartId,long foodId, int quantity) throws NoCartFoundException, NoFoodFoundException, FoodOutOfStockException {
		if(cartRepo.existsById(cartId)==false) {
			throw new NoCartFoundException();
			}
		
		Cart repoCart = cartRepo.findById(cartId).get();
		boolean found=false;
		List<Food> tempFood = repoCart.getFoodItem();
		Food food = foodRepo.findById(foodId).get();
		for(Food foo: tempFood) {
			if(foo.getFoodId()==food.getFoodId()) {
				found=true;
				int quant = foo.getQuantity();
				int totalQuan=quantity+quant;
				if(totalQuan>food.getQuantity()) {
					throw new FoodOutOfStockException();
				}
				repoCart.setQuantity(repoCart.getQuantity()+quantity);
				double totalCost = repoCart.getPrice()+(food.getFoodCost()*quantity);
				repoCart.setPrice(totalCost);
				break;
			}
		}
		if(!found) {
			throw new NoFoodFoundException("No Food in Cart");
		}
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public Cart decreaseQuantity(long cartId, long foodId, int quantity) throws NoCartFoundException, NoFoodFoundException, FoodOutOfStockException {
		if(!cartRepo.existsById(cartId)) {
			throw new NoCartFoundException();
		}
		
		Cart repoCart = cartRepo.findById(cartId).get();
		
		boolean found = false;
		Food food = foodRepo.findById(foodId).get();
		List<Food> tempFood = repoCart.getFoodItem();
		for(Food foo: tempFood) {
			if(foo.getFoodId()==food.getFoodId()) {
				found=true;
				int quant = foo.getQuantity();
				int totalQuan=quant-quantity;
				if(totalQuan<food.getQuantity()) {
					throw new FoodOutOfStockException();
				}
				repoCart.setQuantity(repoCart.getQuantity()-quantity);
				double totalCost = repoCart.getPrice()-(food.getFoodCost()*quantity);
				repoCart.setPrice(Math.max(totalCost, 0));
				break;
			}
		}
		if(!found) {
			throw new NoFoodFoundException("No Food in Cart");
		}
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public Cart removeItem(long cartId, long itemId) throws NoCartFoundException, NoFoodFoundException {
		if(!cartRepo.existsById(cartId)) {
			throw new NoCartFoundException();
		}
		boolean found =false;
		Cart repoCart = cartRepo.findById(cartId).get();
		Food food = foodRepo.findById(itemId).get();
		List<Food> tempFood = repoCart.getFoodItem();
		for(Food foo: tempFood) {
			if(foo.getFoodId()==food.getFoodId()) {
				found=true;
				int quant = foo.getQuantity();
				double price=food.getFoodCost();
				tempFood.remove(foo);
				repoCart.setPrice(Math.max(repoCart.getPrice()-(quant*price),0));
				repoCart.setQuantity(Math.max(repoCart.getQuantity()-quant,0));
				break;
			}
		}
		if(!found) {
			throw new NoFoodFoundException();
		}
		repoCart.setFoodItem(tempFood);
		cartRepo.save(repoCart);
		return repoCart;
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
