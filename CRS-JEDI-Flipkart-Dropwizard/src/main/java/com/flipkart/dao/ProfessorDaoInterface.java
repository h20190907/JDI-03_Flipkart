package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;

public interface ProfessorDaoInterface {
	/**
	 * 
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 */
	public List<Course> getCoursesByProfessor(String userId);
	
	
	/**
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	public List<EnrolledStudent> getEnrolledStudents(String profId);
	
	/**
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public Boolean addGrade(int studentId,String courseCode,String grade);


	/**
	 * Get professor name by id
	 * @param profId
	 * @return
	 */
	public String getProfessorById(String profId);
}
