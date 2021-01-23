/**
 * 
 */
package com.flipkart.bean;
public class StudentGrade {
	
	private String courseCode;
	private String courseName;
	
	public StudentGrade(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
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
	

}
