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
public class RegistrationDaoOperation implements RegistrationDaoInterface{

	@Override
	public boolean registerCourses(int studentId, List<String> clist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCourse(String courseCode, int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculateFees(int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float generateReportCard(int semester, int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> viewCourses(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
