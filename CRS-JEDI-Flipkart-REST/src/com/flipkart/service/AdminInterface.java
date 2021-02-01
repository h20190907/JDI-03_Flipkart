package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserNotAddedException;

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
	public void deleteCourse(String courseCode, List<Course> courseList) throws CourseNotFoundException;
	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 */
	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException;
	/**
	 * Method to view Students yet to be approved by Admin
	 * @return List of Students
	 */
	public List<Student> viewPendingAdmissions();
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException 
	 */
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException;
	/**
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 * @throws UserNotAddedException 
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserNotAddedException;	
	/**
	 * Method to assign Course to a Professor
	 * @param courseCode 
	 * @throws CourseNotAssignedToProfessorException 
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotAssignedToProfessorException;
	/**
	 * Method to get list of courses in catalog
	 * @param catalogId
	 * @return List of courses in catalog
	 */
	public List<Course> viewCourses(int catalogId);
}
