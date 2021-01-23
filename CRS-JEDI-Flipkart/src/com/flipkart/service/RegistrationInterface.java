package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.CourseNotFoundException;

public interface RegistrationInterface {
	/**
	 * 
	 * @param studentId
	 * @param clist
	 * @return
	 */
	public boolean registerCourses(int studentId,List<String>courselist);
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean addCourse(String courseCode, int studentId) ;
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	public boolean dropCourse(String courseCode, int studentId);
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
	 * Fee payment for selected courses
	 * @param studentId
	 * @return
	 */
	public Notification payFee(int studentId);
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
}
