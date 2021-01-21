package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {

	@Override
	public boolean updatePassword(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public boolean verifyCredentials(int userID, String password) throws UserNotFoundException {

		try {
			if (DummyDB.studentList.get(userID).getPassword().equals(password)) {
				return true;
			}
		} catch (NullPointerException e) {
//			e.printStackTrace();
			throw new UserNotFoundException(String.valueOf(userID));
		}
		return false;
	}

}
