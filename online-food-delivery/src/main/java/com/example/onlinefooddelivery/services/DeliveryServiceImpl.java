package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Delivery;
import com.example.onlinefooddelivery.repositories.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	@Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
          return deliveryRepository.save(delivery);
          
    }
    
    @Override
	public Optional<Delivery> getDeliveryById(long id) {
		
		Optional<Delivery> view=deliveryRepository.findById(id);
		return view;
	}
}
