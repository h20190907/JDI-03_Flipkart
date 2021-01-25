package com.flipkart.service;

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
 * @author JDI-03
 * Interface for Registration Operation
 */
public interface RegistrationInterface {
	/**
	 *  Method to register course selected by student
	 * @param studentId
	 * @param courselist
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	public boolean registerCourses(int studentId,List<String>courselist) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException;
	/**
	 * Method to add Course selected by student 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException ;
	/**
	 *  Method to drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException;
	/**
	 *  Method to view the list of available courses
	 * @param studentId
	 * @return 
	 */
	public List<Course> viewCourses(int studentId);
	/**
	 * Method to view the list of courses registered by the student
	 * @param studentId
	 * @return 
	 */
	public List<Course> viewRegisteredCourses(int studentId);
	/**
	 * Method to view grade card for students
	 * @param studentId
	 * @return
	 */
	public List<StudentGrade> viewGradeCard(int studentId);
	
	/** Method for Fee Calculation for selected courses
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	public double calculateFee(int studentId);
	/**
	 * method for fee payment for selected courses
	 * @param studentId
	 * @param mode
	 * @param amount
	 * @return
	 */
	public Notification payFee(int studentId, ModeOfPayment mode, double amount);
}
