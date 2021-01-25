package com.flipkart.exception;

/**
 * @author Rag_Patel
 *
 */
public class ProfessorNotAddedException extends Exception{
	String professorId;
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId = professorId;
	}
	
	public String getUserId() {
		return this.professorId;
	}
	
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}
