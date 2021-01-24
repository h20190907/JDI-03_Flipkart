/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;


public interface RegistrationDaoInterface {
	
	/**
	 * 
	 * @param studentId
	 * @param clist
	 * @return
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	public boolean  registerCourses(int studentId,List<String>clist) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException;
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException;
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
	 * 
	 * @param studentId
	 * @return
	 */
	public double calculateFee(int studentId);
	/**
	 * 
	 * @param courseCode
	 * @return
	 */
	public boolean seatAvailable(String courseCode);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public int numOfRegisteredCourses(int studentId);
	
	/**
	 * 
	 * @param studentId
	 * @param mode
	 * @param amount
	 * @return
	 */
	Notification payFee(int studentId, ModeOfPayment mode, double amount);
}
