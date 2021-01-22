package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseNotFoundException;

/**
 *
 */
public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);
	RegistrationDaoInterface  registrationDaoInterface  = new RegistrationDaoOperation();

	/**
	 * Register Courses selected by student
	 * @param studentId 
	 * @param clist  --> list of courses selected by student
	 * @return s
	 */
	
	@Override
	public boolean registerCourses(int studentId, List<String> courseList) {
		
		return registrationDaoInterface.registerCourses(studentId, courseList);
		
	}

	/**
	 * Add Course selected by student 
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	
	public boolean addCourse(String courseCode, int studentId)  {
		
		try
		{
			registrationDaoInterface.addCourse(courseCode, studentId);
		}
		catch(CourseNotFoundException e)
		{
			logger.error(e.getCourseCode() + "Not Found");
		}
		
		return true;
	}

	/**
	 * Drop Course selected by student
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
		try
		{
			registrationDaoInterface.dropCourse(courseCode, studentId);
		}
		catch(CourseNotFoundException e)
		{
			logger.error(e.getCourseCode() + "Not Found");
		}
		
		return true;
	}
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean payFees(int studentId) {
		registrationDaoInterface.payFees(studentId);
		return true;
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public void viewGradeCard(int studentId) {
		registrationDaoInterface.viewGradeCard(studentId);
	}

	/**
	 * View the list of available courses
	 * The list will not display the courses registered by student
	 * @param studentId
	 */
	@Override
	public void viewCourses(int studentId) {
		registrationDaoInterface.viewCourses(studentId);
	}

	/**
	 * View the list of courses registered by the student
	 * @param studentId
	 */
	@Override
	public void viewRegisteredCourses(int studentId) {
		registrationDaoInterface.viewRegisteredCourses(studentId);
	}
}
