/**
 * 
 */
package com.flipkart.restController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

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
	
	
	@GET
	@Path("/updatePassword")
	public Response updatePassword(@QueryParam("userId") String userId, @QueryParam("newPassword") String newPassword) {
	
		if(userInterface.updatePassword(userId, newPassword))
		{
			return Response.status(201).entity("Password updated successfully! ").build();
		}
		else
		{
			return Response.status(201).entity("Something went wrong, please try again!").build();
		}
			
	}
	
	@GET
	@Path("/verifyCredentials")
	public Response verifyCredentials(@QueryParam("userId") String userId, @QueryParam("password") String password)  {
		
		try 
		{
			if(userInterface.verifyCredentials(userId, password))
			{
				return Response.status(201).entity("Login Successful ").build();
			}
			else
			{
				return Response.status(201).entity("Login Unsuccessful ").build();
			}
		} 
		catch (UserNotFoundException e) 
		{
			return Response.status(201).entity(e.getMessage()).build();
		}
		
		
	}
	
	@GET
	@Path("/getRole")
	public String getRole(@QueryParam("userId") String userId) {
		
		return userInterface.getRole(userId);
	}
	
	
}
