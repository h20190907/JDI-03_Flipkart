/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author Umang
 *
 */
public interface RegistrationDaoInterface {
	/**
	 * 
	 * @param studentId
	 * @param clist
	 * @return
	 */
	public boolean  registerCourses(int studentId,List<String>clist);
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
	public double payFees(int studentId);
	public List<Course> viewGradeCard(int studentId);
}
