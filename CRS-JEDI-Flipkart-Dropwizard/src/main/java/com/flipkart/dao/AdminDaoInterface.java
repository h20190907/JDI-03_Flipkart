/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

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
	public boolean deleteCourse(String courseCode);
	/**
	 * Add Course using SQL commands
	 * @param course
	 * @return 
	 */
	public boolean addCourse(Course course);
	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return
	 */
	public List<Student> viewPendingAdmissions();
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @return 
	 */
	public boolean approveStudent(int studentId);
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @return 
	 */
	public boolean addProfessor(Professor professor);
	/**Method to add user using SQL commands
	 * @param user
	 * @return 
	 */
	public boolean addUser(User user);	
	/**
	 * Assign courses to Professor using SQL commands
	 * @param courseCode
	 * @param professorId
	 * @return 
	 */
	public boolean assignCourse(String courseCode, String professorId);
	/**
	 * View courses in the catalog
	 * @param Catalog ID
	 * @return List of courses in the catalog
	 */
	public List<Course> viewCourses(int catalogId);
}
