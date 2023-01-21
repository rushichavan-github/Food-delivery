package com.example.onlinefooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinefooddelivery.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
