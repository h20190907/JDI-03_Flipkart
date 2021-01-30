/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author JDI-03
 * Interface for Registration DAO Operation
 *
 */
public interface RegistrationDaoInterface {
	
	/**
	 * Method to add course in database
	 * @param courseCode
	 * @param studentId
	 * @return 
	 * @throws SQLException 
	 */
	public boolean addCourse(String courseCode, int studentId) throws SQLException;
	
	/**
	 * Drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws SQLException 
	 */
	public boolean dropCourse(String courseCode, int studentId) throws SQLException;
	/**
	 * Method to get the list of courses available from course catalog 
	 * @param studentId
	 * @return list of Courses
	 * @throws SQLException 
	 */
	public List<Course> viewCourses(int studentId) throws SQLException;
	
	/**
	 * Method to View list of Registered Courses
	 * @param studentId
	 * @return list of Registered Courses
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;
	
	/**
	 * Method to view grade card of the student
	 * @param studentId
	 * @return Grade Card
	 * @throws SQLException 
	 */
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException;
	
	/**
	 * Method to retrieve fee for the selected courses from the database and calculate total fee
	 * @param studentId
	 * @return Fee Student has to pay
	 * @throws SQLException 
	 */
	public double calculateFee(int studentId) throws SQLException;
	
	/**
	 * Check if seat is available for that particular course
	 * @param courseCode
	 * @return seat availability status
	 * @throws SQLException 
	 */
	public boolean seatAvailable(String courseCode) throws SQLException;
	
	/**Method to get the list of courses registered by the student
	 * Number of registered courses for a student
	 * @param studentId
	 * @return Number of registered Courses
	 * @throws SQLException 
	 */
	public int numOfRegisteredCourses(int studentId) throws SQLException;
	
	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode
	 * @param studentId
	 * @return Students registration status
	 * @throws SQLException 
	 */
	public boolean isRegistered(String courseCode, int studentId) throws SQLException;
	
	/**
	 *  Method to get student registration status
	 * @param studentId
	 * @return Student's registration status
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