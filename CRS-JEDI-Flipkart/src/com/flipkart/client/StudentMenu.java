/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class StudentMenu {
	/*TODO: Student menu create
	1. Register
	2. Add course
	3. Drop course
	4. View course
	5. view grade card
	//calculate fee*/
	private static Logger logger = Logger.getLogger(StudentMenu.class);
	//TODO: Course Register-- View Cpurses, business class
	//TODO: display courses
	//TODO: input the courses
	
	public void create_menu(int sid)
	{
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("\n1. Register\n2. Add course\n3. Drop course\n4. View course\n5. View grade card\n6. Logout");
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
				{
					CRSApplication.loggedin  = false;
					return;
				}
				default:
					System.out.println("***** Wrong Choice *****");
				
			}
		}
		

		
		
	}
	
}
