package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
	private String courseId;

	
	
	public CourseNotFoundException(String courseId) {
		
		this.courseId = courseId;
	}



	public String getCourseId() {
		return courseId;
	}


	

}
