/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for CourseFoundException
 * 
 */
public class CourseFoundException extends Exception{
	private String courseCode;
	
	public CourseFoundException(String courseCode) {
		this.courseCode = courseCode;
	}
	
	/**
	 * Method to get Course Code
	 * @return Course Code
	 */
	public String getCourseCode() {
		return courseCode;
	}
	
	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() {
		return "courseCode: " + courseCode + " already present in catalog!";
	}
}
