package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Category;
import com.example.onlinefooddelivery.exceptions.NoCategoryFoundException;
import com.example.onlinefooddelivery.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository catRepo;
	
	
	@Override
	public Category addCategory(Category category) {
		return catRepo.save(category);
	}

	@Override
	public List<Category> viewAllCategory() {
		return catRepo.findAll();
	}

	@Override
	public Category updateCategory(Category category) throws NoCategoryFoundException {
		if(catRepo.existsById(category.getCategoryId())) {
			return catRepo.save(category);
		}else {
			throw new NoCategoryFoundException();
		}
		
	}

	@Override
	public String deleteCategory(long id) throws NoCategoryFoundException {
		if(catRepo.existsById(id)) {
			catRepo.deleteById(id);
			return "Category Deleted Succesfully";
		}else 
			throw new NoCategoryFoundException();
	}
	
	
}
