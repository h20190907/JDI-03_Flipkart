package com.flipkart.client;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.service.UserOperation;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;

/**
 * This class is used as the main entry point of the application
 * Main menu to login, register are displayed
 * @author dilpreetkaur 
 *
 */
public class CRSApplication {

	private static Logger logger = Logger.getLogger(CRSApplication.class);
	static boolean loggedin = false;
	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;	
		//create the main menu
		createMainMenu();
		userInput=sc.nextInt();
		try
		{
			
		//until user do not exit the application
		while(userInput!=4)
		{
			switch(userInput)
			{	
				case 1:
					//login
					crsApplication.loginUser();
					break;
				case 2:
					//student registration
					crsApplication.registerStudent();
					break;	
				case 3:
					crsApplication.updatePassword();
					break;
				default:
					logger.info("Invalid Input");
			}
			createMainMenu();
			userInput=sc.nextInt();
		}
		}
		catch(Exception ex)
		{
			logger.error("Error occured "+ex);
		}
		finally
		{
			sc.close();
		}
	}
	
	public static void createMainMenu()
	{
		logger.info("----------Welcome to Course Management System---------");
		logger.info("1. Login");
		logger.info("2. Student Registration");
		logger.info("3. Update password");
		logger.info("4. Exit");
		logger.info("Enter user input");
	}
	
	public void loginUser()
	{
		//multiple exceptions are possible
		//invalid credential exception
		//user not found exception
		//user not approved exception
		Scanner sc=new Scanner(System.in);

		String userId,password;
		try
		{
			logger.info("-----------------Login------------------");
			logger.info("Email:");
			userId=sc.next();
			logger.info("Password:");
			password=sc.next();
			loggedin = userInterface.verifyCredentials(userId, password);
			//2 cases
			//true->role->student->approved
			if(loggedin)
			{
				String role=userInterface.getRole(userId);
				Role userRole=Role.stringToName(role);
				switch(userRole)
				{
				case ADMIN:
					AdminMenu adminMenu=new AdminMenu();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					ProfessorMenu professorMenu=new ProfessorMenu();
					
					break;
				case STUDENT:
					
					int studentId=studentInterface.getStudentId(userId);
					boolean isApproved=studentInterface.isApproved(studentId);
					if(isApproved)
					{
						StudentMenu studentMenu=new StudentMenu();
						studentMenu.create_menu(studentId);
						
					}
					else
					{
						logger.warn("Failed to login, you have not been approved by the administration!");
						loggedin=false;
					}
					break;
				}
				
				
			}
			else
			{
				logger.error("Invalid Credentials!");
			}
			
		}
		catch(UserNotFoundException ex)
		{
			logger.error(ex.getUserId()+" not registered!");
		}	
	}
	
	public void registerStudent()
	{
		Scanner sc=new Scanner(System.in);

		String userId,name,password,address,country,branchName;
		Gender gender;
		int genderV, batch;
		try
		{
			//input all the student details
			logger.info("---------------Student Registration-------------");
			logger.info("Name:");
			name=sc.nextLine();
			logger.info("Email:");
			userId=sc.next();
			logger.info("Password:");
			password=sc.next();
			logger.info("Gender: \t 1: Male \t 2.Female\t 3.Other");
			genderV=sc.nextInt();
			sc.nextLine();
			logger.info("Branch:");
			branchName=sc.nextLine();
			logger.info("Batch:");
			batch=sc.nextInt();
			sc.nextLine();
			logger.info("Address:");
			address=sc.nextLine();
			logger.info("Country");
			country=sc.next();
			gender=Gender.getName(genderV);
			studentInterface.register(name, userId, password, gender, batch, branchName, address, country);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			logger.error("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
	}
	
	public void updatePassword()
	{
		Scanner sc=new Scanner(System.in);
		String userId,newPassword;
		try
		{
			logger.info("------------------Update Password--------------------");
			logger.info("Email");
			userId=sc.next();
			logger.info("New Password:");
			newPassword=sc.next();
			boolean isUpdated=userInterface.updatePassword(userId, newPassword);
			if(isUpdated)
				logger.info("Password updated successfully!");

			else
				logger.error("Something went wrong, please try again!");
		}
		catch(Exception ex)
		{
			logger.error("Error Occured "+ex.getMessage());
		}
	}
}
