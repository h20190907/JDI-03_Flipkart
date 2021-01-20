package com.flipkart.client;

import java.util.Scanner;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.service.UserOperation;
import com.flipkart.bean.User;
import com.flipkart.service.DummyDB;
import com.flipkart.service.UserInterface;

public class CRSApplication {
	
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	static boolean loggedin = false;
	
	//TODO: Create the login menu
	//TODO: validate credentials call
	//TODO: role student default
	//Register
	//TODO: add courses
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DummyDB.init();

		UserInterface username = new UserOperation();
		int uid = 0;
		String password;
		
		while(true)
		{
			if(loggedin != true)
			{
				do
				{
				
					logger.info("-------Welcome to Course Registration System--------");
					logger.info("Enter Username:");
					uid = sc.nextInt();
					logger.info("Enter Password:");
					password = sc.next();
					
				}while(username.verifyCredentials(uid, password) == false);
				
				loggedin = true;
			}
			
			System.out.println("Login Successful");
			
			User user = DummyDB.studentList.get(uid);
			
			if(user.getRole().equals("Student"))
			{
				StudentMenu studentMenu = new StudentMenu();
				studentMenu.create_menu(uid);
			}
			else
			{
				
			}
			
			
		}
		
	}
		
		
		
	

} 	
