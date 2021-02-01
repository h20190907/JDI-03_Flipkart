package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.validator.StudentValidator;


/**
 * @author JDI-03 The Registration Operation provides the business logic for
 *         student registration.
 */
public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;
	private static Logger logger = Logger.getLogger(RegistrationOperation.class);

	private RegistrationOperation() 
	{}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();
	

	/**
	 * Method to add Course selected by student
	 * 
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException
	 * @throws CourseLimitExceedException
	 * @throws CourseAlreadyRegisteredException
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId,List<Course> availableCourseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException,CourseAlreadyRegisteredException 
	{
       
		try {
				if (registrationDaoInterface.numOfRegisteredCourses(studentId) >= 6)
				{	
					throw new CourseLimitExceedException(6);
				}
				else if (registrationDaoInterface.isRegistered(courseCode, studentId)) 
				{
					throw new CourseAlreadyRegisteredException(courseCode);
				}
				else if (!registrationDaoInterface.seatAvailable(courseCode)) 
				{
					throw new SeatNotAvailableException(courseCode);
				} 
				else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
				{
					throw new CourseNotFoundException(courseCode);
				}	

			registrationDaoInterface.addCourse(courseCode, studentId);
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;


	}

	/**
	 * Method to drop Course selected by student
	 * 
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId,List<Course> registeredCourseList) throws CourseNotFoundException{
		  if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
	        {
	        	throw new CourseNotFoundException(courseCode);
	        }
		
		try {
			return registrationDaoInterface.dropCourse(courseCode, studentId);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}

		return false;
	}

	/**
	 * Method for Fee Calculation for selected courses
	 * 
	 * @param studentId
	 * @return
	 */

	@Override
	public double calculateFee(int studentId) 
	{
		try 
		{
			return registrationDaoInterface.calculateFee(studentId);
		}
		catch (SQLException e) {
			logger.info(e.getMessage());
		}
		
		return 0.0;
	}

	/**
	 * method for fee payment for selected courses
	 * 
	 * @param studentId
	 * @param mode      - mode of payment
	 * @param amount    - amount to be paid by student
	 */
	@Override
	public Notification payFee(int studentId, ModeOfPayment mode, double amount) {
		
		try 
		{
			return registrationDaoInterface.payFee(studentId, mode, amount);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}

		return null;
	}

	/**
	 * Method to view grade card for students
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) {
		try
		{
			return registrationDaoInterface.viewGradeCard(studentId);
		}
		catch(SQLException e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}

	/**
	 * Method to view the list of available courses The list will not display the
	 * courses registered by student
	 * 
	 * @param studentId
	 */
	@Override
	public List<Course> viewCourses(int studentId)  {
		
		try 
		{
			return registrationDaoInterface.viewCourses(studentId);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}

	/**
	 * Method to view the list of courses registered by the student
	 * 
	 * @param studentId
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentId) {
		
		try 
		{
			return registrationDaoInterface.viewRegisteredCourses(studentId);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}
    
	/**
	 * 
	 * @param studentId
	 */
	@Override
	public boolean getRegistrationStatus(int studentId) {
		
		try 
		{		
			return registrationDaoInterface.getRegistrationStatus(studentId);	
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param studentId
	 */
	@Override
	public void setRegistrationStatus(int studentId) {
		try
		{
			registrationDaoInterface.setRegistrationStatus(studentId);
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}

	}

}
