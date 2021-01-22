package com.flipkart.dao;

import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class ProfessorDaoOperation implements ProfessorDaoInterface {

	
	/**
	 * @param: profID (professor id for which courses have to be fetched)
	 * @return: courses for the corresponding professor
	 */
	@Override
	public List<Course> getCoursesByProfessor(int profId) {
		return null;
	}

	/**
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Override
	public List<Student> getEnrolledStudents(int profId, String courseCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param: studentId: student id for the student
	 * @param: courseCode: courseCode 
	 */
	
	public Boolean addGrade(String studentId,String courseCode) {
		return false;
	}
}
