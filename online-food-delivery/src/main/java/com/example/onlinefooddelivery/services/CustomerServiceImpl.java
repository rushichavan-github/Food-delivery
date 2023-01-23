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
		Customer saveCustomer = custRepo.save(customer);
		return saveCustomer;
	}

	@Override
	public Optional<Customer> getById(long id) throws NoCustomerFoundException {
	   Optional<Customer> cust =	custRepo.findById(id);
	   if(cust==null)
		   throw new NoCustomerFoundException();
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws NoCustomerFoundException {
		if(custRepo.existsById(customer.getCustomerId())) {
		Customer upCustomer= custRepo.save(customer);
		return upCustomer;
		}else {
			throw new NoCustomerFoundException();
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> allCus =custRepo.findAll();
		return allCus;
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
