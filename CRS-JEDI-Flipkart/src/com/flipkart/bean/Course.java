package com.flipkart.bean;

/**
 * 
 * @author JEDI-03
 * Class to store Course information
 * 
 */
public class Course {

	private String courseCode;
	private String courseName;
	private String instructorId;
	private int seats = 10;
	
	/**
	 * Default Constructor
	 */
	public Course() {
		
	}
	
	/**
	 * Parameterized constructor
	 * @param courseCode
	 * @param courseName
	 * @param instructorId
	 * @param seats
	 */
	public Course(String courseCode, String courseName, String instructorId, int seats) 
	{
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.setInstructorId(instructorId);
		this.seats = seats;
	}
	
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
	 * Method to get available seats
	 * @return Seats available
	 */
	public int getSeats() {
		return seats;
	}
	
	/**
	 * Method to set available seats
	 * @param seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	/**
	 * Method to get Instructor Id of professor teaching the course
	 * @return Instructor Id
	 */
	public String getInstructorId() {
		return instructorId;
	}
	
	/**
	 * Method to set Instructor Id of professor teaching the course
	 * @param instructorId
	 */
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
}
