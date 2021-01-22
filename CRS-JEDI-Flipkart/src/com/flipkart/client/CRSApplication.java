package com.flipkart.client;

import java.util.Scanner;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.service.UserOperation;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserInterface;

public class CRSApplication {

	private static Logger logger = Logger.getLogger(CRSApplication.class);
	static boolean loggedin = false;
	

	/**
	 * This is UserClient class for login and registration
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//DummyDB.init();

		UserInterface username = new UserOperation();
		int uid = 0;
		String password;


		while (true) {
			try {
				if (loggedin != true) {

					do {

						logger.info("-------Welcome to CRS Login-------");
						logger.info("Enter Username:");
						uid = sc.nextInt();
						logger.info("Enter Password:");
						password = sc.next();

					} while (username.verifyCredentials(uid, password) == false);

					loggedin = true;
					logger.info("Login Successful!");
				}

//				User user = DummyDB.studentList.get(uid);
//				if (user.getRole().equals("Student")) {
//					StudentMenu studentMenu = new StudentMenu();
//					studentMenu.create_menu(uid);
//					logger.info("Logout Successful!");
//				}
//				else if(user.getRole().equals("Professor"))
//				{
//					
//				}
//				else if(user.getRole().equals("Admin" ))
//				{
//					
//				}
			} 
			catch (UserNotFoundException e) {
				logger.error("User Not Found " + e.getUserId());
			}
			finally
			{
				sc.close();
			}
		}
	}
}
