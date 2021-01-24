/**
 * 
 */
package com.flipkart.client;

import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
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
		viewCourse(studentId);
		List<String> courselist = new ArrayList<>();
		for (int i = 0; i < 6; i++) 
		{
			logger.info("Course : " + i+1);
			courselist.add(sc.next());
		}
		
		registrationInterface.registerCourses(studentId, courselist);
	}
	

	void addCourse(int studentId)
	{
		viewCourse(studentId);
		String courseCode = sc.next();
		
		if(registrationInterface.addCourse(courseCode, studentId))
		{
			logger.info(" You have successfully registerd for Course :" + courseCode);
		}
		else
		{
			logger.info(" You cannot register for Course :" + courseCode);
		}
		
	}
	
	void dropCourse(int studentId)
	{
		viewRegisteredCourse(studentId);
		String courseCode = sc.next();
		
		if(registrationInterface.dropCourse(courseCode, studentId))
		{
			logger.info("You have successfully dropped Course :" + courseCode);
		}
		else
		{
			logger.info(" You cannot drop Course :" + courseCode);
		}
	}
	
	
	void viewCourse(int studentId)
	{
		List<Course> course_available = registrationInterface.viewCourses(studentId);
		logger.info(String.format("%20s %20s %20s %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR", "SEATS"));
		
		if(course_available.isEmpty())
		{
			logger.info("REGISTRATION CLOSED");
			return;
		}
		
		for(Course obj : course_available)
		{
			logger.info(String.format("%20s %20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),"INSTRUCTOR", obj.getSeats()));
		}

	}
	
	void viewRegisteredCourse(int studentId)
	{
		List<Course> course_registered = registrationInterface.viewRegisteredCourses(studentId); 
		logger.info(String.format("%20s %20s %20s %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		
		if(course_registered.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return;
		}
		
		for(Course obj : course_registered)
		{
			logger.info(String.format("%20s %20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),"INSTRUCTOR"));
		}
	}
	
	void viewGradeCard(int studentId)
	{
		List<StudentGrade> grade_card = registrationInterface.viewGradeCard(studentId);
		logger.info(String.format("%20s %20s %20s %20s","COURSE CODE", "COURSE NAME", "GRADE"));
		
		if(grade_card.isEmpty())
		{
			logger.info("You haven't registered for any course");
			return;
		}
		
		for(StudentGrade obj : grade_card)
		{
			logger.info(String.format("%20s %20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),"GRADE"));
		}
	}
	
	void make_payment(int studentId)
	{
		double fee = registrationInterface.calculateFee(studentId);
		
	}
	
	
}
