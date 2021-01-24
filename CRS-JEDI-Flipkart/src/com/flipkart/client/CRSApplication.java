package com.flipkart.client;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.service.UserOperation;
import com.flipkart.constant.Gender;
import com.flipkart.exception.StudentNotRegisteredException;
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
	UserInterface userInterface =UserOperation.getInstance();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;	
		boolean isRegistered;
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
				default:
					logger.info("Invalid Input");
			}
			createMainMenu();
			userInput=sc.nextInt();
				
		}
		}
		catch(Exception ex)
		{
			
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
		logger.info("in login user");
		
	}
	
	public void registerStudent()
	{
		Scanner sc=new Scanner(System.in);
		StudentInterface studentInterface=StudentOperation.getInstance();
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
			logger.warn("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
		finally
		{
			sc.close();
		}
	}
<<<<<<< HEAD
=======
	public static String mapValueToGender(int genderV)
	{
		String gender="";
		switch(genderV)
		{
		case 1:
			gender= "Male";
			break;
		case 2:
			gender= "Female";
			break;
		case 3:
			gender= "Other";
			break;
		}
		return gender;
	}
>>>>>>> 374d9096410989d7ccb4497bd1596a91512e83d2
}
