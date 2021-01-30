package com.flipkart.service;

import com.flipkart.constant.Gender;
import com.flipkart.exception.StudentNotRegisteredException;

public interface StudentInterface {
	/**
	 * Method to register a student, although student can't login until it's approved by admin
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
	public int register(String name,String userID,String password,Gender gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException; 
	
	/**
	 * Method to get Student ID from User ID
	 * @param userId
	 * @return
	 */
	public int getStudentId(String userId);
	
	/**
     * Method to check if student is approved by Admin or not
     * @param studentId
     * @return
     */
    public boolean isApproved(int studentId);
}
