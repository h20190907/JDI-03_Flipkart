package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
	/**
	 * Method to verify credentials of the user from database
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;
	
	/**
	 * Method to fetch the role of user from database
	 * @param userId
	 * @return
	 */
	public String getRole(String userId);
	
	
	/**
	 * Method to update the password of user
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(String userID,String newPassword);
}
