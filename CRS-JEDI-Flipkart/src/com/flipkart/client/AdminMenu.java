/**
 * 
 */
package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

/**
 * @author Anurag Behera, Rag Patel
 *
 */
public class AdminMenu {

	private static Logger logger = Logger.getLogger(AdminMenu.class);
	
	/**
	 * Method to Create Admin Menu
	 */
	public void createMenu() {
		
		AdminInterface adminOperation = new AdminOperation();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			logger.info("*****************************");
			logger.info("1. Add Course");
			logger.info("2. Delete Course");
			logger.info("3. Approve Students");
			logger.info("4. View Pending Admission");
			logger.info("5. Add Professor");
			logger.info("6. Assign Courses To Professor");
			logger.info("7. Logout");
			logger.info("*****************************");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1: {
				
				logger.info("Enter Course Code:\n");
				String courseCode = scanner.nextLine();
				
				logger.info("Enter Course Name:\n");
				String courseName = scanner.nextLine();
				
				logger.info("Enter Instructor Name:\n");
				String instructorName = scanner.nextLine();
				
				adminOperation.addCourse(courseCode, courseName, instructorName);						
				
				break;
			}
			
			case 2:{
				
				logger.info("Enter Course Code:\n");
				String courseCode = scanner.nextLine();
				
				adminOperation.deleteCourse(courseCode);
				
				break;
				
			}
			
			case 3:{
				
				logger.info("Enter Student's User ID:\n");
				String studentUserIdApproval = scanner.nextLine();
				
				adminOperation.approveStudent(studentUserIdApproval);
				
				break;
			}
			
			case 4:{
				
				List<Student> pendingStudentsList= adminOperation.viewPendingAdmissions();
				
				for(Student student : pendingStudentsList) {
					logger.info(student.getStudentId() + "\n");
				}
				
				break;
			}
			
			case 5:{
				
				logger.info("Enter Professor Name:\n");
				String professorName = scanner.nextLine();
				
				logger.info("Enter Role:\n");
				String role = scanner.nextLine();
				
				logger.info("Enter User Id:\n");
				Integer userId = scanner.nextInt();
				
				logger.info("Enter Password:\n");
				String password = scanner.nextLine();
				
				logger.info("Enter Department:\n");
				String department = scanner.nextLine();
				
				adminOperation.addProfessor(professorName, role, userId, password, department);
				
				break;
				
			}
			
			case 6:{
				
				logger.info("Enter Course Code:\n");
				String courseCode = scanner.nextLine();
				
				logger.info("Enter Professor's User Id:\n");
				int userId = scanner.nextInt();
				
				adminOperation.assignCourse(courseCode, userId);
			
				break;
			}
			
			case 7:{
				
				CRSApplication.loggedin  = false;
				return;
			}
			default:
				logger.warn("***** Wrong Choice *****");
			}
		}
		
	}

}
