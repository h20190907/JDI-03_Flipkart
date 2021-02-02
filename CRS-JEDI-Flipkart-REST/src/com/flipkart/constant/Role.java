package com.flipkart.constant;

/**
 * 
 * @author JEDI-03
 *
 */
public enum Role {
	ADMIN,PROFESSOR,STUDENT;
	
	
	/**
	 * Method to convert String to Role Enum
	 * @param role
	 * @return
	 */
	public static Role stringToName(String role)
	{
		Role userRole=null;

		if(role.equalsIgnoreCase("ADMIN"))
			userRole=Role.ADMIN;
		else if(role.equalsIgnoreCase("PROFESSOR"))
			userRole=Role.PROFESSOR;
		else if(role.equalsIgnoreCase("STUDENT"))
			userRole=Role.STUDENT;
		return userRole;
	}
}
