package com.flipkart.constant;

public enum Gender {
	MALE(1),FEMALE(2),OTHER(3);
	private final int gender;
	private Gender(int gender)
	{
		this.gender=gender;
	}
	
	@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}
	
	public static Gender getName(int val)
	{
		Gender gender=Gender.OTHER;
		switch(val)
		{
		case 1:
			gender=Gender.MALE;
			break;
		case 2:
			gender=Gender.FEMALE;
			break;
			
		}
		return gender;
	}
	
	
	
}

