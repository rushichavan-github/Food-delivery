package com.example.onlinefooddelivery.exceptions;

public class NoCategoryFoundException  extends Exception{
		private String msg;

		public NoCategoryFoundException(String msg) {
			super();
			this.msg = msg;
		}

		public NoCategoryFoundException() {
			super();
		}
		
}
