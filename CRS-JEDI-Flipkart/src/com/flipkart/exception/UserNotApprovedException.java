package com.flipkart.exception;

public class UserNotApprovedException extends Exception{
	private String userId;
	
	public UserNotApprovedException(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
