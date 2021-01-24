package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.StudentNotFoundException;

import java.util.List;

/**
 * 
 * @author Anurag Behera, Rag Patel
 * Interface for Admin Operations
 * 
 */
public interface AdminInterface {
	
	public void deleteCourse(String courseCode) throws CourseNotFoundException;
	public void addCourse(Course course);
	public List<Student> viewPendingAdmissions();
	public void approveStudent(int studentId) throws StudentNotFoundException;
	public void addProfessor(Professor professor);	
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException ;
}
