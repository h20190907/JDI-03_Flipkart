/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Student;

/**
 * @author Anurag Behera, Rag Patel
 *
 */
public interface AdminDaoInterface {
	public void deleteCourse(String courseCode);
	public void addCourse(String courseCode, String courseName,String instructor);
	public List<Student> viewPendingAdmissions();
	public void approveStudent(String studentId);
	public void addProfessor(String name, String role, int userId, String password,String department);	
	public void assignCourse(String courseCode, int userId);
}
