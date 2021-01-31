package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for Grade not added Exception
 *
 */
public class GradeNotAddedException extends Exception{

	private int studentId;
	 
	 public GradeNotAddedException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 /**
	  * Method to get Student ID
	  * @return Student ID
	  */
	 public int getStudentId()
	 {
		 return studentId;
	 }
	 
	 
}
