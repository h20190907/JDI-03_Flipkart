/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserNotAddedException;

/**
 * @author JD1-03
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 */
	public void deleteCourse(String courseCode) throws CourseNotFoundException;

	/**
	 * Add Course using SQL commands
	 * @param course
	 */
	public void addCourse(Course course);
	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return
	 */
	public List<Student> viewPendingAdmissions();
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 */
	public void approveStudent(int studentId) throws StudentNotFoundException;
	/**
	 * Add professor using SQL commands
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException;
	/**Method to add user using SQL commands
	 * @param user
	 */
	public void addUser(User user) throws UserNotAddedException;	
	/**
	 * Assign courses to Professor using SQL commands
	 * @param courseCode
	 * @param professorId
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException;
	/**
	 * View courses in the catalog
	 * @param Catalog ID
	 * @return List of courses in the catalog
	 */
	public List<Course> viewCourses(int catalogId);
}
