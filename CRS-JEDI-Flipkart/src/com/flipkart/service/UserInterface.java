package com.flipkart.service;

import com.flipkart.bean.User;

public interface UserInterface {
	public boolean updatePassword(int userID);
	public boolean verifyCredentials(int userID,String password);
}
