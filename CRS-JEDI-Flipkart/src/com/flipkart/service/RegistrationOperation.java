package com.flipkart.service;

import java.sql.SQLException;
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
import com.flipkart.validator.StudentValidator;

/**
 * @author JDI-03 The Registration Operation provides the business logic for
 *         student registration.
 */
public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;

	private RegistrationOperation() {
	}

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
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId,List<Course> availableCourseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException, SQLException 
	{
       
		

		if (registrationDaoInterface.numOfRegisteredCourses(studentId) >= 6)
		{	
			throw new CourseLimitExceedException(6);
		}
		else if (registrationDaoInterface.isRegistered(courseCode, studentId)) 
		{
			return false;
		} 
		else if (!registrationDaoInterface.seatAvailable(courseCode)) 
		{
			throw new SeatNotAvailableException(courseCode);
		} 
		else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
		{
			throw new CourseNotFoundException(courseCode);
		}
		
		  

		return registrationDaoInterface.addCourse(courseCode, studentId);

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
	public boolean dropCourse(String courseCode, int studentId,List<Course> registeredCourseList) throws CourseNotFoundException, SQLException {
		  if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
	        {
	        	throw new CourseNotFoundException(courseCode);
	        }
		
		return registrationDaoInterface.dropCourse(courseCode, studentId);

	}

	/**
	 * Method for Fee Calculation for selected courses
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */

	@Override
	public double calculateFee(int studentId) throws SQLException {
		return registrationDaoInterface.calculateFee(studentId);
	}


	/**
	 * Method to view grade card for students
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException {
		return registrationDaoInterface.viewGradeCard(studentId);
	}

	/**
	 * Method to view the list of available courses The list will not display the
	 * courses registered by student
	 * 
	 * @param studentId
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewCourses(int studentId) throws SQLException {
		return registrationDaoInterface.viewCourses(studentId);
	}

	/**
	 * Method to view the list of courses registered by the student
	 * 
	 * @param studentId
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		return registrationDaoInterface.viewRegisteredCourses(studentId);
	}
    
	/**
	 * 
	 * @param studentId
	 * @throws SQLException
	 */
	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		return registrationDaoInterface.getRegistrationStatus(studentId);
	}
	
	/**
	 * 
	 * @param studentId
	 * @throws SQLException
	 */
	@Override
	public void setRegistrationStatus(int studentId) throws SQLException {
		registrationDaoInterface.setRegistrationStatus(studentId);

	}

}
