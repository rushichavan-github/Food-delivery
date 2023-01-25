package com.example.onlinefooddelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Category;
import com.example.onlinefooddelivery.exceptions.NoCategoryFoundException;
import com.example.onlinefooddelivery.services.CategoryService;

/**
 * 
 * @author rushikesh chavan
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService catServ;
	
	/**
	 * 
	 * @param category
	 * @return category entity with status code
	 */
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category saved = catServ.addCategory(category);
		return new ResponseEntity<>(saved,HttpStatus.OK);
	}
	/**
	 * 
	 * @return All Categories with status code
	 */
	@GetMapping("/viewAll")
	public ResponseEntity<List<Category>> viewAllCategory(){
		List<Category> allCategories= catServ.viewAllCategory();
		return new ResponseEntity<>(allCategories,HttpStatus.ACCEPTED);
	}
	/**
	 * 
	 * @param category
	 * @return category which is updated
	 * @throws NoCategoryFoundException when No category is present
	 */
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws NoCategoryFoundException{
		Category updateCategory = catServ.updateCategory(category);
		return new ResponseEntity<>(updateCategory,HttpStatus.ACCEPTED);
	}
	/**
	 * 
	 * @param id
	 * @return string message if category deleted
	 * @throws NoCategoryFoundException
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable long id) throws NoCategoryFoundException{
		return new ResponseEntity<>(catServ.deleteCategory(id),HttpStatus.OK);
	}
}
