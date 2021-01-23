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

/**
 * @author Anurag Behera, Rag Patel
 *
 */
public interface AdminDaoInterface {
	public void deleteCourse(String courseCode);
	public void addCourse(Course course);
	public List<Student> viewPendingAdmissions();
	public void approveStudent(int studentId);
	public void addProfessor(Professor professor);	
	public void addUser(User user);	
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException;
}
