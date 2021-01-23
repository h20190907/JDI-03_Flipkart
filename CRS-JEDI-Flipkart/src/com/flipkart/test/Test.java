package com.flipkart.test;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseNotFoundException;

public class Test {
	
	private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);

	public static void main(String[] args) {
		RegistrationDaoInterface i = new RegistrationDaoOperation();
	}

}
