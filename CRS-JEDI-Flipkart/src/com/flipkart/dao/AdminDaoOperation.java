package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtils;

public class AdminDaoOperation implements AdminDaoInterface{

	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
	Connection connection = DBUtils.getConnection();
	
	@Override
	public void deleteCourse(String courseCode) {
		try {
			String sql = "delete from Course where courseCode = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,courseCode);
			int row = statement.executeUpdate();
			
			logger.info(row + " deleted");
			logger.info(courseCode + " deleted");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void addCourse(String courseCode, String courseName, String instructor) {
		try {
			
			String sql = "insert into Course(courseCode, courseName, catalogId, professorId) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, courseCode);
			statement.setString(2, courseName);
			statement.setString(3, "1");
			statement.setString(4, instructor);
			int row = statement.executeUpdate();
			
			logger.info(row + " course added");
			logger.info(courseName + "is added to Catalog"); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public List<Student> viewPendingAdmissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveStudent(int studentId) {
		try {
			String sql = "update Studennt set isApproved = 1 where studentId = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(2,studentId);
			int row = statement.executeUpdate();
			
			logger.info(row + " Updated");
			logger.info(studentId + "is Approved");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void addProfessor(String name, String role, int userId, String password, String department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignCourse(String courseCode, int professorId) {
		try {
			String sql = "update Course set professorId = ? where courseCode = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1,professorId);
			statement.setString(2,courseCode);
			int row = statement.executeUpdate();
			
			logger.info(row + " Updated");
			logger.info(courseCode + "is assigned to " + professorId);
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
		
		
	}

}
