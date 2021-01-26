package com.flipkart.exception;

/**
 * @author Rag_Patel
 *
 */
public class UserNotAddedException extends Exception{
	private String userId;
	
	public UserNotAddedException(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	@Override
	public String getMessage() {
		return "UserId: " + userId + " not added!";
	}
}
