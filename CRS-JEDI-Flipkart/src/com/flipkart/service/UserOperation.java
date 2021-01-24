package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {
	
	private static volatile UserOperation instance=null;
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

	@Override
	public boolean updatePassword(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public boolean verifyCredentials(int userID, String password) throws UserNotFoundException {
		return false;
	}

}
