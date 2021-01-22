package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;

public class ProfessorOperation implements ProfessorInterface {
	ProfessorDaoInterface professorDAOInterface=new ProfessorDaoOperation();
	@Override
	public Grade addGrade(int profId, String studentId, String courseCode, int semester) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * @param profId: professor id 
	 * @param courseCode: course code 
	 * @return view enrolled students for the course
	 */
	@Override
	public List<Student> viewEnrolledStudents(int profId, String courseCode) {
		// call the DAO class
		return null;
	}

	
	/**
	 * 
	 * @param profId (user id of the professor)
	 * @return the list of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses(int profId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		coursesOffered=professorDAOInterface.getCoursesByProfessor(profId);
		return coursesOffered;
	}
}
