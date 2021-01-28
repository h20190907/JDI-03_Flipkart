/**
 * 
 */
package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;

/**
 * @author dilpreetkaur
 *
 */
public class StudentRestAPI {
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	
	private void registerCourses(int studentId)
	{
		
	}
	
	private void addCourse(int studentId)	
	{
	}
	
	private boolean getRegistrationStatus(int studentId)
	{
		return false;
	}
	
	private void dropCourse(int studentId)
	{
		
	}
	
	private List<Course> viewCourse(int studentId)
	{
		List<Course> courses=new ArrayList<Course>();
		try
		{	
			courses=registrationInterface.viewCourses(studentId);
		}
		catch(Exception ex)
		{
			return null;
		}
		return courses;
	}
	
	private void make_payment(int studentId)
	{
		
	}
	
	private void viewGradeCard(int studentId)
	{
		
	}
}
