package com.flipkart.service;

import com.flipkart.exception.StudentNotRegisteredException;

public class StudentOperation implements StudentInterface {
	
	private static volatile StudentOperation instance=null;
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}
	
	
	@Override
	public void register(String name,String userID,String password,String gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException{
		try
		{
			//call the DAO class
			
		}
		catch(Exception ex)
		{
			throw new StudentNotRegisteredException(name);

		}
	}

}
