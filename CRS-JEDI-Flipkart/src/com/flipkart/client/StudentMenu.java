/**
 * 
 */
package com.flipkart.client;

import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;


/**
 *  The class displays the menu for student client
 */
public class StudentMenu {
	private static Logger logger = Logger.getLogger(StudentMenu.class);
	
	/**
	 * Menu for registration, addition, removal and fee payment 
	 * @param sid  student id 
	 */
	public void create_menu(int sid)
	{
		Scanner sc = new Scanner(System.in);
		RegistrationInterface registrationInterface = new RegistrationOperation();

		while (true) {
			logger.info("*****************************");
			logger.info("1. Course Registration");
			logger.info("2. Add course");
			logger.info("3. Drop course");
			logger.info("4. View courses");
			logger.info("5. View Registered Courses");
			logger.info("6. View grade card");
			logger.info("7. Make Payment");
			logger.info("8. Logout");
			logger.info("*****************************");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				List<String> courseList = new ArrayList<>();
				registrationInterface.viewCourses(sid);
				logger.info("Enter 6 courseCodes: ");
				for (int i = 0; i < 6; i++) {
					courseList.add(sc.next());
				}
				registrationInterface.registerCourses(sid, courseList);
				logger.info("Registration Successful!");
			}
				break;

			case 2: {
//				if (DummyDB.registeredCourses.get(sid).size() >= 6) {
//					logger.warn("You have aleady added 6 courses");
//				} else {
//					registrationInterface.viewCourses(sid);
//					logger.info("Enter courseCode to be added: ");
//					registrationInterface.addCourse(sc.next(), sid);
//				}
			}
				break;

			case 3: {
				registrationInterface.viewRegisteredCourses(sid);
				logger.info("Enter courseCode to be dropped: ");
				try {

					registrationInterface.dropCourse(sc.next(), sid);
				} catch (CourseNotFoundException e) {
					logger.error("Course "+e.getCourseCode() + " not found ");
				}
			}
				break;

			case 4:
				registrationInterface.viewCourses(sid);
				break;

			case 5:
				registrationInterface.viewRegisteredCourses(sid);
				break;

			case 6:
				registrationInterface.viewGradeCard(sid);
				break;

			case 7:{
				registrationInterface.payFees(sid);	
			} 
			case 8: {
				CRSApplication.loggedin = false;
				return;
			}
			default:
				logger.warn("***** Wrong Choice *****");
			}
		}
	}
}
