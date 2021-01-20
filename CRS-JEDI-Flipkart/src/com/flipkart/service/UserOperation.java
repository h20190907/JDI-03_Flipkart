package com.flipkart.service;

import com.flipkart.bean.User;

public class UserOperation implements UserInterface{

	@Override
	public boolean updatePassword(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyCredentials(int userID, String password) {
		
		if(DummyDB.studentList.containsKey(userID) == false)
			return false;
		if(DummyDB.studentList.get(userID).getPassword().equals(password))
		{
			return true;
		}
		
		return false;
		
	}
	
	
	

}
