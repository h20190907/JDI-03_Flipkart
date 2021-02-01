/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.Grade;

public class StudentGrade {
	
	private String courseCode;
	private String courseName;
	private String grade;
	
	public StudentGrade(String courseCode, String courseName, String grade) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.setGrade(grade);
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


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
