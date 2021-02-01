/**
 * 
 */
package com.flipkart.restController;

import java.sql.SQLException;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;
import com.flipkart.validator.StudentValidator;
import com.flipkart.validator.ValidationExceptionMapper;

/**
 * @author JEDI - 03
 *
 */

@Path("/student")
public class StudentRestAPI {
	
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	
	private static Logger logger = Logger.getLogger(StudentRestAPI.class);
	
	@POST
	@Path("/registerCourses")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourses(List<String> courseList, @QueryParam("studentId") int studentId)
	{
		List<Course> availableCourseList = null;
						
		try
		{
			availableCourseList = registrationInterface.viewCourses(studentId);
	
			for(String courseCode:courseList)
				registrationInterface.addCourse(courseCode, studentId, availableCourseList);	
			registrationInterface.setRegistrationStatus(studentId);
		}
		catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException | SQLException e) 
		{
			logger.info(e.getMessage());
			return Response.status(201).entity(e.getMessage()).build();
		}
					
		
		return Response.status(201).entity( "Registration Successful").build();
		
	}
	


 	
	@PUT
	@Path("/addCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(
			@Size(min = 4 , max = 10 , message = "Course Code length should be between 2 and 10 character")
			@NotNull
			@QueryParam("courseCode") String courseCode,
			@Min( value = 1, message = "student id should not be less than 1")
			@NotNull
			@QueryParam("studentId") int studentId) throws ValidationException{
		
		
		try
		{
			List<Course> availCourseList = registrationInterface.viewCourses(studentId);
			
			if(registrationInterface.addCourse(courseCode, studentId, availCourseList))
			{
			  return Response.status(201).entity( "You have successfully added Course : " + courseCode).build();
			}
			else
		    {
				return Response.status(201).entity( "You have already added Course : " + courseCode).build();
		    }
			
		}
		catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException | SQLException e) 
		{
			logger.info(e.getMessage());
			return Response.status(201).entity(e.getMessage()).build();
		}
		
	}

	
	@DELETE
	@Path("/dropCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(
			@Size(min = 4 , max = 10 , message = "Course Code length should be between 2 and 10 character")
			@NotNull
			@QueryParam("courseCode") String courseCode,
			@Min( value = 1, message = "student id should not be less than 1")
			@NotNull
			@QueryParam("studentId") int studentId) throws ValidationException{
		
		try
		{
			List<Course>registeredCourseList = registrationInterface.viewRegisteredCourses(studentId);
			
			registrationInterface.dropCourse(courseCode, studentId, registeredCourseList);
			
			return Response.status(201).entity( "You have successfully dropped Course : " + courseCode).build();
			
		}
		catch(CourseNotFoundException e)
		{	
			return Response.status(201).entity("You have not registered for course : " + e.getCourseCode()).build();
		} 
		catch (SQLException e) 
		{
			return Response.status(201).entity(e.getMessage()).build();
		}
		
	}
	
	
	@GET
	@Path("/viewCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewCourse(@QueryParam("studentId") int studentId)
	{
		
		List<Course> courses = null;
		
		try
		{	
			courses=registrationInterface.viewCourses(studentId);
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		
		return courses;
	}
	
	@GET
	@Path("/viewRegisteredCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewRegisteredCourse(@QueryParam("studentId") int studentId)
	{
		List<Course> courses = null;
		
		try 
		{
			courses = registrationInterface.viewRegisteredCourses(studentId);
		} 
		catch (SQLException e) 
		{
			logger.info(e.getMessage());
		}
		
		return courses;
	}
	
	@POST
	@Path("/make_payment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response make_payment(@QueryParam("studentId") int studentId , @QueryParam("paymentMode") int paymentMode)
	{
		
			
			try
			{
				double fee=registrationInterface.calculateFee(studentId);

				fee = registrationInterface.calculateFee(studentId);
				logger.info("Your total fee  = " + fee);
				ModeOfPayment mode = ModeOfPayment.getModeofPayment(paymentMode);
				
			
				Notification notify = registrationInterface.payFee(studentId, mode,fee);

				
				logger.info("Your Payment is successful");
				logger.info("Your transaction id : " + notify.getReferenceId());
			
				return Response.status(201).entity("Your total fee  = " + fee+"\n"+"Your Payment is successful\n"+"Your transaction id : " + notify.getReferenceId()).build();
				
			}
			catch (SQLException e) 
			{
	            logger.info(e.getMessage());
	            return Response.status(501).entity("Exception e").build();
			}
		
	}
	
	@GET
	@Path("/calculateFee")
	public Response calculateFee(@QueryParam("studentId") int studentId , @QueryParam("paymentMode") int paymentMode)
	{
		try
		{
			double fee = registrationInterface.calculateFee(studentId);
			return Response.status(201).entity("Your total fee  = " + fee + "\n").build();
		} 
		catch (SQLException e) 
		{
            logger.info(e.getMessage());
    		return Response.status(501).entity("SQL Exception\n").build();
		}
	}
	
	@GET
	@Path("/viewGradeCard")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentGrade> viewGradeCard(@QueryParam("studentId") int studentId)
	{
		List<StudentGrade> grade_card = null;
		
		try 
		{
			grade_card = registrationInterface.viewGradeCard(studentId);
		} 
		catch (SQLException e) 
		{
            logger.info(e.getMessage());          
		}
		
		return grade_card;
		
	}
	
}
