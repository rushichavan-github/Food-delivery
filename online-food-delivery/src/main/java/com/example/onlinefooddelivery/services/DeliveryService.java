package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Delivery;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public interface DeliveryService {
		
	List<Delivery> getAllDeliveries();
    Optional<Delivery> getDeliveryById(@Min(1) long id);
    Delivery createDelivery(@Valid Delivery delivery);
    Delivery updateDelivery(@Valid Delivery delivery);
}
