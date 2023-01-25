package com.example.onlinefooddelivery.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.exceptions.NoCustomerFoundException;
import com.example.onlinefooddelivery.repositories.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo ;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public Optional<Customer> getById(long id) throws NoCustomerFoundException {
	   Optional<Customer> cust =custRepo.findById(id);
	   if(cust.isEmpty())
		   throw new NoCustomerFoundException();
	return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws NoCustomerFoundException {
		if(custRepo.existsById(customer.getCustomerId())) {
		return custRepo.save(customer);
		}else {
			throw new NoCustomerFoundException();
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	@Override
	public String removeCustomer(long id) throws NoCustomerFoundException {
		if(custRepo.existsById(id)) {
			custRepo.deleteById(id);
			return "Customer Deleted";}
		else {
			throw new NoCustomerFoundException();
		}
	}

}
