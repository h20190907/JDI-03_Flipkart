/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.client.CRSApplication;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.utils.DBUtils;

/**
 * @author dilpreet kaur
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {
	
	private static volatile StudentDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	private StudentDaoOperation()
	{
		
	}
	
	public static StudentDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentDaoOperation.class){
				instance=new StudentDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * 
	 * @param name
	 * @param userID: student's email address
	 * @param password
	 * @param gender
	 * @param batch
	 * @param branch
	 * @param address: student's complete address
	 * @param country
	 * @return true, if record is added in DB, else false.
	 * @throws SQLException 
	 */
	@Override
	public boolean addStudent(Student student) throws StudentNotRegisteredException{
		Connection connection=DBUtils.getConnection();
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			preparedStatement.setString(1, student.getUserId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getRole().toString());
			preparedStatement.setString(5, student.getGender().toString());
			preparedStatement.setString(6, student.getAddress());
			preparedStatement.setString(7, student.getCountry());
			int rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected==1)
			{
				//add the student record
				//"insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent=connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
				preparedStatementStudent.setString(1,student.getUserId());
				preparedStatementStudent.setString(2, student.getBranchName());
				preparedStatementStudent.setInt(3, student.getBatch());
				preparedStatementStudent.setBoolean(4, false);
				preparedStatementStudent.executeUpdate();
			}
			
		}
		catch(Exception ex)
		{
			throw new StudentNotRegisteredException(student.getName());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"SQL error");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	@Override
	public int getStudentId(String userId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt("studentId");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return 0;
	}
	
	
	@Override
	public boolean isApproved(int studentId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getBoolean("isApproved");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return false;
	}

}
