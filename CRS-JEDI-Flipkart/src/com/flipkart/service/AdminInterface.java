package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.List;

public interface AdminInterface {
	public boolean deleteCourse(String courseCode);
	public boolean addCourse(String courseCode, String courseName,String instructor);
	public List<Student> viewPendingAdmissions();
	public boolean approveStudent(String studentId);
	public boolean addProfessor(String name, String role, int userId, String password,String department);	
	public void assignCourse(String courseCode, String userId);
	public void generateGradeCard();
}
