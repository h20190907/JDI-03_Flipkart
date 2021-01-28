package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	/**
	 * 
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	boolean updatePassword(String userID, String newPassword);
	/**
	 * 
	 * @param userID
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userID,String password) throws UserNotFoundException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
   public String getRole(String userId);
   
 
}
