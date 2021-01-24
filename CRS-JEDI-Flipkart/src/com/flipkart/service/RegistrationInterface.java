package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;

public interface RegistrationInterface {
	/**
	 * 
	 * @param studentId
	 * @param clist
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	public boolean registerCourses(int studentId,List<String>courselist) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException;
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException ;
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException;
	/**
	 * 
	 * @param studentId
	 * @return 
	 */
	public List<Course> viewCourses(int studentId);
	/**
	 * 
	 * @param studentId
	 * @return 
	 */
	public List<Course> viewRegisteredCourses(int studentId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<StudentGrade> viewGradeCard(int studentId);
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	public double calculateFee(int studentId);
	/**
	 * 
	 * @param studentId
	 * @param mode
	 * @param amount
	 * @return
	 */
	public Notification payFee(int studentId, ModeOfPayment mode, double amount);
}
