package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.CourseNotFoundException;

public interface RegistrationInterface {
	public boolean  registerCourses(int studentId,List<String>clist) ;
	public boolean addCourse(String courseCode, int studentId);
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException;
	public double calculateFees(int studentId);
	public float generateReportCard(int semester,int studentId);
	public void viewCourses(int studentId);
	public void viewRegisteredCourses(int studentId);
}
