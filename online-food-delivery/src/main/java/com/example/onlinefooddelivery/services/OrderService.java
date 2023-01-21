package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinefooddelivery.entities.Order;
import com.example.onlinefooddelivery.exceptions.NoOrderFoundException;

public interface OrderService {

	Order addOrder(Order order);

	Order updateOrder(Order order)throws NoOrderFoundException;

	Optional<Order>  viewOrderById(long id)throws NoOrderFoundException;

	List<Order> viewAllOrder();

	String deleteOrder(long id)throws NoOrderFoundException;



}
