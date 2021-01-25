package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.StudentNotFoundException;

import java.util.List;

/**
 * 
 * @author JDI-03
 * Interface for Admin Operations
 * 
 */
public interface AdminInterface {
	

	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @throws CourseNotFoundException 
	 */
	public void deleteCourse(String courseCode) throws CourseNotFoundException;
	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 */
	public void addCourse(Course course);
	/**
	 * Method to view Students yet to be approved by Admin
	 * @return List of Students
	 */
	public List<Student> viewPendingAdmissions();
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @throws StudentNotFoundException 
	 */
	public void approveStudent(int studentId) throws StudentNotFoundException;
	/**
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 */
	public void addProfessor(Professor professor);	
	/**
	 * Method to assign Course to a Professor
	 * @param courseCode
	 * @param userId
	 * @throws CourseNotFoundException 
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException ;
}
