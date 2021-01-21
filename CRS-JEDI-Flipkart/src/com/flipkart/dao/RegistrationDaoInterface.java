/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;

/**
 * @author Umang
 *
 */
public interface RegistrationDaoInterface {
	public boolean  registerCourses(int studentId,List<String>clist);
	public boolean addCourse(String courseCode, int studentId);
	public boolean dropCourse(String courseCode, int studentId);
	public double calculateFees(int studentId);
	public float generateReportCard(int semester,int studentId);
	public List<Course> viewCourses(int studentId);
	public List<Course> viewRegisteredCourses(int studentId);
}
