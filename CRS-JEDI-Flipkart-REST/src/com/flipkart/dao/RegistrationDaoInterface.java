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
	 * @throws CourseNotFoundException
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
	 * @return
	 * @throws SQLException 
	 */
	public List<Course> viewCourses(int studentId) throws SQLException;
	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;
	/**
	 * Method to view grade card of the student
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException;
	/**
	 * Method to retrieve fee for the selected courses from the database and calculate total fee
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	public double calculateFee(int studentId) throws SQLException;
	/**
	 * Check if seat is available for that particular course
	 * @param courseCode
	 * @return
	 * @throws SQLException 
	 */
	public boolean seatAvailable(String courseCode) throws SQLException;
	
	
	/**
	 *  Method for fee payment and send notification to client. The transaction id for the session is generated by UUID.
	 * @param studentId
	 * @param mode
	 * @param amount
	 * @return 
	 * @throws SQLException 
	 */
	public Notification payFee(int studentId, ModeOfPayment mode, double amount) throws SQLException;
	/**
	 *  Method to get student registration status
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	public boolean getRegistrationStatus(int studentId) throws SQLException;
	/**
	 *  Method to set student registration status
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	public void setRegistrationStatus(int studentId) throws SQLException;
	
	/**Method to checkCourseAvailability , if course is already registered by student then return 1 , 
	 * if number of registered courses by student is greater than 5 then return 0, else return 2
	 * @param studentId
	 * @param courseCode
	 * @return
	 * @throws SQLException 
	 */
	int checkCourseAvailability(int studentId, String courseCode) throws SQLException;
	
	
}