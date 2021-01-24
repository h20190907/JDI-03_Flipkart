/**
 * 
 */
package com.flipkart.exception;

/**
 * @author 
 *
 */
public class CourseLimitExceedException extends Exception{
	
	private int num;

	
	public CourseLimitExceedException(int num )
	{	
		this.num = num;
	}


	public int getNum()
	{
		return num;
	}


}
