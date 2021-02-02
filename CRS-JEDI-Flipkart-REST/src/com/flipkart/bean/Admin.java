
package com.flipkart.bean;

import java.util.Date;

/**
 * 
 * @author JEDI-03
 * Admin Class
 * 
 */
public class Admin extends User{
	private Date dateOfJoining;

	/**
	 * Method to get Date of joining
	 * @return Date of joining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Method to set Date of joining
	 * @param dateOfJoining
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
