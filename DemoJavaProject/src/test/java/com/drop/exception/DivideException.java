package com.drop.exception;

public class DivideException extends Exception{
	
	
	private int b;
	
	public DivideException(int b) {
		this.b = b;
	}
	
	public int getb() {
		return b;
	}
	
	@Override
	public String getMessage() {
		return "Divide error" + b;
	}

}
