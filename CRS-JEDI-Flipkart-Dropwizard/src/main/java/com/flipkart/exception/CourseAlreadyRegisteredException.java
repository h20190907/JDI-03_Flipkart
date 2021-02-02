package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
	
	private String courseCode;
	
	public CourseAlreadyRegisteredException(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	@Override
	public String getMessage() {
		return "You have already registered for " + courseCode;
	}

}
