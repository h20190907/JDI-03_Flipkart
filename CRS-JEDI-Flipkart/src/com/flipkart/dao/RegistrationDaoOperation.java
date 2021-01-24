/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Grade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.utils.DBUtils;


/**
 *	This class communicates with the database	 
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface{
    
	
	private static volatile RegistrationDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);
	private PreparedStatement stmt = null;
	
	private RegistrationDaoOperation() 
	{}
	
	public static RegistrationDaoOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(RegistrationDaoOperation.class){
				instance=new RegistrationDaoOperation();
			}
		}
		return instance;
	}
	
	
	/**
	 * Method to register course in database, throws exception if not registered.
	 * @param studentId
	 * @param courselist
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 */
	@Override
	public boolean registerCourses(int studentId, List<String> courselist) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException {
		
		boolean check = true;
		
		for (String courseCode : courselist)
		{
			check  = check & addCourse(courseCode, studentId);
		}
		
		
		return check;
	}

	/**
	 * Method to add course in database
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException if course not found in catalog
	 * @throws CourseLimitExceedException if course limit exceeded
	 * @throws SeatNotAvailableException if seat is not available
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException {
		

		Connection conn = DBUtils.getConnection();
		
		if (numOfRegisteredCourses(studentId) >= 6)
		{	
			throw new CourseLimitExceedException(6);
		}
		else if (isRegistered(courseCode, studentId)) 
		{
			return false;

		} 
		else if (!seatAvailable(courseCode)) 
		{
			throw new SeatNotAvailableException(courseCode);
		} 
		else 
		{

			try 
			{
				stmt = conn.prepareStatement(SQLQueriesConstant.ADD_COURSE);
				stmt.setInt(1, studentId);
				stmt.setString(2, courseCode);

				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(SQLQueriesConstant.DECREMENT_COURSE_SEATS);
				stmt.setString(1, courseCode);
				stmt.executeUpdate();
				return true;
			}
			catch (SQLException e) 
			{
				throw new CourseNotFoundException(courseCode);

			}
			finally
			{
				try
				{
					stmt.close();
					conn.close();
				}
				catch(SQLException e)
				{
					e.getErrorCode();
				}
			}
		}
		
	}
	

	/**
	 * Number of registered courses for a student
	 * @param studentId
	 * @return
	 */
	@Override
	public int numOfRegisteredCourses(int studentId) {
		
		Connection conn = DBUtils.getConnection();
		
		int count = 0;
		try {

			stmt = conn.prepareStatement(SQLQueriesConstant.NUMBER_OF_REGISTERED_COURSES);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count++;
			}
			return count;

		}
		catch (SQLException se) 
		{

			logger.error(se.getMessage());

		} 
		catch (Exception e)
		{

			logger.error(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return count;
	}

	/**
	 * 
	 * @param courseCode
	 * @return
	 */
	@Override
	public boolean seatAvailable(String courseCode) {

		Connection conn = DBUtils.getConnection();
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_SEATS);
			stmt.setString(1, courseCode);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return (rs.getInt("seats") > 0);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return true;
		

	}


	/**
	 * Drop Course selected by student
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException{
	
		Connection conn = DBUtils.getConnection();
		
		if(!isRegistered(courseCode,studentId))
		{
			throw new CourseNotFoundException(courseCode);
		}
		else
		{
			try
			{
				stmt = conn.prepareStatement(SQLQueriesConstant.DROP_COURSE_QUERY);
				stmt.setString(1, courseCode);
				stmt.setInt(2, studentId);
				stmt.execute();
				
				stmt = conn.prepareStatement(SQLQueriesConstant.INCREMENT_SEAT_QUERY);
				stmt.setString(1, courseCode);
				stmt.execute();
				
				stmt.close();
				
				return true;
			}
			catch(Exception e)
			{
				logger.info("Exception found" + e.getMessage());
			}
			finally
			{
				try
				{
					stmt.close();
					conn.close();
				}
				catch(SQLException e)
				{
					e.getErrorCode();
				}
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode
	 * @param studentId
	 * @return
	 */
	public boolean isRegistered(String courseCode, int studentId){
		
		Connection conn = DBUtils.getConnection();
		
		boolean check = false;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.IS_REGISTERED);
			stmt.setString(1, courseCode);
			stmt.setInt(2, studentId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				check = true;
			}
		}
		catch(Exception e)
		{
			logger.info(e.getClass());
			logger.info(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return check;
		
	}

	/**
	 * Method for fee payment and send notification to client. The transaction id for the session is generated by UUID.
	 * @param studentId
	 * @param mode - mode of payment
	 * @param amount - amount to paid by student
	 * @return
	 */
	@Override
	public Notification payFee(int studentId,ModeOfPayment mode,double amount) {
		
		
		Connection conn = null;
		UUID uuid=UUID.randomUUID();
		Notification notify = null;
	
		try
		{

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_PAYMENT);
			stmt.setInt(1, studentId);
			stmt.setString(2, mode.toString());
			stmt.setString(3,uuid.toString());
			stmt.setDouble(4, amount);
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_NOTIFICATION);
			stmt.setInt(1,studentId);
			stmt.setString(2, NotificationType.PAYMENT.toString());
			stmt.setString(3, uuid.toString());
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_NOTIFICATION);
			stmt.setString(1,uuid.toString());
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			notify = new Notification(rs.getInt("notificationId"),studentId,NotificationType.PAYMENT,rs.getString("referenceId"));
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return notify;
	}
	
	
	/**
	 * Method to retrieve fee for the selected courses from the database and calcualte total fee
	 * @param studentId
	 * @return
	 */
	
	@Override
	public double calculateFee(int studentId)
	{
		Connection conn = DBUtils.getConnection();
		double fee = 0;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.CALCULATE_FEES);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			fee = rs.getDouble(1);
		}
		catch(SQLException e)
		{
			logger.error(e.getErrorCode());
			logger.info(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return fee;
	}

	/**
	 * Method to view grade card of the student
	 * @param studentId
	 */
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) {
		
		Connection conn = DBUtils.getConnection();
		List<StudentGrade> grade_List = new ArrayList<>();
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_GRADE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				String grade = rs.getString("grade");
				StudentGrade obj = new StudentGrade(courseCode, courseName,grade);
				grade_List.add(obj);
			}
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return grade_List;
	}

	/**
	 * Method to get the list of courses available from course catalog 
	 * @param studentId
	 * @return list of courses
	 */
	@Override
	public List<Course> viewCourses(int studentId) {
		
		List<Course> availableCourseList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_AVAILABLE_COURSES);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				availableCourseList.add(new Course(rs.getString("courseCode"), rs.getString("courseName"),
						rs.getString("professorId"), rs.getInt("seats")));

			}
			

		} 
		catch (SQLException e) 
		{
			logger.error(e.getMessage());
		} 
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
				
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return availableCourseList;
		
	}

	/**
	 * Method to get the list of courses registered by the student
	 * @param studentId
	 * @return list of courses registered by student
	 */
	@Override
	public List<Course> viewRegisteredCourses(int studentId) {

		Connection conn = DBUtils.getConnection();
		List<Course> registeredCourseList = new ArrayList<>();
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_REGISTERED_COURSES);
			stmt.setInt(1, studentId);
			stmt.setBoolean(2, true);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseCode"), rs.getString("courseName"),
						rs.getString("professorId"), rs.getInt("seats")));

			}
		} 
		catch (SQLException e) 
		{
			logger.info(e.getMessage());

		} 
		catch (Exception e) 
		{
			logger.info(e.getMessage());
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.getErrorCode();
			}
		}
		
		return registeredCourseList;
	}

}
