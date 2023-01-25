package com.example.onlinefooddelivery;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.onlinefooddelivery.entities.Category;
import com.example.onlinefooddelivery.exceptions.NoCategoryFoundException;
import com.example.onlinefooddelivery.repositories.CategoryRepository;
import com.example.onlinefooddelivery.services.CategoryServiceImpl;
/**
 * 
 * @author rushikesh chavan
 *
 */
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
		
	@InjectMocks
	private CategoryServiceImpl catgServiceImpl;
	
	@Mock 
	private CategoryRepository catgRepository;
	
	/**
	 * This test case is to test viewAllCatgegory method
	 *
	 */
	@Test void getAllCategory() {
		when(catgRepository.findAll()).thenReturn((List<Category>) Stream.of(new Category(1,"starter"))

		.collect(Collectors.toList()));

		Assertions.assertEquals(1, catgServiceImpl.viewAllCategory().size());
		
	}
	
	/**
	 * This test case is to test updateCategory method
	 * @throws NoCategoryFoundException when category is not present
	 */
	@Test
	void updateCategory_success() throws NoCategoryFoundException {

		Category newCategory= new Category(2,"main course");

		when(catgRepository.existsById((long) 2)).thenReturn(true);
		
		when(catgRepository.save(any())).thenReturn(newCategory);

		Category sch = catgServiceImpl.updateCategory(newCategory);

		Assertions.assertEquals(2, sch.getCategoryId());

		}
	/**
	 * This test case is to test updateCategory method and this will throw Exception
	 * @throws NoCategoryFoundException when category is not present
	 *
	 */
	@Test
	void updateCategory_exception() throws NoCategoryFoundException{

	Category newCategory= new Category(6,"main course");

	when(catgRepository.existsById((long) 6)).thenReturn(false);


	Assertions.assertThrows(NoCategoryFoundException.class, () -> catgServiceImpl.updateCategory(newCategory));

	}

}
