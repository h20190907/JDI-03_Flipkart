package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;

public class AdminOperation implements AdminInterface{

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	AdminDaoInterface adminDaoOperation = new AdminDaoOperation();
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 */
	@Override
	public void deleteCourse(String courseCode) {
		adminDaoOperation.deleteCourse(courseCode);
	}

	/**
	 * Method to add Course to Course Catalog
	 * @param courseCode
	 * @param courseName
	 * @param instructor
	 */
	@Override
	public void addCourse(Course course) {
		adminDaoOperation.addCourse(course);
	}

	/**
	 * Method to view Students yet to be approved by Admin
	 * @return List of Students
	 */
	@Override
	public List<Student> viewPendingAdmissions() {
		adminDaoOperation.viewPendingAdmissions();
		return null;
	}
	
	/**
	 * Method to approve a Student 
	 * @param studentId
	 */
	@Override
	public void approveStudent(int studentId) {
		//TODO display viewPendingAdmissions
		adminDaoOperation.viewPendingAdmissions();
		adminDaoOperation.approveStudent(studentId);
	}

	/**
	 * Method to register a Professor
	 * @param name
	 * @param role
	 * @param userId
	 * @param password
	 * @param department
	 */
	@Override
	public void addProfessor(Professor professor) {
		
		adminDaoOperation.addProfessor(professor);
	}

	/**
	 * Method to assign a course to a Professor
	 * @param courseCode
	 * @param userId
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException {
		adminDaoOperation.assignCourse(courseCode, professorId);
	}

}
