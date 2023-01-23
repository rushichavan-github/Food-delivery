package com.example.onlinefooddelivery.controllers;

import java.util.List;
import java.util.Optional;


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

import com.example.onlinefooddelivery.entities.Customer;
import com.example.onlinefooddelivery.exceptions.NoCustomerFoundException;
import com.example.onlinefooddelivery.services.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cusServ;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer){
		Customer saveCustomer= cusServ.addCustomer(customer);
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Optional<Customer>> fetchCustomerById(@PathVariable long id) throws NoCustomerFoundException{
		Optional<Customer> customer = cusServ.getById(id);
		return new ResponseEntity<>(customer,HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws NoCustomerFoundException{
		Customer upCust = cusServ.updateCustomer(customer);
		return new ResponseEntity<Customer>(upCust,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Customer>> fetchAllCustomers(){
		List<Customer> allCusList= cusServ.getAllCustomer();
		return new ResponseEntity<>(allCusList,HttpStatus.FOUND);
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable int id) throws NoCustomerFoundException{
		return new ResponseEntity<String>(cusServ.removeCustomer(id), HttpStatus.ACCEPTED);
		
	}
}
