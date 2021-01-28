package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	
	/**
	 * Method to update password of a user
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	boolean updatePassword(String userID, String newPassword);
	
	/**
	 * Method to verify User credentials
	 * @param userID
	 * @param password
	 */
	public boolean verifyCredentials(String userID,String password) throws UserNotFoundException;
	
	/**
	 * Method to get role of a specific User
	 * @param userId
	 * @return Role of the User
	 */
   public String getRole(String userId);
   
 
}
