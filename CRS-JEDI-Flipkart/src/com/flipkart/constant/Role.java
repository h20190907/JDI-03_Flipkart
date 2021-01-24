package com.flipkart.constant;

public enum Role {
	ADMIN,PROFESSOR,STUDENT;
	
	
	@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}
	
	public static Role stringToName(String role)
	{
		Role userRole=null;
		
		if(role.equals("ADMIN"))//admin==ADMIN
			userRole=Role.ADMIN;
		else if(role.equals("PROFESSOR"))
			userRole=Role.PROFESSOR;
		else if(role.equals("STUDENT"))
			userRole=Role.STUDENT;
		//System.out.println(userRole+"role in role class");
		return userRole;
	}
}
