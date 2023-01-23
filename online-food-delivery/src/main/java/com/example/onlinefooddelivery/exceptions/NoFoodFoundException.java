package com.example.onlinefooddelivery.exceptions;

public class NoFoodFoundException extends Exception{

		public NoFoodFoundException(String msg) {
			super(msg);
		}

		public NoFoodFoundException() {
			super();
		}
}
