package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;

public class AdminOperation implements AdminInterface{

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	AdminDaoInterface adminDaoOperation = new AdminDaoOperation();
	
	@Override
	public void deleteCourse(String courseCode) {
		adminDaoOperation.deleteCourse(courseCode);
	}

	@Override
	public void addCourse(String courseCode, String courseName, String instructor) {
		adminDaoOperation.addCourse(courseCode, courseName, instructor);
	}

	@Override
	public List<Student> viewPendingAdmissions() {
		adminDaoOperation.viewPendingAdmissions();
		return null;
	}

	@Override
	public void approveStudent(String studentId) {
		//TODO display viewPendingAdmissions
		adminDaoOperation.viewPendingAdmissions();
		adminDaoOperation.approveStudent(studentId);
	}

	@Override
	public void addProfessor(String name, String role, int userId, String password, String department) {
		adminDaoOperation.addProfessor(name, role, userId, password, department);
	}

	@Override
	public void assignCourse(String courseCode, int userId) {
		adminDaoOperation.assignCourse(courseCode, userId);
	}

}
