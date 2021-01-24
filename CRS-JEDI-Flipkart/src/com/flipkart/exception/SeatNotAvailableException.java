package com.flipkart.exception;

public class SeatNotAvailableException extends Exception{
	
	private String courseCode;

	public SeatNotAvailableException(String courseCode)
	{	
		this.courseCode = courseCode;
	}


	public String getCourseCode()
	{
		return courseCode;
	}




}
