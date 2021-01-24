package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;

public class ProfessorMenu {

	/**
	 * 
	 * @param profId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	private static Logger logger = Logger.getLogger(StudentMenu.class);
	public void createMenu(int profId)
	{
		//Display the options available for the PRofessor
		Scanner sc=new Scanner(System.in);
		ProfessorInterface professorInterface=ProfessorOperation.getInstance();
		int input;
		while(true)
		{
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
					professorInterface.getCourses(profId);
					break;
				case 2:
					//view all the enrolled students for the course
					String courseCode=sc.next();
					professorInterface.viewEnrolledStudents(profId, courseCode);
					break;
					
				case 3:
					//add grade for a student
					String studentId=sc.next();
					String profCourseCode=sc.next();
					professorInterface.addGrade(profId, studentId, profCourseCode, input);
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

}
