package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	public String getCourseCode()
	{
		return courseCode;
	}
	
	@Override
	public String getMessage() {
		return "courseCode: " + courseCode + " not found!";
	}
}
