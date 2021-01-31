package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for UserNotFoundException
 * 
 */
public class UserNotFoundException extends Exception {

	private String userId;

	/**
	 * Default Constructor
	 * @param userId
	 */
	public UserNotFoundException(String userId) {
		this.userId = userId;
	}

	/**
	  * Method to get User ID
	  * @return User ID
	  */
	public String getUserId() {
		return userId;
	}

}
