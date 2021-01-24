/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

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
	 * @throws SQLException 
	 */
	public boolean addStudent(Student student) throws StudentNotRegisteredException;
}
