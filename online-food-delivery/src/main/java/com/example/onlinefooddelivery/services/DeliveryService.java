package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinefooddelivery.entities.Delivery;

public interface DeliveryService {
		
	List<Delivery> getAllDeliveries();
    Optional<Delivery> getDeliveryById(long id);
    Delivery createDelivery(Delivery delivery);
    Delivery updateDelivery(Delivery delivery);
}
