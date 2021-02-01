/**
 * 
 */
package com.flipkart.client;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationOperation;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;


/**
 * 
 * @author JEDI-03
 *  The class displays the menu for student client
 *  
 */
public class StudentCRSMenu {
	private static Logger logger = Logger.getLogger(StudentCRSMenu.class);
	Scanner sc = new Scanner(System.in);
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	NotificationInterface notificationInterface=NotificationOperation.getInstance();
	private boolean is_registered;
	
	/**
	 * Method to generate Student Menu for course registration, addition, removal and fee payment 
	 * @param studentId student id 
	 */
	public void create_menu(int studentId)
	{

		is_registered = getRegistrationStatus(studentId);
		while (CRSApplication.loggedin) 
		{
			logger.info("*****************************");
			logger.info("**********Student Menu*********");
			logger.info("*****************************");
			logger.info("1. Course Registration");
			logger.info("2. Add Course");
			logger.info("3. Drop Course");
			logger.info("4. View Course");
			logger.info("5. View Registered Courses");
			logger.info("6. View grade card");
			logger.info("7. Make Payment");
			logger.info("8. Logout");
			logger.info("*****************************");

			int choice = sc.nextInt();

			switch (choice) {
				case 1: 
						registerCourses(studentId);
						break;
						
				case 2: 
						addCourse(studentId);
						break;

				case 3:
						
						dropCourse(studentId);
						break;

				case 4:
						viewCourse(studentId);
						break;

				case 5:
						viewRegisteredCourse(studentId);
						break;

				case 6:
						viewGradeCard(studentId);
						break;
						
				case 7:
						make_payment(studentId);
						break;
						
				case 8: 
						CRSApplication.loggedin = false;
						return;
						
				default:
						logger.warn("***** Wrong Choice *****");
			}
		}
	}
	

	/**
	 * Select course for registration
	 * @param studentId
	 */
	private void registerCourses(int studentId)
	{
			if(is_registered)
			{
				logger.info(" Registration is already completed");
				return;
			}
			
			int count = 0;
			while(count < 6)
			{
				try
				{
					List<Course> courseList=viewCourse(studentId);
					
					if(courseList==null)
						return;
					
					logger.info("Enter Course Code : " + (count+1));
					String courseCode = sc.next();
					
					if(registrationInterface.addCourse(courseCode,studentId,courseList))
					{
						logger.info("Course " + courseCode + " registered sucessfully.");
						count++;
					}
					else
					{
						logger.info(" You have already registered for Course : " + courseCode);
					}
				}	
				catch(CourseNotFoundException | CourseLimitExceedException | SeatNotAvailableException | SQLException e)
				{
					logger.info(e.getMessage());
				}
			}
			
		    logger.info("Registration Successful");	
		    is_registered = true;
		    
		    try 
		    {
				registrationInterface.setRegistrationStatus(studentId);
			} 
		    catch (SQLException e) 
		    {
				logger.info(e.getMessage());
			}
		
	}
	
	/**
	 * Add course for registration
	 * @param studentId
	 */
	private void addCourse(int studentId)	
	{
		if(is_registered)
		{
			List<Course> availableCourseList=viewCourse(studentId);
			
			if(availableCourseList==null)
				return;
	
			try
			{
				logger.info("Enter Course Code : " );
				String courseCode = sc.next();
				if(registrationInterface.addCourse(courseCode, studentId,availableCourseList))
				{
					logger.info(" You have successfully registered for Course : " + courseCode);
				}
				else
				{
					logger.info(" You have already registered for Course : " + courseCode);
				}
			}
			catch(CourseNotFoundException | CourseLimitExceedException | SeatNotAvailableException | SQLException e)
			{
				logger.info(e.getMessage());
			}
		}
		else 
		{
			logger.info("Please complete registration");
		}

		
	}
	
	/**
	 * Method to check if student is already registered
	 * @param studentId
	 * @return Registration Status
	 */
	private boolean getRegistrationStatus(int studentId)
	{
		try 
		{
			return registrationInterface.getRegistrationStatus(studentId);
		} 
		catch (SQLException e)
		{
			logger.info(e.getMessage());
		}
		return false;
	}
	
	/**
	 * Drop Course
	 * @param studentId
	 */
	private void dropCourse(int studentId)
	{
		if(is_registered)
		{
			List<Course> registeredCourseList=viewRegisteredCourse(studentId);
			
			if(registeredCourseList==null)
				return;
			
			logger.info("Enter the Course Code : ");
			String courseCode = sc.next();
			
			try
			{
				registrationInterface.dropCourse(courseCode, studentId,registeredCourseList);
				logger.info("You have successfully dropped Course : " + courseCode);
				
			}
			catch(CourseNotFoundException e)
			{
				logger.info("You have not registered for course : " + e.getCourseCode());
			} 
			catch (SQLException e) 
			{

                logger.info(e.getMessage());
			}
		}
		else
		{
			logger.info("Please complete registration");
		}

	}
	
	/**
	 * View all available Courses 
	 * @param studentId
	 * @return List of available Courses 
	 */
	private List<Course> viewCourse(int studentId)
	{
		List<Course> course_available=null;
		try 
		{
			course_available = registrationInterface.viewCourses(studentId);
		}
		catch (SQLException e) 
		{

            logger.info(e.getMessage());
		}
	
	
		if(course_available.isEmpty())
		{
			logger.info("NO COURSE AVAILABLE");
			return null;
		}
		

		logger.info(String.format("%-20s %-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR", "SEATS"));
		for(Course obj : course_available)
		{
			logger.info(String.format("%-20s %-20s %-20s %-20s",obj.getCourseCode(), obj.getCourseName(),obj.getInstructorId(), obj.getSeats()));
		}
		
		return course_available;

	}
	
	/**
	 * View Registered Courses
	 * @param studentId
	 * @return List of Registered Courses
	 */
	private List<Course> viewRegisteredCourse(int studentId)
	{
		List<Course> course_registered=null;
		try 
		{
			course_registered = registrationInterface.viewRegisteredCourses(studentId);
		} 
		catch (SQLException e) 
		{

            logger.info(e.getMessage());
		}
		
		if(course_registered.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return null;
		}
		
		logger.info(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		
		for(Course obj : course_registered)
		{
			 
			
			logger.info(String.format("%-20s %-20s %-20s ",obj.getCourseCode(), obj.getCourseName(),professorInterface.getProfessorById(obj.getInstructorId())));
		}
		
		return course_registered;
	}
	
	/**
	 * View grade card for particular student  
	 * @param studentId
	 */
	private void viewGradeCard(int studentId)
	{
		
		
		List<StudentGrade> grade_card=null;
		try 
		{
			grade_card = registrationInterface.viewGradeCard(studentId);
		} 
		catch (SQLException e) 
		{

            logger.info(e.getMessage());
		}
		
		logger.info(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "GRADE"));
		
		if(grade_card.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return;
		}
		
		for(StudentGrade obj : grade_card)
		{
			logger.info(String.format("%-20s %-20s %-20s",obj.getCourseCode(), obj.getCourseName(),obj.getGrade()));
		}
	}
	
	/**
	 * Make Payment for selected courses. Student is provided with an option to pay the fees and select the mode of payment.
	 * @param studentId
	 */
	private void make_payment(int studentId)
	{
		
		double fee =0.0;
		try
		{
			fee=registrationInterface.calculateFee(studentId);
		} 
		catch (SQLException e) 
		{

            logger.info(e.getMessage());
		}

		if(fee == 0.0)
		{
			logger.info("You have not  registered for any courses yet");
		}
		else
		{
			
			logger.info("Your total fee  = " + fee);
			logger.info("Want to continue Fee Payment(y/n)");
			String ch = sc.next();
			if(ch.equals("y"))
			{
				logger.info("Select Mode of Payment:");
				
				int index = 1;
				for(ModeOfPayment mode : ModeOfPayment.values())
				{
					logger.info(index + " " + mode);
					index = index + 1;
				}
				
				ModeOfPayment mode = ModeOfPayment.getModeofPayment(sc.nextInt());
				
				if(mode == null)
					logger.info("Invalid Input");
				else
				{
					try 
					{
						notificationInterface.sendNotification(NotificationType.PAYMENT, studentId, mode, fee);
					}
					catch (Exception e) 
					{

			            logger.info(e.getMessage());
					}
				}
					
			}
			
		}
		
	}
	
	
}


