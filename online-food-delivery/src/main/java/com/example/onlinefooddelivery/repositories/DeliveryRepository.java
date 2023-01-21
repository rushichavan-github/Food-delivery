package com.example.onlinefooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinefooddelivery.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
