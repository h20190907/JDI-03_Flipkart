package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.validator.ProfessorValidator;

@Path("/professor")
public class ProfessorRestAPI {
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();
	
	@GET
	@Path("/getEnrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnrolledStudent> viewEnrolledStudents(@QueryParam("profId") String profId)
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
	
	@GET
	@Path("/getCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses(@QueryParam("profId") String profId)
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
	
	@POST
	@Path("/addGrade")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGrade(@QueryParam("studentId") int studentId,@QueryParam("courseCode") String courseCode,@QueryParam("profId") String profId,@QueryParam("grade") String grade)
	{
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(profId);
			if(ProfessorValidator.isValidStudent(enrolledStudents, studentId) && ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))
			{
				professorInterface.addGrade(studentId, courseCode, grade);
			}
			else
			{
				//error code
				return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
			}
		}
		catch(Exception ex)
		{
			return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
		}
		return Response.status(200).entity( "Grade updated for student: "+studentId).build();
		
	}
	
	
}
