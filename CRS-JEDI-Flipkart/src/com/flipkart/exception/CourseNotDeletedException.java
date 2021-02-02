/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Rag_Patel
 *
 */
public class CourseNotDeletedException extends Exception{
private String courseCode;
	
	public CourseNotDeletedException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	public String getCourseCode()
	{
		return courseCode;
	}
	
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
