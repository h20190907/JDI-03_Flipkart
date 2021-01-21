package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	public boolean updatePassword(int userID);
	public boolean verifyCredentials(int userID,String password) throws UserNotFoundException;
}
