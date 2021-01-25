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
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
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
		
		while(CRSApplication.loggedin) {
			logger.info("*****************************");
			logger.info("**********Admin-Menu*********");
			logger.info("*****************************");
			logger.info("1. View course in catalog");
			logger.info("2. Add Course to catalog");
			logger.info("3. Delete Course from catalog");
			logger.info("4. Approve Students");
			logger.info("5. View Pending Admission");
			logger.info("6. Add Professor");
			logger.info("7. Assign Courses To Professor");
			logger.info("8. Logout");
			logger.info("*****************************");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				viewCoursesInCatalogue();
				break;
			case 2:
				viewCoursesInCatalogue();
				addCourseToCatalogue();
				break;
				
			case 3:
				viewCoursesInCatalogue();
				deleteCourse();
				break;
				
			case 4:
				approveStudent();
				break;
			
			case 5:
				viewPendingAdmissions();
				break;
			
			case 6:
				addProfessor();
				break;
			
			case 7:
				assignCourseToProfessor();
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
		catch(CourseNotFoundException e) {
			
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
		
		try {
			adminOperation.addProfessor(professor);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		}

	}

	/**
	 * Method to view Students who are yet to be approved
	 */
	private int viewPendingAdmissions() {
		
		List<Student> pendingStudentsList= adminOperation.viewPendingAdmissions();
		logger.info(String.format("%20s %20s %20s %7s", "UserId", "StudentId", "Name", "Gender"));
		for(Student student : pendingStudentsList) {
			logger.info(String.format("%20s %20d %20s %7s", student.getUserId(), student.getStudentId(), student.getName(), student.getRole().toString()));
		}
		return pendingStudentsList.size();
	}

	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		if(viewPendingAdmissions() == 0) {
			return;
		}
		
		logger.info("Enter Student's User ID:");
		int studentUserIdApproval = scanner.nextInt();
		
		try {
			adminOperation.approveStudent(studentUserIdApproval);
		} catch (StudentNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Method to delete Course from catalogue
	 * @throws CourseNotFoundException 
	 */
	private void deleteCourse() {

		logger.info("Enter Course Code:");
		String courseCode = scanner.next();
		
		try {
			adminOperation.deleteCourse(courseCode);
		} catch (CourseNotFoundException e) {
			logger.error(e.getMessage());
		}
		
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
	/**
	 * Method to display courses in catalogue
	 */
	private void viewCoursesInCatalogue() {
		List<Course> courseList = adminOperation.viewCourses(1);
		if(courseList.size() == 0) {
			logger.info("No course in the catalogue!");
			return;
		}
		logger.info(String.format("%20s %20s %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		for(Course course : courseList) {
			logger.info(String.format("%20s %20s %20s", course.getCourseCode(), course.getCourseName(), course.getInstructorId()));
		}
	}
}