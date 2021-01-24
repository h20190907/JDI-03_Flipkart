package com.flipkart.dao;

import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentOperation;

public class ProfessorDaoOperation implements ProfessorDaoInterface {

	private static volatile ProfessorDaoOperation instance=null;
	public static ProfessorDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorDaoOperation.class){
				instance=new ProfessorDaoOperation();
			}
		}
		return instance;
	}
	
	
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
