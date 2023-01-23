package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Order;
import com.example.onlinefooddelivery.exceptions.NoOrderFoundException;
import com.example.onlinefooddelivery.repositories.OrderRepository;

@Service
public class OrderServImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public Order addOrder(Order order) {
		Order savedOrder = orderRepo.save(order);
		return savedOrder;
	}

	@Override
	public Order updateOrder(Order order) throws NoOrderFoundException {
		if(orderRepo.existsById(order.getOrderId())){
				Order upOrder = orderRepo.save(order);
				return upOrder;
		}
		else{
		 throw new NoOrderFoundException();	
		}
	}

	@Override
	public Optional<Order> viewOrderById(long id) throws NoOrderFoundException {
		if(orderRepo.existsById(id)) {
			return orderRepo.findById(id);
		}else {
			throw new NoOrderFoundException();
		}
	}

	@Override
	public List<Order> viewAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public String deleteOrder(long id) throws NoOrderFoundException {
		if(orderRepo.existsById(id)) {
			orderRepo.deleteById(id);
			return "Order Deleted Successfully";
		}
		else {
			throw new NoOrderFoundException();
		}
	}
}
