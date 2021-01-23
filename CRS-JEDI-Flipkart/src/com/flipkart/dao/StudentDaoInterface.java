/**
 * 
 */
package com.flipkart.dao;

/**
 * @author Dilpreet Kaur
 *
 */
public interface StudentDaoInterface {
	/**
	 * 
	 * @param name
	 * @param userID: student's email address
	 * @param password
	 * @param gender
	 * @param batch
	 * @param branch
	 * @param address: student's complete address
	 * @param country
	 * @return true, if record is added in DB, else false.
	 */
	public boolean addStudent(String name,String userID,String password,String gender,int batch,String branch,String address,String country);
}
