package com.flipkart.service;

public interface UserInterface {
	public boolean updatePassword(int userID);
	public int verifyCredentials(int userID,String password);
}
