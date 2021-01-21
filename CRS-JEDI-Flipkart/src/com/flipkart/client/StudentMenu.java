/**
 * 
 */
package com.flipkart.client;


import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.DummyDB;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;

public class StudentMenu {
	/*TODO: Student menu create
	1. Register
	2. Add course
	3. Drop course
	4. View course
	5. view grade card
	//calculate fee*/
	private static Logger logger = Logger.getLogger(StudentMenu.class);
	
	
	//TODO: Course Register-- View Courses, business class
	//TODO: display courses
	//TODO: input the courses
	
	
	
	public void create_menu(int sid)
	{
		Scanner sc = new Scanner(System.in);
		RegistrationInterface registrationInteface = new RegistrationOperation();

		while(true)
		{
			logger.info("*****************************");
			logger.info("1. Course Registration");
			logger.info("2. Add course");
			logger.info("3. Drop course");
			logger.info("4. View courses");
			logger.info("5. View Registered Courses");
			logger.info("6. View grade card");
			logger.info("7. Logout");
			logger.info("*****************************");
			
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1: {
					List<String> courseList = new ArrayList<>();
					registrationInteface.viewCourses(sid);
					logger.info("Enter 6 courseCodes: ");
					for(int i = 0; i < 6; i++) {
						courseList.add(sc.next());
					}
					registrationInteface.registerCourses(sid,courseList);
					logger.info("Registration Successful!");
				}
				break;
				
				case 2: {
					if(DummyDB.registeredCourses.get(sid).size()>=6) {
						logger.warn("You have aleady added 6 courses");
					}
					else {
						registrationInteface.viewCourses(sid);
						logger.info("Enter courseCode to be added: ");
						registrationInteface.addCourse(sc.next(), sid);
					}
				}
				break;
				
				case 3: {
					registrationInteface.viewRegisteredCourses(sid);
					logger.info("Enter courseCode to be dropped: ");
					registrationInteface.dropCourse(sc.next(), sid);
				}
				break;
				
				case 4:
					registrationInteface.viewCourses(sid);
					break;
					
				case 5:
					registrationInteface.viewRegisteredCourses(sid);
					break;
					
				case 6:
					logger.info("Your SPI is : "+ registrationInteface.generateReportCard(1,sid));
					break;
					
				case 7: {
					CRSApplication.loggedin  = false;
					return;
				}
				default:
					logger.warn("***** Wrong Choice *****");
			}
		}
	}
}
