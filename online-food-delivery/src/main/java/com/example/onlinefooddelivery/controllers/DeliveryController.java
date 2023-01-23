package com.example.onlinefooddelivery.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Delivery;
import com.example.onlinefooddelivery.services.DeliveryService;
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	@Autowired
    private DeliveryService deliveryService;

    @GetMapping("/fetchall")
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        return new ResponseEntity<>(deliveryService.getAllDeliveries(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Delivery>> getDeliveryById(@PathVariable long id) {
            return new ResponseEntity<>(deliveryService.getDeliveryById(id), HttpStatus.OK);
}
    
    @PostMapping("/save")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery){
    	return new ResponseEntity<>(deliveryService.createDelivery(delivery), HttpStatus.CREATED);
    	
    }
    @PutMapping("/update")
    public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delivery){
    		return new ResponseEntity<>(deliveryService.updateDelivery(delivery), HttpStatus.ACCEPTED);
    		
    }
	 
	 

    }