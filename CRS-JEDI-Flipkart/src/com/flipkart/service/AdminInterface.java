package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.List;

public interface AdminInterface {
	
	public void deleteCourse(String courseCode);
	public void addCourse(String courseCode, String courseName,String instructor);
	public List<Student> viewPendingAdmissions();
	public void approveStudent(String studentId);
	public void addProfessor(String name, String role, int userId, String password,String department);	
	public void assignCourse(String courseCode, int userId);
}
