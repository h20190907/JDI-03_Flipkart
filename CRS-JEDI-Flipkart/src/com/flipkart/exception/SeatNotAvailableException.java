package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for SeatNotAvailableException
 *
 */
public class SeatNotAvailableException extends Exception{
	
	private String courseCode;

	public SeatNotAvailableException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() {
		return  "Seats are not available in course : " + courseCode;
	}


}
