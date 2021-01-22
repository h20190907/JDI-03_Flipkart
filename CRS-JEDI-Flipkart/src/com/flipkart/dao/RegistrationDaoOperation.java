/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

/**
 * 
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface{

	@Override
	public boolean registerCourses(int studentId, List<String> clist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException {
		throw new CourseNotFoundException(courseCode);
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
		throw new CourseNotFoundException(courseCode);
	}

	@Override
	public double payFees(int studentId) {
		return 0.0;
	}

	@Override
	public List<Course> viewGradeCard(int studentId) {
		// TODO Auto-generated method stub
		return null;
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
