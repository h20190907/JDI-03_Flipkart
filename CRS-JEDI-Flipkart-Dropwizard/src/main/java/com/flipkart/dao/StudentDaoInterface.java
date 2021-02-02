/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author JEDI-3
 *
 */
public interface StudentDaoInterface {
	/**
	 * Register student into Institute 
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public boolean addStudent(Student student) throws StudentNotRegisteredException;
	
	
	/**
	 * Get studentId of user
	 * @param userId
	 * @return studentId
	 */
	public int getStudentId(String userId);
	
	/**
	 * Check if student is approved
	 * @param studentId
	 * @return 
	 */
	public boolean isApproved(int studentId);
}
