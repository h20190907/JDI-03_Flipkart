package com.flipkart.exception;

/**
 * Exception to check if user is approved by administration
 * @author JEDI-03
 *
 */
public class UserNotApprovedException extends Exception{
	private String userId;
	
	/**
	 * Constructor
	 * @param userId
	 */
	public UserNotApprovedException(String userId) {
		this.userId = userId;
	}

	/**
	 * Getter for userId
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

}
