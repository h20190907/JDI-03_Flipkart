package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;

public class ProfessorCRSMenu {

	/**
	 * 
	 * @param profId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();
	public void createMenu(String profId)
	{
		//Display the options available for the PRofessor
		Scanner sc=new Scanner(System.in);
		
		int input;
		while(CRSApplication.loggedin)
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
					getCourses(profId);
					break;
				case 2:
					//view all the enrolled students for the course
					String courseCode=sc.next();
					professorInterface.viewEnrolledStudents(profId, courseCode);
					break;
					
				case 3:
					//add grade for a student
					addGrade();
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


	
public void getCourses(String profId)
{
	try
	{
		List<Course> coursesEnrolled=professorInterface.getCourses(profId);
		logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE CODE","Students  enrolled" ));
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

public void addGrade()
{
	Scanner sc=new Scanner(System.in);
	int studentId;
	String courseCode,grade;
	try
	{
		logger.info("----------------Add Grade--------------");
		logger.info("Enter student id");
		studentId=sc.nextInt();
		logger.info("Enter course code");
		courseCode=sc.next();
		logger.info("Enter grade");
		grade=sc.next();
		professorInterface.addGrade(studentId, courseCode, grade);
		logger.info("Grade added successfully for "+studentId);
		
	}
	catch(GradeNotAddedException ex)
	{
		logger.error("Grade cannot be added for"+ex.getStudentId());
		
	}

}
}
