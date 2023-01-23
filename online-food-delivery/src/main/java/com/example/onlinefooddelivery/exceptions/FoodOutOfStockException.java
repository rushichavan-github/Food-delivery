package com.example.onlinefooddelivery.exceptions;

public class FoodOutOfStockException extends Exception{

		public FoodOutOfStockException(String msgString) {
			super(msgString);
		}

		public FoodOutOfStockException() {
			super();
		}
		
}
