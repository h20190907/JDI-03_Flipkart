package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.utils.DBUtils;

/**
 * @author JDI-03
 * Dao Class Operations for Admin
 * 
 */
public class AdminDaoOperation implements AdminDaoInterface{

	private static volatile AdminDaoOperation instance = null;
	
	/**
	 * Default Constructor
	 */
	private AdminDaoOperation()
	{
		
	}
	
	/**
	 * Method to make AdminDaoOperation Singleton
	 * @return
	 */
	public static AdminDaoOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminDaoOperation.class){
				instance = new AdminDaoOperation();
			}
		}
		return instance;
	}
	
	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
	Connection connection = DBUtils.getConnection();
	
	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @throws CourseNotFoundException
	 */
	@Override
	public void deleteCourse(String courseCode) throws CourseNotFoundException{
		try {
			String sql = SQLQueriesConstants.DELETE_COURSE_QUERY;
			//statement=null;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,courseCode);
			int row = statement.executeUpdate();
			
			if(row == 0) {
				logger.error(courseCode + " not in catalog!");
				throw new CourseNotFoundException(courseCode);
			}
			logger.info(row + " entries deleted");
			logger.info("Course with Course ID : " + courseCode + " deleted");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourse(Course course) throws CourseFoundException{
		try {
			
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			
			statement.setInt(3, 1);
			int row = statement.executeUpdate();
			
			logger.info(row + " course added");
			if(row == 0) {
				logger.error("courseCode: " + course.getCourseCode() + "not added to catalogue!");
				throw new CourseFoundException(course.getCourseCode());
			}
			logger.info("Course with Course ID : " + course.getCourseCode() + " is added to Catalogue"); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return
	 */
	@Override
	public List<Student> viewPendingAdmissions() {
		
		List<Student> userList = new ArrayList<Student>();
		
		try {
			
			String sql = SQLQueriesConstants.VIEW_PENDING_ADMISSION_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Student user = new Student();
				user.setUserId(resultSet.getString(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setRole(Role.stringToName(resultSet.getString(4)));
				user.setGender(Gender.stringToGender( resultSet.getString(5)));
				user.setAddress(resultSet.getString(6));
				user.setCountry(resultSet.getString(7));
				user.setStudentId(resultSet.getInt(8));
				userList.add(user);
			}
			
			logger.info(userList.size() + " students have pending approval");
			
			return userList;
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	@Override
	public void approveStudent(int studentId) throws StudentNotFoundException {
		try {
			String sql = SQLQueriesConstants.APPROVE_STUDENT_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1,studentId);
			int row = statement.executeUpdate();
			
			if(row == 0) {
				logger.error("Student with Student Id : " + studentId + " not found");
				throw new StudentNotFoundException(studentId);
			}
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 */
	@Override
	public void addUser(User user) throws UserNotAddedException{
		
		try {
			
			String sql = SQLQueriesConstants.ADD_USER_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUserId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole().toString());
			statement.setString(5, user.getGender().toString());
			statement.setString(6, user.getAddress());
			statement.setString(7, user.getCountry());
			int row = statement.executeUpdate();
			if(row == 0) {
				logger.error("userId: " + user.getUserId() + " not added!");
				throw new UserNotAddedException(user.getUserId()); 
			}
			logger.info(row + " user added");
			logger.info("User with User Id : " + user.getUserId() + " Added"); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
	}

	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 */
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException{
		try {
			this.addUser(professor);
		}catch (UserNotAddedException e) {
			logger.error(e.getMessage());
			throw new ProfessorNotAddedException(professor.getUserId());
		}
		
		try {
			
			
			String sql = SQLQueriesConstants.ADD_PROFESSOR_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getDesignation());
			int row = statement.executeUpdate();

			logger.info(row + " Professor added");
			if(row == 0) {
				logger.error("professorId: " + professor.getUserId() + " not added!");
				throw new ProfessorNotAddedException(professor.getUserId());
			}
			logger.info("Professor with Professor Id : " + professor.getUserId() + " Added"); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}	
	}
	
	/**
	 * Assign courses to Professor using SQL commands
	 * @param courseCode
	 * @param professorId
	 * @throws CourseNotFoundException
	 */
	@Override
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException{
		try {
			String sql = SQLQueriesConstants.ASSIGN_COURSE_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,professorId);
			statement.setString(2,courseCode);
			int row = statement.executeUpdate();
			
			logger.info(row + " Updated");
			if(row == 0) {
				logger.error(courseCode + " not found");
				throw new CourseNotFoundException(courseCode);
			}
			logger.info("Course : " + courseCode + " is assigned to " + professorId);
		
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * View courses in the catalog
	 * @return List of courses in catalog
	 * @return List of courses in the catalog
	 */
	public List<Course> viewCourses(int catalogId) {
		List<Course> courseList = new ArrayList<>();
		try {
			
			String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, catalogId);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseCode(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				course.setInstructorId(resultSet.getString(3));
				courseList.add(course);
			}
			
			logger.info(courseList.size() + " courses in catalogId: " + catalogId);
			
			return courseList;
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		return null; 
	}
}
