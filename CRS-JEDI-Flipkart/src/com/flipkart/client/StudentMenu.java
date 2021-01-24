/**
 * 
 */
package com.flipkart.client;

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
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;


/**
 *  The class displays the menu for student client
 */
public class StudentMenu {
	private static Logger logger = Logger.getLogger(StudentMenu.class);
	
	
	Scanner sc = new Scanner(System.in);
	RegistrationInterface registrationInterface =RegistrationOperation.getInstance();
	
	
	/**
	 * Student Menu for course registration, addition, removal and fee payment 
	 * @param sid  student id 
	 */
	public void create_menu(int studentId)
	{

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
	

	void registerCourses(int studentId)
	{
	
		if(!viewCourse(studentId))
			return;
		List<String> courselist = new ArrayList<>();
		for (int i = 0; i < 6; i++) 
		{
			logger.info("Select Course : "  + (i+1));
			courselist.add(sc.next());
		}
		
		try
		{
			registrationInterface.registerCourses(studentId, courselist);
			logger.info("Registration Successful");
		}
		catch(CourseNotFoundException | SeatNotAvailableException  | CourseLimitExceedException e)
		{
			logger.info("Registration Unsuccessful");
		}
		
		
		
	}
	

	void addCourse(int studentId)	
	{
		if(!viewCourse(studentId))
			return;

		logger.info("Enter the Course Code : ");
		
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
		catch(CourseNotFoundException e)
		{
			logger.info(e.getCourseCode() + " course not found");
		}
		catch(SeatNotAvailableException e)
		{
			logger.info( "Seats are not available in : " + e.getCourseCode());
		}
		catch(CourseLimitExceedException e)
		{
			logger.info("You have already registered for " +e.getNum() + " courses");
		}
		
	}
	
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
			logger.info(String.format("%20s %20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),"INSTRUCTOR", obj.getSeats()));
		}
		
		return true;

	}
	
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
			 
			
			logger.info(String.format("%20s %20s %20s ",obj.getCourseCode(), obj.getCourseName(),"INSTRUCTOR"));
		}
		
		return true;
	}
	
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
	
	void make_payment(int studentId)
	{
		double fee = registrationInterface.calculateFee(studentId);

		if(fee == 0.0)
		{
			logger.info("You have not for any registered courses yet");
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
