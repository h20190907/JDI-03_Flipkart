/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * 
 * @author JEDI-03
 * Interface for Student Operations
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public int addStudent(Student student) throws StudentNotRegisteredException;
	
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public int getStudentId(String userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(int studentId);
}
