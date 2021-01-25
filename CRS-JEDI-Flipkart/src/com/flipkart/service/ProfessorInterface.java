package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import com.flipkart.exception.GradeNotAddedException;

import java.util.List;

public interface ProfessorInterface {
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException;
	public List<Student> viewEnrolledStudents(String profId,String courseCode);
	/**
	 * 
	 * @param profId
	 * @return the list of courses the professor is teaching
	 */
	public List<Course> getCourses(String profId);
}
