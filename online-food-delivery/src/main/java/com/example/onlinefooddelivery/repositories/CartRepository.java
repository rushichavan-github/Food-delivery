package com.example.onlinefooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinefooddelivery.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
