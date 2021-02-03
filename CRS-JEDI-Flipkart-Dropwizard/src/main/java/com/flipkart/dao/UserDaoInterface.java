package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
	/**
	 * To verify the user credentials
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;
	
	/**
	 * To update the login password
	 * @param userID
	 * @return
	 */
	public boolean updatePassword(String userID);
	
	/**
	 * To get the role of the user
	 * @param userId
	 * @return
	 */
	public String getRole(String userId);
	
	
	/**
	 * 
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(String userID,String newPassword);
}
