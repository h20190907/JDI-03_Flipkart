package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for UserNotAddedException
 *
 */
public class UserNotAddedException extends Exception{
	private String userId;
	
	public UserNotAddedException(String userId) {
		this.userId = userId;
	}
	
	/**
	  * Method to get User ID
	  * @return User ID
	  */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() {
		return "UserId: " + userId + " not added!";
	}
}
