package com.flipkart.constant;

public enum Role {
	ADMIN(1),PROFESSOR(2),STUDENT(3);
	final private int role;
	
	private Role(int role)
	{
		this.role=role;
	}
	
	@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}
	
	public static Role stringToName(String gender)
	{
		Role userRole;
		if(gender.equalsIgnoreCase("admin"))
			userRole=Role.ADMIN;
		else if(gender.equalsIgnoreCase("professor"))
			userRole=Role.PROFESSOR;
		else if(gender.equalsIgnoreCase("student"));
			userRole=Role.STUDENT;
		return userRole;
	}
}
