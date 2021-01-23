package com.flipkart.service;

import com.flipkart.exception.StudentNotRegisteredException;

public interface StudentInterface {
	public void register(String name,String userID,String password,String gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException; 
	
}
