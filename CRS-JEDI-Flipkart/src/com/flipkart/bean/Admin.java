/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author dilpreetkaur
 *
 */
public class Admin extends User{
	private Date dateOfJoining;

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
