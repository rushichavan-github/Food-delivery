package com.example.onlinefooddelivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(value = NoCustomerFoundException.class)
	public ResponseEntity<String> noCustomerFoundException(){
		return new ResponseEntity<String>("No Customer Found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoCategoryFoundException.class)
	public ResponseEntity<String> noCategoryFoundException(){
		return new ResponseEntity<String>("No Category Found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoOrderFoundException.class)
	public ResponseEntity<String> noOrderFoundException(){
		return new ResponseEntity<String>("No Order Found with that ID!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FoodAlreadyExistsException.class)
	public ResponseEntity<String> foodAlreadyExistsException(){
		return new ResponseEntity<String>("Food Already Exists!",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= NoFoodFoundException.class)
	public ResponseEntity<String> noFoodFoundException(){
		return new ResponseEntity<String>("Food Item Not Present!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = AdminAlreadyExistsException.class)
	public ResponseEntity<String> adminAlreadyExistsException(){
		return new ResponseEntity<String>("Admin Already Exists!",HttpStatus.CONFLICT);
	}
}
