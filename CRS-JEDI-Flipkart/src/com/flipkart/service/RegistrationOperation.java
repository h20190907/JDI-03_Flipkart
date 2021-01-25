package com.flipkart.service;

import java.util.List;



import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;

/**
 * @author JDI-03
 *	The Registration Operation provides the business logic for student registration.
 */
public class RegistrationOperation implements RegistrationInterface {
    
	private static volatile RegistrationOperation instance=null;
	private RegistrationOperation()
	{}
	
	/**
	 * Method to make Registration Operation Singleton
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
	 * Method to register course selected by student
	 * @param studentId 
	 * @param courseList : list of courses selected by student
	 * @return 
	 * @throws CourseNotFoundException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	
	@Override
	public boolean registerCourses(int studentId, List<String> courseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException{

		return registrationDaoInterface.registerCourses(studentId, courseList);
	}

	/**
	 * Method to add Course selected by student 
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException {
		
		return registrationDaoInterface.addCourse(courseCode, studentId);
		
	}

	/**
	 * Method to drop Course selected by student
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
		
		return registrationDaoInterface.dropCourse(courseCode, studentId);
		
	}
	
	/**
	 * Method for Fee Calculation for selected courses
	 * @param studentId 
	 * @return
	 */
	
	@Override
	public double calculateFee(int studentId)
	{
		return registrationDaoInterface.calculateFee(studentId);
	}
	
	/**
	 * method for fee payment for selected courses
	 * @param studentId
	 * @param mode - mode of payment
	 * @param amount - amount to be paid by student
	 */
	@Override
	public Notification payFee(int studentId, ModeOfPayment mode, double amount) 
	{
		return registrationDaoInterface.payFee(studentId, mode, amount);
		
	}

	/**
	 * Method to view grade card for students
	 * @param studentId
	 * @return
	 */
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) {
		return registrationDaoInterface.viewGradeCard(studentId);
	}

	/**
	 * Method to view the list of available courses
	 * The list will not display the courses registered by student
	 * @param studentId
	 */
	@Override
	public List<Course> viewCourses(int studentId) {
		return registrationDaoInterface.viewCourses(studentId);
	}

	/**
	 * Method to view the list of courses registered by the student
	 * @param studentId
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentId) {
		return registrationDaoInterface.viewRegisteredCourses(studentId);
	}
}
