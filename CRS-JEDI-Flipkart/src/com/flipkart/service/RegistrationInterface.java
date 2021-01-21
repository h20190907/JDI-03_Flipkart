package com.flipkart.service;

import java.util.List;

public interface RegistrationInterface {
	public boolean  registerCourses(int studentId,List<String>clist);
	public boolean addCourse(String courseCode, int studentId);
	public boolean dropCourse(String courseCode, int studentId);
	public double calculateFees(int studentId);
	public float generateReportCard(int semester,int studentId);
	public void viewCourses(int studentId);
	public void viewRegisteredCourses(int studentId);
}
