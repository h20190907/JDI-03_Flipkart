package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
	/**
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public boolean updatePassword(String userID);
	
	/**
	 * 
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
