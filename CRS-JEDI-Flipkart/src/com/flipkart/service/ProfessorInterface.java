package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorInterface {
	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @return
	 * @throws GradeNotAddedException
	 */
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException;
	
	/**
	 * 
	 * @param profId
	 * @return
	 */
	public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;
	/**
	 * 
	 * @param profId
	 * @return the list of courses the professor is teaching
	 */
	public List<Course> getCourses(String profId);
	/**
	 * get the professor name with ID
	 * @param profId
	 * @return
	 */
	public String getProfessorById(String profId);
}
