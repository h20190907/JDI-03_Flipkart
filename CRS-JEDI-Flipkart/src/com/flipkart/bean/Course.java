package com.flipkart.bean;

public class Course {
	//TODO: add constructor 
	private String courseCode;
	private String courseName;
	private String instructorId;
	private int seats = 10;
	private boolean isOffered;
	
	public Course(String courseCode, String courseName, String instructorId, int seats, boolean isOffered) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.instructorId = instructorId;
		this.seats = seats;
		this.isOffered = isOffered;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructor() {
		return instructorId;
	}
	public void setInstructor(String instructor) {
		this.instructorId = instructor;
	}
	public boolean isOffered() {
		return isOffered;
	}
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
