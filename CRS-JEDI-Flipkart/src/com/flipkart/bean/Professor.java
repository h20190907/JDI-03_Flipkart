/**
 * 
 */
package com.flipkart.bean;
import java.util.Date;
/**
 * @author dilpreetkaur
 *
 */
public class Professor extends User{
	private String department;
	private String designation;
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
