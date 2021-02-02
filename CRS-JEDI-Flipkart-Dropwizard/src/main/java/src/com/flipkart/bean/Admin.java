
package com.flipkart.bean;

import java.util.Date;

/**
 * 
 * @author Anurag Behera, Rag Patel
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
