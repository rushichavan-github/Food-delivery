package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Order;
import com.example.onlinefooddelivery.exceptions.NoOrderFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public interface OrderService {

	Order addOrder(@Valid Order order);

	Order updateOrder(@Valid Order order)throws NoOrderFoundException;

	Optional<Order>  viewOrderById(@Min(1) long id)throws NoOrderFoundException;

	List<Order> viewAllOrder();

	String deleteOrder(@Min(1)long id)throws NoOrderFoundException;

}
