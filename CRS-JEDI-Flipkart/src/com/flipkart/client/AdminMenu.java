package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

/**
 * 
 * @author Anurag Behera, Rag Patel
 * Class that Display Admin Client Menu
 * 
 */
public class AdminMenu {

	private static Logger logger = Logger.getLogger(AdminMenu.class);
	
	AdminInterface adminOperation =AdminOperation.getInstance();
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Method to Create Admin Menu
	 * 
	 */
	public void createMenu(){
		
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
			case 1: 
				addCourseToCatalogue();
				break;
				
			case 2:
				deleteCourse();
				break;
				
			case 3:
				approveStudent();
				break;
			
			case 4:
				viewPendingAdmissions();
				break;
			
			case 5:
				addProfessor();
				break;
			
			case 6:
				assignCourseToProfessor();
				break;
			
			case 7:
				CRSApplication.loggedin  = false;
				return;

			default:
				logger.warn("***** Wrong Choice *****");
			}
		}
	}
	
	/**
	 * Method to assign Course to a Professor
	 */
	private void assignCourseToProfessor() {
		
		logger.info("Enter Course Code:");
		String courseCode = scanner.next();
		
		logger.info("Enter Professor's User Id:");
		String userId = scanner.next();
		
		try {
			
		adminOperation.assignCourse(courseCode, userId);
		
		}
		catch(Exception e) {
			
			logger.error(e.getMessage());
		}
		
	}

	/**
	 * Method to add Professor to DB
	 */
	private void addProfessor() {
		
		Professor professor = new Professor();
		
		logger.info("Enter Professor Name:");
		String professorName = scanner.next();
		professor.setName(professorName);
		
		logger.info("Enter Department:");
		String department = scanner.next();
		professor.setDepartment(department);
		
		logger.info("Enter Designation:");
		String designation = scanner.next();
		professor.setDesignation(designation);
		
		logger.info("Enter User Id:");
		String userId = scanner.next();
		professor.setUserId(userId);
		
		logger.info("Enter Password:");
		String password = scanner.next();
		professor.setPassword(password);
		
		logger.info("Enter Gender: \t 1: Male \t 2.Female \t 3.Other ");
		int gender = scanner.nextInt();
		professor.setGender(Gender.getName(gender));
		
		logger.info("Enter Address:");
		String address = scanner.next();
		professor.setAddress(address);
		
		logger.info("Enter Country:");
		String country = scanner.next();
		professor.setCountry(country);
		
		professor.setRole(Role.stringToName("Professor"));
		
		adminOperation.addProfessor(professor);
		
		
	}

	/**
	 * Method to view Students who are yet to be approved
	 */
	private void viewPendingAdmissions() {
		
		List<Student> pendingStudentsList= adminOperation.viewPendingAdmissions();
		
		for(Student student : pendingStudentsList) {
			logger.info(student.getStudentId());
		}
		
		
	}

	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		viewPendingAdmissions();
		
		logger.info("Enter Student's User ID:");
		int studentUserIdApproval = scanner.nextInt();
		
		adminOperation.approveStudent(studentUserIdApproval);
		
		
	}

	/**
	 * Method to delete Course from catalogue
	 */
	private void deleteCourse() {

		logger.info("Enter Course Code:");
		String courseCode = scanner.next();
		
		adminOperation.deleteCourse(courseCode);
		
	}

	/**
	 * Method to add Course to catalogue
	 */
	private void addCourseToCatalogue() {
		logger.info("Enter Course Code:");
		String courseCode = scanner.next();
		
		logger.info("Enter Course Name:");
		String courseName = scanner.next();
		
		Course course = new Course(courseCode, courseName, null, 10);
		
		adminOperation.addCourse(course);						

	}

	//TODO Remove the main. It's just for testing
	public static void main(String args[]) {
		AdminMenu adminMenu = new AdminMenu();
		adminMenu.createMenu();
	}

}