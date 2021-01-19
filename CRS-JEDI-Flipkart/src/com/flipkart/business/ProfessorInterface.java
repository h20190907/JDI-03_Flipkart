package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import java.util.List;

public interface ProfessorInterface {
	public Grade addGrade(int profId,String studentId,String courseCode,int semester);
	public List<Student> viewEnrolledStudents(int profId,String courseCode);
	public List<Course> getCourses(int profId);
}
