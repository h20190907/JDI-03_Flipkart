package com.flipkart.constant;

/**
 * 
 * @author JEDI-03
 * Enumeration class for Role Types
 *
 */
public enum Role {
	ADMIN,PROFESSOR,STUDENT;
	
	
	/*@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}*/
	
	/**
	 * Method to get Role object from String
	 * @param role
	 * @return Role object
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
