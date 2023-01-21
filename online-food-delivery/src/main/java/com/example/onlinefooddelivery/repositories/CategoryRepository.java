package com.example.onlinefooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinefooddelivery.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
