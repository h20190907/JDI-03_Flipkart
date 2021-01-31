/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for CourseLimitExceedException
 *
 */
public class CourseLimitExceedException extends Exception{
	
	private int num;

	
	public CourseLimitExceedException(int num )
	{	
		this.num = num;
	}


	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() 
	{
		return "You have already registered for " + num + " courses";
	}


}
