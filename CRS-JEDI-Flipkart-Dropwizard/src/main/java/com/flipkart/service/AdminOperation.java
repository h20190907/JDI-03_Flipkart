package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.validator.AdminValidator;

/**
 * 
 * @author JDI-03
 * Implementations of Admin Operations
 * 
 */
public class AdminOperation implements AdminInterface{

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	private static volatile AdminOperation instance = null;
	
	private AdminOperation()
	{
		
	}
	
	/**
	 * Method to make AdminOperation Singleton
	 * @return
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}
	

	AdminDaoInterface adminDaoOperation = AdminDaoOperation.getInstance();
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @param courseList : Courses available in the catalog
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void deleteCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException {
		
		if(!AdminValidator.isValidDropCourse(dropCourseCode, courseList)) {
			logger.error("courseCode: " + dropCourseCode + " not present in catalog!");
			throw new CourseNotFoundException(dropCourseCode);
		}
		
		if(!adminDaoOperation.deleteCourse(dropCourseCode)) {
			throw new CourseNotFoundException(dropCourseCode);
		}
		
	}

	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 * @param courseList : Courses available in catalog
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourse(Course newCourse, List<Course> courseList) throws CourseFoundException {
		
		if(!AdminValidator.isValidNewCourse(newCourse, courseList)) {
			logger.error("courseCode: " + newCourse.getCourseCode() + " already present in catalog!");
			throw new CourseFoundException(newCourse.getCourseCode());
		}


		if(!adminDaoOperation.addCourse(newCourse)) {
			throw new CourseFoundException(newCourse.getCourseCode());
		}
		
	}

	/**
	 * Method to view Students yet to be approved by Admin
	 * @return List of Students
	 */
	@Override
	public List<Student> viewPendingAdmissions() {
		
		return adminDaoOperation.viewPendingAdmissions();
		
	}
	
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException 
	 */
	@Override
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
		
		if(!AdminValidator.isValidUnapprovedStudent(studentId, studentList)) {
			logger.error("studentId: " + studentId + " is not-present OR already-approved!");
			throw new StudentNotFoundForApprovalException(studentId);
		}
		
		if(!adminDaoOperation.approveStudent(studentId)) {
			logger.error("studentId: " + studentId + " is not-present OR already-approved!");
			throw new StudentNotFoundForApprovalException(studentId);
		}
		
	}

	/**
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 * @throws UserNotAddedException 
	 */
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserNotAddedException {
		
		if(!adminDaoOperation.addUser(professor)) {
			throw new UserNotAddedException(professor.getUserId()); 
		}
		if(!adminDaoOperation.addProfessor(professor)) {
			throw new ProfessorNotAddedException(professor.getUserId());
		}
		
	}

	/**
	 * Method to assign Course to a Professor
	 * @param courseCode
	 * @throws CourseNotFoundException 
	 * @throws CourseNotAssignedToProfessorException 
	 */
	@Override
	public void assignCourse(String courseCode, String professorId) throws CourseNotAssignedToProfessorException  {
			
		if(!adminDaoOperation.assignCourse(courseCode, professorId)) {
			throw new CourseNotAssignedToProfessorException(courseCode, professorId);
		}
		
	}
	
	/**
	 * Method to get list of courses in catalog
	 * @param catalogId
	 * @return List of courses in catalog
	 */
	@Override
	public List<Course> viewCourses(int catalogId) {
		
		return adminDaoOperation.viewCourses(catalogId);
		
	}
}
