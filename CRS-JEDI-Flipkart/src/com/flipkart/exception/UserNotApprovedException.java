package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for UserNotApprovedException
 *
 */
public class UserNotApprovedException extends Exception{
	private String userId;
	
	public UserNotApprovedException(String userId) {
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
