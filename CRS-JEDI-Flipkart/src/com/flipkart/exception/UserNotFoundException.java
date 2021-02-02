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

	@Override
	public String getMessage() {
		return "User with userId: " + userId + " not found.";
	}

}
