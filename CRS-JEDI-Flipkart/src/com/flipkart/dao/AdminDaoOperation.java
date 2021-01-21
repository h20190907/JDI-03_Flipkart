package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Student;

public class AdminDaoOperation implements AdminDaoInterface{

	@Override
	public void deleteCourse(String courseCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(String courseCode, String courseName, String instructor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> viewPendingAdmissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveStudent(String studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(String name, String role, int userId, String password, String department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignCourse(String courseCode, int userId) {
		// TODO Auto-generated method stub
		
	}

}
