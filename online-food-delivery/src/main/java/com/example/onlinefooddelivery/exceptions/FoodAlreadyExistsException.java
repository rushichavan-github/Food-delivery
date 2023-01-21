package com.example.onlinefooddelivery.exceptions;

public class FoodAlreadyExistsException extends Exception {
		private String msg;

		public FoodAlreadyExistsException(String msg) {
			super();
			this.msg = msg;
		}

		public FoodAlreadyExistsException() {
			super();
		}
		
}
