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
		// TODO Auto-generated method stub
		Category saved= catRepo.save(category);
		return saved;
	}

	@Override
	public List<Category> viewAllCategory() {
		// TODO Auto-generated method stub
		List<Category> allCategories=catRepo.findAll();
		return allCategories;
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		Category updateCategory = catRepo.save(category);
		return updateCategory;
	}

	@Override
	public String deleteCategory(long id) throws NoCategoryFoundException {
		// TODO Auto-generated method stub
		if(catRepo.existsById((int) id)) {
			catRepo.deleteById((int) id);
			return "Category Deleted Succesfully";
		}else 
			throw new NoCategoryFoundException();
	}
	
	
}
