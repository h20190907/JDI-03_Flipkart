/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Umang
 *
 */
public class UserNotFoundException extends Exception {

	private String userId;

	/**
	 * 
	 * @param userId
	 */
	public UserNotFoundException(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
