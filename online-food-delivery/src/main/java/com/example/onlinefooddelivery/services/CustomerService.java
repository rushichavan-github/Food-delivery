package com.example.onlinefooddelivery.services;


import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.exceptions.NoCustomerFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public interface CustomerService {

	public Customer addCustomer(@Validated Customer customer);

	public Optional<Customer> getById(@Min(1)long id) throws NoCustomerFoundException;

	public Customer updateCustomer(@Valid Customer customer)throws NoCustomerFoundException;

	public List<Customer> getAllCustomer();

	public String removeCustomer(@Min(1) long id) throws NoCustomerFoundException;
	
}
