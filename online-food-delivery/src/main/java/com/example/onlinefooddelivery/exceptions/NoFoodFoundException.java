package com.example.onlinefooddelivery.exceptions;

public class NoFoodFoundException extends Exception{
		private String msg;

		public NoFoodFoundException(String msg) {
			super();
			this.msg = msg;
		}

		public NoFoodFoundException() {
			super();
		}
}
