/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for StudentNotFoundException
 *
 */
public class StudentNotFoundException extends Exception {
	private int studentId;
	
	public StudentNotFoundException(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	  * Method to get Student ID
	  * @return Student ID
	  */
	public int getStudentId() {
		return this.studentId;
	}
	
	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() {
		return "studentId: " + studentId + " not found!" ;
	}
}
