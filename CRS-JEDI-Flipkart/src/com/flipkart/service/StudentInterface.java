package com.flipkart.service;

import com.flipkart.constant.Gender;
import com.flipkart.exception.StudentNotRegisteredException;

public interface StudentInterface {
	/**
	 * 
	 * @param name
	 * @param userID
	 * @param password
	 * @param gender
	 * @param batch
	 * @param branch
	 * @param address
	 * @param country
	 * @throws StudentNotRegisteredException
	 */
	public void register(String name,String userID,String password,Gender gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException; 
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public int getStudentId(String userId);
	
	  /**
	    * 
	    * @param studentId
	    * @return
	    */
	   public boolean isApproved(int studentId);
}
