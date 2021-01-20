package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Student;

public class AdminOperation implements AdminInterface{

	@Override
	public boolean deleteCourse(String courseCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCourse(String courseCode, String courseName, String instructor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> viewPendingAdmissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveStudent(String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProfessor(String name, String role, int userId, String password, String department) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void assignCourse(String courseCode, String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateGradeCard() {
		// TODO Auto-generated method stub
		
	}
}
