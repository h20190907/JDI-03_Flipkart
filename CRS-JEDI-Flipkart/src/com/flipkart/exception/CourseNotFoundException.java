package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for CourseNotFoundException
 *
 */
public class CourseNotFoundException extends Exception{
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	/**
	 * Method to get Course Code
	 * @return Course Code
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	
	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() 
	{
		return "Course : " + courseCode + " not found!";
	}
}
