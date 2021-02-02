package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;

/**
 * 
 * @author JEDI-03
 * Interface for Registration Operation
 * 
 */
public interface RegistrationInterface {
	
	/**
	 * Method to add Course selected by student 
	 * @param courseCode
	 * @param studentId
	 * @param courseList 
	 * @return boolean indicating if the course is added successfully
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 * @throws SQLException 
	 */
	public boolean addCourse(String courseCode, int studentId, List<Course> courseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException, SQLException ;
	
	/**
	 *  Method to drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList 
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotFoundException
	 * @throws SQLException 
	 */
	public boolean dropCourse(String courseCode, int studentId, List<Course> registeredCourseList) throws CourseNotFoundException, SQLException;
	
	/**
	 *  Method to view the list of available courses
	 * @param studentId
	 * @return List of courses
	 * @throws SQLException 
	 */
	public List<Course> viewCourses(int studentId) throws SQLException;
	
	/**
	 * Method to view the list of courses registered by the student
	 * @param studentId
	 * @return List of courses
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;
	
	/**
	 * Method to view grade card for students
	 * @param studentId
	 * @return List of Student's Grades
	 * @throws SQLException 
	 */
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException;
	
	/** Method for Fee Calculation for selected courses
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return Fee Student has to pay
	 * @throws SQLException 
	 */
	public double calculateFee(int studentId) throws SQLException;

	/**
	 *  Method to check student registration status
	 * @param studentId
	 * @return boolean indicating if the student's registration status
	 * @throws SQLException
	 */
	public boolean getRegistrationStatus(int studentId) throws SQLException;
	
	/**
	 *  Method to set student registration status
	 * @param studentId
	 * @throws SQLException
	 */
	public void setRegistrationStatus(int studentId) throws SQLException;
	
}
