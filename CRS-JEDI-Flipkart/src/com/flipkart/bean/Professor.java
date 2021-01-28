package com.flipkart.bean;

/**
 * 
 * @author JEDI-03
 * Professor Class
 * 
 */
public class Professor extends User{
	private String department;
	private String designation;
	
	/**
	 * Method to get Designation of Professor
	 * @return Designation of Professor
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * Method to set Designation of Professor
	 * @param designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * Method to get Department of Professor
	 * @return Department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Method to set Department of Professor
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
}
