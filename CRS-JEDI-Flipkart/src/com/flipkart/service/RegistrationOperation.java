package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);

	/**
	 * Register Courses selected by student
	 * @param studentId 
	 * @param clist  --> list of courses selected by student
	 * @return s
	 */
	
	@Override
	public boolean registerCourses(int studentId, List<String> courseList) {
		return true;
	}

	/**
	 * Add Course selected by student 
	 * @param courseCode --> code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	
	
	public boolean addCourse(String courseCode, int studentId) {
		return true;
	}

	/**
	 * Drop Course selected by student
	 * @param courseCode --> code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
		return true;
	}
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	@Override
	public double calculateFees(int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	@Override
	public float generateReportCard(int semester, int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * View the list of available courses
	 * The list will not display the courses registered by student
	 * @param studentId
	 */
	@Override
	public void viewCourses(int studentId) {

	}

	/**
	 * View the list of courses registered by the student
	 * @param studentId
	 */
	@Override
	public void viewRegisteredCourses(int studentId) {
//		
	}
}
