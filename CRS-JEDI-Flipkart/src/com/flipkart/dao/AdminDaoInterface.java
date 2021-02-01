/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserNotAddedException;

/**
 * @author JEDI-03
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @throws CourseNotFoundException
	 */
	public void deleteCourse(String courseCode) throws CourseNotFoundException;

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws CourseFoundException
	 */
	public void addCourse(Course course) throws CourseFoundException;
	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return List of Students yet to approved
	 */
	public List<Student> viewPendingAdmissions();
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	public void approveStudent(int studentId) throws StudentNotFoundException;
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException;
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 */
	public void addUser(User user) throws UserNotAddedException;
	
	/**
	 * Assign courses to Professor using SQL commands
	 * @param courseCode
	 * @param professorId
	 * @throws CourseNotFoundException
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException;
	
	/**
	 * View courses in the catalog
	 * @param Catalog ID
	 * @return List of courses in the catalog
	 */
	public List<Course> viewCourses(int catalogId);
}
