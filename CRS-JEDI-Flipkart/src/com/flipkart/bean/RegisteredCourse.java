/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.Grade;

/**
 * @author dilpreetkaur
 *
 */
public class RegisteredCourse{
	 private String courseCode;
	 private String studentId;
	 private int semester;
	 private Grade grade;
	 
	 public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	 
}
