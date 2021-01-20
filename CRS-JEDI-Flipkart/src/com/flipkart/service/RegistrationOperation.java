package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

public class RegistrationOperation implements RegistrationInterface {
	
	//TODO: arraylist of courses
	List<Course> courseCatalogue=new ArrayList<Course>();
	//TODO: add courses

	@Override
	public List<RegisteredCourse> registerCourses(int semester, String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCourse(String courseCode, int semester, String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String courseCode, int semester, String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculateFees(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float generateReportCard(int semester, String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		//isOffered check and seats check
		return null;
	}

}
