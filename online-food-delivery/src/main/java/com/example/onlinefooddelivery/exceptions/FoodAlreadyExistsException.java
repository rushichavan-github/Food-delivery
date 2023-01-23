package com.example.onlinefooddelivery.exceptions;

public class FoodAlreadyExistsException extends Exception {

		public FoodAlreadyExistsException(String msg) {
			super(msg);
		}

		public FoodAlreadyExistsException() {
			super();
		}
		
}
