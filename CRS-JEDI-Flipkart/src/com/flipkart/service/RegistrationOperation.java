package com.flipkart.service;

import java.util.List;



import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseNotFoundException;

/**
 *
 */
public class RegistrationOperation implements RegistrationInterface {
    
	private static volatile RegistrationOperation instance=null;
	private RegistrationOperation()
	{}
	
	/**
	 * Method to make RegistrationOperation Singleton
	 * @return
	 */
	public static RegistrationOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(RegistrationOperation.class)
			{
				instance=new RegistrationOperation();
			}
		}
		return instance;
	}
	
	
	RegistrationDaoInterface  registrationDaoInterface  = RegistrationDaoOperation.getInstance();

	/**
	 * Register Courses selected by student
	 * @param studentId 
	 * @param clist  --> list of courses selected by student
	 * @return s
	 * @throws CourseNotFoundException 
	 */
	
	@Override
	public boolean registerCourses(int studentId, List<String> courseList) {

		try
		{
			return registrationDaoInterface.registerCourses(studentId, courseList);
		}
		catch(CourseNotFoundException e)
		{
			e.getMessage();
		}
		
		return false;
	}

	/**
	 * Add Course selected by student 
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId) {
		
		try
		{
			return registrationDaoInterface.addCourse(courseCode, studentId);
		}
		catch(CourseNotFoundException e)
		{
			return false;
		}
	}

	/**
	 * Drop Course selected by student
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) {
		
		try
		{
			return registrationDaoInterface.dropCourse(courseCode, studentId);
		}
		catch(CourseNotFoundException e)
		{
			return false;
		}
	}
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	
	@Override
	public double calculateFee(int studentId)
	{
		return registrationDaoInterface.calculateFee(studentId);
	}
	
	@Override
	public Notification payFee(int studentId) {
		return registrationDaoInterface.payFee(studentId);
		
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) {
		return registrationDaoInterface.viewGradeCard(studentId);
	}

	/**
	 * View the list of available courses
	 * The list will not display the courses registered by student
	 * @param studentId
	 */
	@Override
	public List<Course> viewCourses(int studentId) {
		return registrationDaoInterface.viewCourses(studentId);
	}

	/**
	 * View the list of courses registered by the student
	 * @param studentId
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentId) {
		return registrationDaoInterface.viewRegisteredCourses(studentId);
	}
}
