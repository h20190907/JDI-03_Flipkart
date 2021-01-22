package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.CourseNotFoundException;

public interface RegistrationInterface {
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
	 */
	public void viewCourses(int studentId);
	/**
	 * 
	 * @param studentId
	 */
	public void viewRegisteredCourses(int studentId);
	
	/**
	 * Fee payment for selected courses
	 * @param studentId
	 * @return
	 */
	public boolean payFees(int studentId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public void viewGradeCard(int studentId);
}
