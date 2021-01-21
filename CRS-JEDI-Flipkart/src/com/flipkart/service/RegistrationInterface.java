package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

public interface RegistrationInterface {
	public List<RegisteredCourse>  registerCourses(int studentId,List<String>clist);
	public boolean addCourse(String courseCode, int studentId);
	public boolean dropCourse(String courseCode, int studentId);
	public double calculateFees(int studentId);
	public float generateReportCard(int semester,int studentId);
	public void viewCourses(int studentId);
	public void viewRegisteredCourses(int studentId);
}
