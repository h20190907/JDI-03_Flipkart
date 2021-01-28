/**
 * 
 */
package com.flipkart.restController;

import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author dilpreetkaur
 *
 */
public class UserRestAPI {
	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	
	public boolean loginUser(String username,String password)
	{
		return false;
	}
}
