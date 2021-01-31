package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for StudentNotRegisteredException
 *
 */
public class StudentNotRegisteredException extends Exception{
	 private String studentName;
	 
	 public StudentNotRegisteredException(String studentName)
	 {
		 this.studentName=studentName;
	 }
	 
	 /**
	  * Method to get Student Name
	  * @return Student Name
	  */
	 public String getStudentName()
	 {
		 return studentName;
	 }
	 
}
