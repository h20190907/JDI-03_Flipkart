/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.CourseNotFoundException;


public interface RegistrationDaoInterface {
	/**
	 * 
	 * @param studentId
	 * @param clist
	 * @return
	 * @throws CourseNotFoundException 
	 */
	public boolean  registerCourses(int studentId,List<String>clist) throws CourseNotFoundException;
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException;
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
	public Notification payFee(int studentId);
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
}
