package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;

/**
 * 
 * @author Anurag Behera, Rag Patel
 * Implementations of Admin Operations
 * 
 */
public class AdminOperation implements AdminInterface{

	private static volatile AdminOperation instance = null;
	
	private AdminOperation()
	{
		
	}
	
	/**
	 * Method to make AdminOperation Singleton
	 * @return
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}
	

	AdminDaoInterface adminDaoOperation =AdminDaoOperation.getInstance();
	
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
	 * @param course : Course object storing details of a course
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
		return adminDaoOperation.viewPendingAdmissions();
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
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 */
	@Override
	public void addProfessor(Professor professor) {
		
		adminDaoOperation.addProfessor(professor);
	}

	/**
	 * Method to assign Course to a Professor
	 * @param courseCode
	 * @param userId
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException {
		adminDaoOperation.assignCourse(courseCode, professorId);
	}

}
