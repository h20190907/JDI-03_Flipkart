package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.service.StudentOperation;
import com.flipkart.utils.DBUtils;

public class ProfessorDaoOperation implements ProfessorDaoInterface {

	private static volatile ProfessorDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(UserDaoOperation.class);
	private ProfessorDaoOperation()
	{
		
	}
	
	/**
	 * Method to make ProfessorDaoOperation Singleton
	 * @return
	 */
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
	public List<Course> getCoursesByProfessor(String profId) {
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);
			
			statement.setString(1, profId);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseCode"),results.getString("courseName"),results.getString("professorId"),results.getInt("seats")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
		
	}

	/**
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Override
	public List<Student> getEnrolledStudents(String profId, String courseCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param: studentId: student id for the student
	 * @param: courseCode: courseCode 
	 */
	
	public Boolean addGrade(int studentId,String courseCode,String grade) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);
			
			statement.setString(1, grade);
			statement.setString(2, courseCode);
			statement.setInt(3, studentId);
			
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	

	/**
	 * Get professor name by id
	 * @param profId
	 * @return
	 */
	@Override
	public String getProfessorById(String profId)
	{
		String prof_Name = null;
		Connection connection=DBUtils.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_PROF_NAME);
			
			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			prof_Name = rs.getString(1);
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return prof_Name;
	}
}
