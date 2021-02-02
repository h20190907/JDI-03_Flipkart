package com.flipkart.service;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {
	
	private static volatile UserOperation instance=null;
	UserDaoInterface userDaoInterface= UserDaoOperation.getInstance();
	private UserOperation()
	{
		
	}
	
	/**
	 * Method to make UserOperation Singleton
	 * @return
	 */
	public static UserOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserOperation.class){
				instance=new UserOperation();
			}
		}
		return instance;
	}

	/**
	 * 
	 * @param userID
	 * @return
	 */
	@Override
	public boolean updatePassword(String userID,String newPassword) {
		return userDaoInterface.updatePassword(userID, newPassword);
	}

	
	
	@Override
	public boolean verifyCredentials(String userID, String password) throws UserNotFoundException {
		//DAO class
		try
		{
			return userDaoInterface.verifyCredentials(userID, password);		
		}
		finally
		{
			
		}
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public String getRole(String userId) {
		return userDaoInterface.getRole(userId);
	}


	

}
