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
import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DBUtils;

/**
 * 
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface{

	private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);
	private static Connection conn = DBUtils.getConnection();
	private PreparedStatement stmt = null;
	
	/**
	 * 
	 * @param studentId
	 * @param courselist
	 * @return
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean registerCourses(int studentId, List<String> courselist) {
		
		boolean check = true;
		try
		{
			for (String courseCode : courselist)
			{
				check  = check & addCourse(courseCode, studentId);
			}
			
		}
		catch(CourseNotFoundException e)
		{
			logger.info(e.getCourseCode() + " not found");
		}
		
		return check;
	}

	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws CourseNotFoundException
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId) throws CourseNotFoundException {
		
		if (numOfRegisteredCourses(studentId) > 6)
		{	
			logger.info("You have already registered for 6 courses");
			return false;
		}
		else if (isRegistered(courseCode, studentId)) 
		{
			logger.info("You have already registered for the course : " + courseCode);
			return false;

		} 
		else if (!seatAvailable(courseCode)) 
		{
			logger.info("You can't add course because seat is not available : "+courseCode);
			return false;
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
				logger.info("Course Not Found");
				throw new CourseNotFoundException(courseCode);

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
		catch (SQLException se) {

			logger.error(se.getMessage());

		} catch (Exception e) {

			logger.error(e.getMessage());
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
		
		return true;
		

	}


	/**
	 * Drop Course selected by student
	 * @param courseCode : code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
	
		
		if(!isRegistered(courseCode,studentId))
		{
			logger.info("You haven't registered for the course ");
			return false;
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
				logger.info("Course " + courseCode + " is successfully dropped.");
				
				return true;
			}
			catch(Exception e)
			{
				logger.info("Exception found" + e.getMessage());
			}
			
		}
		
		return false;
		
	}
	
	public boolean isRegistered(String courseCode, int studentId){
		
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
		
		logger.info(check);
		return check;
		
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public Notification payFee(int studentId) {
		return null;
	}
	
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	
	@Override
	public double calculateFee(int studentId)
	{
		double fee = 0;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.CALCULATE_FEES);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			fee = rs.getDouble(1);
			logger.info(fee);
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
		
		return fee;
	}

	@Override
	public List<StudentGrade> viewGradeCard(int studentId) {
		
		List<StudentGrade> grade_List = new ArrayList();
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_GRADE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				StudentGrade obj = new StudentGrade(courseCode, courseName);
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
		return grade_List;
	}

	@Override
	public List<Course> viewCourses(int studentId) {
		
		List<Course> availableCourseList = new ArrayList<>();
		
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_AVAILABLE_COURSES);
			stmt.setInt(1, studentId);
			System.out.println("student: " + studentId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				availableCourseList.add(new Course(rs.getString("courseCode"), rs.getString("courseName"),
						rs.getString("professorId"), rs.getInt("seats"), rs.getBoolean("isOffered")));

			}
			
			
			for(Course course:availableCourseList)
				System.out.println(course.getCourseCode()+" "+course.getCourseName()+" "+course.getSeats());

		} 
		catch (SQLException e) 
		{
			logger.error(e.getMessage());
		} 
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}
		
		return availableCourseList;
		
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) {

		List<Course> registeredCourseList = new ArrayList<>();
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstant.VIEW_REGISTERED_COURSES);
			stmt.setInt(1, studentId);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseCode"), rs.getString("courseName"),
						rs.getString("professorId"), rs.getInt("seats"), rs.getBoolean("isOffered")));

			}
			
			for(Course course:registeredCourseList)
				System.out.println(course.getCourseCode()+" "+course.getCourseName()+" "+course.getSeats());

		} 
		catch (SQLException e) 
		{
			logger.info(e.getMessage());

		} 
		catch (Exception e) 
		{
			logger.info(e.getMessage());
		}
		
		return registeredCourseList;
	}

}
