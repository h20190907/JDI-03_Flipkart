package com.flipkart.exception;

/**
 * 
 * @author JEDI-03
 * Class for ProfessorNotAddedException
 *
 */
public class ProfessorNotAddedException extends Exception{
	private String professorId;
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId = professorId;
	}
	
	/**
	 * Method to get User ID
	 * @return User ID (same as Professor ID)
	 */
	public String getUserId() {
		return this.professorId;
	}
	
	/**
	 * Method to return error message
	 */
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}
