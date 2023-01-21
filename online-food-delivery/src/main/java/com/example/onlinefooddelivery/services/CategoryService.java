package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.onlinefooddelivery.entities.Category;
import com.example.onlinefooddelivery.exceptions.NoCategoryFoundException;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> viewAllCategory();

	Category updateCategory(Category category);

	String deleteCategory(long id) throws NoCategoryFoundException;

}
