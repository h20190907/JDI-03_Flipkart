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
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;


/**
 *  The class displays the menu for student client
 */
public class StudentCRSMenu {
	private static Logger logger = Logger.getLogger(StudentCRSMenu.class);
	Scanner sc = new Scanner(System.in);
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	private boolean is_registered;
	/**
	 * Student Menu for course registration, addition, removal and fee payment 
	 * @param sid  student id 
	 */
	public void create_menu(int studentId)
	{

		is_registered = getRegistrationStatus(studentId);
		while (CRSApplication.loggedin) 
		{
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
						if(is_registered)
							addCourse(studentId);
						else
							logger.info("Please complete registration");
						break;

				case 3:
						if(is_registered)
							dropCourse(studentId);
						else
							logger.info("Please complete registration");
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
	 * Select course 
	 * @param studentId
	 */
	public void registerCourses(int studentId)
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
					logger.info("Enter Course Code : " + (count+1));
					String courseCode = sc.next();
					if(registrationInterface.addCourse(courseCode,studentId))
					{
						logger.info("Course " + courseCode + " registered sucessfully.");
						count++;
					}
				}	
				catch(CourseNotFoundException | CourseLimitExceedException | SeatNotAvailableException | SQLException e)
				{
					logger.info(e.getMessage());
				}
			}
			
		    logger.info("Registration Successful");	
		    is_registered = true;
		
	}
	
	/**
	 * Add course
	 * @param studentId
	 */
	void addCourse(int studentId)	
	{
		if(!viewCourse(studentId))
			return;

		try
		{
			String courseCode = sc.next();
			if(registrationInterface.addCourse(courseCode, studentId))
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
	
	boolean getRegistrationStatus(int studentId)
	{
		
	}
	
	/**
	 * Drop Course
	 * @param studentId
	 */
	void dropCourse(int studentId)
	{
		
		if(!viewRegisteredCourse(studentId))
			return;
		
		logger.info("Enter the Course Code : ");
		String courseCode = sc.next();
		
		try
		{
			registrationInterface.dropCourse(courseCode, studentId);
			logger.info("You have successfully dropped Course : " + courseCode);
			
		}
		catch(CourseNotFoundException e)
		{
			logger.info("You have not registered for course : " + e.getCourseCode());
		}
	}
	
	/**
	 * View Course
	 * @param studentId
	 * @return true if any course is available, false otherwise
	 */
	boolean viewCourse(int studentId)
	{
		List<Course> course_available = registrationInterface.viewCourses(studentId);
		
		if(course_available.isEmpty())
		{
			logger.info("NO COURSE AVAILABLE");
			return false;
		}
		

		logger.info(String.format("%20s %20s %20s %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR", "SEATS"));
		for(Course obj : course_available)
		{
			logger.info(String.format("%20s %20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getInstructorId(), obj.getSeats()));
		}
		
		return true;

	}
	
	/**
	 * View Registered Course
	 * @param studentId
	 * @return true if any course is registered, false otherwise
	 */
	boolean viewRegisteredCourse(int studentId)
	{
		List<Course> course_registered = registrationInterface.viewRegisteredCourses(studentId);
		
		if(course_registered.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return false;
		}
		
		logger.info(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		
		for(Course obj : course_registered)
		{
			 
			
			logger.info(String.format("%20s %20s %20s ",obj.getCourseCode(), obj.getCourseName(),professorInterface.getProfessorById(obj.getInstructorId())));
		}
		
		return true;
	}
	
	/**
	 * View grade card for particular student  
	 * @param studentId
	 */
	void viewGradeCard(int studentId)
	{
		
		
		List<StudentGrade> grade_card = registrationInterface.viewGradeCard(studentId);
		logger.info(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "GRADE"));
		
		if(grade_card.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return;
		}
		
		for(StudentGrade obj : grade_card)
		{
			logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getGrade()));
		}
	}
	
	/**
	 * Make Payment for selected courses. Student is provided with an option to pay the fees and select the mode of payment.
	 * @param studentId
	 */
	
	void make_payment(int studentId)
	{
		
		double fee = registrationInterface.calculateFee(studentId);

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
					Notification notify = registrationInterface.payFee(studentId, mode,fee);
					logger.info("Your Payment is successful");
					logger.info("Your transaction id : " + notify.getReferenceId());
				}
					
			}
			
		}
		
	}
	
	
}
