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

import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.exceptions.NoCustomerFoundException;
import com.example.onlinefooddelivery.repositories.CustomerRepository;
import com.example.onlinefooddelivery.services.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Mock private CustomerRepository customerRepository;
	
	
	@Test void getAllCustomer() {
		when(customerRepository.findAll()).thenReturn((List<Customer>) Stream.of(new Customer(1,"rushi","rushi@123","Bidar",297362974,"rushi12@gmail.com"))

		.collect(Collectors.toList()));

		Assertions.assertEquals(1, customerServiceImpl.getAllCustomer().size());
		
	}
	
	@Test
	void updateCustomer_success() throws NoCustomerFoundException {

		Customer newCustomer= new Customer(2,"rushi","rushi@123","Bidar",297362974,"rushi12@gmail.com");

		when(customerRepository.existsById((long) 2)).thenReturn(true);
		
		when(customerRepository.save(any())).thenReturn(newCustomer);

		Customer sch = customerServiceImpl.updateCustomer(newCustomer);

		Assertions.assertEquals(2, sch.getCustomerId());

		}
	
	@Test

	void updateCustomer_exception() throws NoCustomerFoundException {

	Customer cus = new Customer(2,"rushi","rushi@123","Bidar",297362974,"rushi12@gmail.com");

	when(customerRepository.existsById((long) 2)).thenReturn(false);


	Assertions.assertThrows(NoCustomerFoundException.class, () -> customerServiceImpl.updateCustomer(cus));

	}

}
