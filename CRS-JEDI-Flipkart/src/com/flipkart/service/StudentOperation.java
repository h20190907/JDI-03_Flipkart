package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.client.CRSApplication;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.StudentNotRegisteredException;

public class StudentOperation implements StudentInterface {
	
	private static volatile StudentOperation instance=null;
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();

	private StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}
	
	
	@Override
	public void register(String name,String userId,String password,Gender gender,int batch,String branch,String address,String country) throws StudentNotRegisteredException{
		try
		{
			//call the DAO class, and add the student record to the DB
			Student newStudent=new Student(userId,name,Role.STUDENT,password,gender,address,country,branch,0,batch,false);
			studentDaoInterface.addStudent(newStudent);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public int getStudentId(String userId) {
		return studentDaoInterface.getStudentId(userId);
	
	}
	
	@Override
	public boolean isApproved(int studentId) {
		return studentDaoInterface.isApproved(studentId);
	}


}
