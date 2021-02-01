package com.flipkart.bean;

/**
 * 
 * @author JEDI-03
 * Class for storing details of course Student has taken
 * 
 */
public class EnrolledStudent {
	private String courseCode;
	private String courseName;
	private int studentId;
	
	/**
	 * Method to get Course Code
	 * @return Course Code
	 */
	public String getCourseCode() {
		return courseCode;
	}
	
	/**
	 * Method to set Course Code
	 * @param courseCode
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	/**
	 * Method to get Course Name
	 * @return Course Name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Method to set Course Name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id of student enrolled in the course
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Parameterized constructor
	 * @param courseCode
	 * @param courseName
	 * @param studentId
	 */
	public EnrolledStudent(String courseCode, String courseName, int studentId) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.studentId = studentId;
	}
}
