package com.example.onlinefooddelivery.services;


import java.util.List;
import java.util.Optional;

import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.exceptions.NoCustomerFoundException;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Optional<Customer> getById(int id) throws NoCustomerFoundException;

	public Customer updateCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public String removeCustomer(int id) throws NoCustomerFoundException;
	
}
