package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Category;
import com.example.onlinefooddelivery.exceptions.NoCategoryFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public interface CategoryService {

	Category addCategory(@Valid Category category);

	List<Category> viewAllCategory();

	Category updateCategory(@Valid Category category) throws NoCategoryFoundException;

	String deleteCategory(@Min(1)long id) throws NoCategoryFoundException;

}
