/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.Grade;

/**
 * 
 * @author JEDI-03
 * Class to store Student Grade information
 * 
 */
public class StudentGrade {
	
	private String courseCode;
	private String courseName;
	private String grade;
	
	/**
	 * Parameterized Constructor
	 * @param courseCode: course code
	 * @param courseName: course name
	 * @param grade: grade 
	 */
	public StudentGrade(String courseCode, String courseName, String grade) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.setGrade(grade);
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
	 * Method to get grade 
	 * @return Grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Method to set grade 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
