/**
 * 
 */
package com.flipkart.restController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author dilpreetkaur
 *
 */

@Path("/user")
public class UserRestAPI {
	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	
	
	/**
	 * 
	 * @param userId: email address of the user
	 * @param newPassword: new password to be stored in db.
	 * @return @return 201, if password is updated, else 500 in case of error
	 */
	@GET
	@Path("/updatePassword")
	public Response updatePassword(
			@NotNull
			@Email(message = "Invalid User ID: Not in email format")
			@QueryParam("userId") String userId,
			@NotNull
			@Size(min = 4 , max = 20 , message = "Password length should be between 4 and 20 characters")
			@QueryParam("newPassword") String newPassword) throws ValidationException {
	
		if(userInterface.updatePassword(userId, newPassword))
		{
			return Response.status(201).entity("Password updated successfully! ").build();
		}
		else
		{
			return Response.status(500).entity("Something went wrong, please try again!").build();
		}
			
	}
	
	/**
	 * 
	 * @param userId
	 * @param password
	 * @return 
	 */
	
	@POST
	@Path("/login")
	public Response verifyCredentials(
			@NotNull
			@Email(message = "Invalid User ID: Not in email format")
			@QueryParam("userId") String userId,
			@NotNull
			@Size(min = 4 , max = 20 , message = "Password length should be between 4 and 20 characters")
			@QueryParam("password") String password) throws ValidationException {
		
		try 
		{
			boolean loggedin=userInterface.verifyCredentials(userId, password);
				if(loggedin)
				{
					String role=userInterface.getRole(userId);
					Role userRole=Role.stringToName(role);
					switch(userRole)
					{
					
					case STUDENT:
						int studentId=studentInterface.getStudentId(userId);
						boolean isApproved=studentInterface.isApproved(studentId);
						if(!isApproved)	
						{
							return Response.status(200).entity("Login unsuccessful! Student "+userId+" has not been approved by the administration!" ).build();
						}
						break;
						
					}
					return Response.status(200).entity("Login successful").build();
				}
				else
				{
					return Response.status(500).entity("Invalid credentials!").build();
				}
		}
		catch (UserNotFoundException e) 
		{
			return Response.status(500).entity(e.getMessage()).build();
		}		
		
}
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws ValidationException
	 */
	@GET
	@Path("/getRole")
	public String getRole(
			@NotNull
			@Email(message = "Invalid User ID: Not in email format")
			@QueryParam("userId") String userId ) throws ValidationException{
		
		return userInterface.getRole(userId);
	}
	
	/**
	 * 
	 * @param student
	 * @return 201, if user is created, else 500 in case of error
	 */
	@POST
	@Path("/studentRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(@Valid Student student)
	{
		
		try
		{
			studentInterface.register(student.getName(), student.getUserId(), student.getPassword(), student.getGender(), student.getBatch(), student.getBranchName(), student.getAddress(), student.getCountry());
		}
		catch(Exception ex)
		{
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		
		
		return Response.status(201).entity("Registration Successful for "+student.getUserId()).build(); 
	}
	
	
}
