package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;

public class ProfessorRestAPI {
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();
	public List<EnrolledStudent> viewEnrolledStudents(String profId)
	{
		List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
		try
		{
			students=professorInterface.viewEnrolledStudents(profId);
		}
		catch(Exception ex)
		{
			return null;
		}	
		return students;
	}
	
	public List<Course> getCourses(String profId)
	{
		List<Course> courses=new ArrayList<Course>();
		try
		{
			courses=professorInterface.getCourses(profId);
			
		}
		catch(Exception ex)
		{
			return null;
		}
		return courses;
	
	}
	
	public void addGrade()
	{
		
	}
	
	private void addCourseToCatalogue() {
	}
	
	
}
