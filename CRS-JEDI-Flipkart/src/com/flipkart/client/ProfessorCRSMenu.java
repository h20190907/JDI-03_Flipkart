package com.flipkart.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.validator.ProfessorValidator;

/**
 * 
 * @author JEDI-03
 * Class that display Professor Client Menu
 * 
 */
public class ProfessorCRSMenu {

	
	private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();
	
	/**
	 * Method to create Professor menu
	 * @param profId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	public void createMenu(String profId)
	{
		//Display the options available for the PRofessor
		Scanner sc=new Scanner(System.in);
		
		int input;
		while(CRSApplication.loggedin)
		{
			logger.info("*****************************");
			logger.info("**********Professor Menu*********");
			logger.info("*****************************");
			logger.info("1. View Courses");
			logger.info("2. View Enrolled Students");
			logger.info("3. Add grade");
			logger.info("4. Logout");
			logger.info("*****************************");
			
			//input user
			input=sc.nextInt();
			switch(input)
			{
				case 1:
					//view all the courses taught by the professor
					getCourses(profId);
					break;
				case 2:
					//view all the enrolled students for the course
					viewEnrolledStudents(profId);
					break;
					
				case 3:
					//add grade for a student
					addGrade(profId);
					break;
				case 4:
					//logout from the system
					CRSApplication.loggedin=false;
					return;
				default:
					logger.warn("***** Wrong Choice *****");
			}
		}
		
		
	}
	
	/**
	 * Method to view enrolled Students in courses
	 * @param profId
	 */
	public void viewEnrolledStudents(String profId)
	{
		List<Course> coursesEnrolled=professorInterface.getCourses(profId);
		logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE CODE","Students  enrolled" ));
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for(EnrolledStudent obj: enrolledStudents)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}

	/**
	 * Method to get list of all Courses Professor has to teach
	 * @param profId
	 */
	public void getCourses(String profId)
	{
		try
		{
			List<Course> coursesEnrolled=professorInterface.getCourses(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","No. of Students  enrolled" ));
			for(Course obj: coursesEnrolled)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),10- obj.getSeats()));
			}		
		}
		catch(Exception ex)
		{
			logger.error("Something went wrong!"+ex.getMessage());
		}
	}
	
	/**
	 * Method to help Professor grade a student
	 * @param profId
	 */
	public void addGrade(String profId)
	{	
		Scanner sc=new Scanner(System.in);
		
		int studentId;
		String courseCode,grade;
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for(EnrolledStudent obj: enrolledStudents)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(profId);
			logger.info("----------------Add Grade--------------");
			logger.info("Enter student id");
			studentId=sc.nextInt();
			logger.info("Enter course code");
			courseCode=sc.next();
			logger.info("Enter grade");
			grade=sc.next();
			if(ProfessorValidator.isValidStudent(enrolledStudents, studentId) && ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))
			{
				professorInterface.addGrade(studentId, courseCode, grade);
				logger.info("Grade added successfully for "+studentId);
			}
			else
			{
				logger.info("Invalid data entered, try again!");
			}
		}
		catch(GradeNotAddedException ex)
		{
			logger.error("Grade cannot be added for"+ex.getStudentId());
			
		}
		catch(SQLException ex)
		{
			logger.error("Grade not added, SQL exception occured "+ex.getMessage());
		}
	
	}
}
