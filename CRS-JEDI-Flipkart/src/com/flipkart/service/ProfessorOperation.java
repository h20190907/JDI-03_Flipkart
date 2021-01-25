package com.flipkart.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.utils.DBUtils;

public class ProfessorOperation implements ProfessorInterface {
	
	private static volatile ProfessorOperation instance=null;
	ProfessorDaoInterface professorDAOInterface=ProfessorDaoOperation.getInstance();
	private ProfessorOperation()
	{

	}
	
	/**
	 * Method to make ProfessorOperation Singleton
	 * @return
	 */
	public static ProfessorOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorOperation.class){
				instance=new ProfessorOperation();
			}
		}
		return instance;
	}
	
	
	

	
	@Override
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(studentId, courseCode, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	
	
	/**
	 * @param profId: professor id 
	 * @param courseCode: course code 
	 * @return view enrolled students for the course
	 */
	@Override
	public List<Student> viewEnrolledStudents(String profId, String courseCode) {
		// call the DAO class
		return null;
	}

	
	/**
	 * 
	 * @param profId (user id of the professor)
	 * @return the list of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses(String profId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		coursesOffered=professorDAOInterface.getCoursesByProfessor(profId);
		return coursesOffered;
	}
	
	/**
	 * get the professor name with ID
	 * @param profId
	 * @return
	 */
	@Override
	public String getProfessorById(String profId)
	{
		return professorDAOInterface.getProfessorById(profId);
	}
}
