/**
 * 
 */
package com.flipkart.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author dilpreetkaur
 *
 */


public class Student extends User {
	
	@Size(min = 2, max = 30, message = "The length of BranchName should be between 5 to 30 characters")
	private String branchName;
	
	
	private int studentId;
    
	
	@NotNull
	@Min(value = 2017, message = "Batch number should not be less than 2017")
	@Max(value = 9999, message = "Batch number should be less than 10000")
	private int batch;
	
	private boolean isApproved;
	
	
	/**
	 * Parameterized Constructor
	 * @param userId
	 * @param name
	 * @param role
	 * @param password
	 * @param gender
	 * @param address
	 * @param country
	 * @param branchName
	 * @param studentId
	 * @param batch
	 * @param isApproved
	 */
	public Student(String userId, String name, Role role, String password, Gender gender, String address,
			String country,String branchName,int studentId,int batch,boolean isApproved) {
		super(userId, name,  role, password,gender,address,country);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
	}
	
	/**
	 * Default Constructor
	 */
	public Student() {
		
	}

	/**
	 * Method to get Branch Name of Student
	 * @return Branch Name
	 */
	public String getBranchName() {
		return branchName;
	}
	
	/**
	 * Method to set Branch Name of Student
	 * @param branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	/**
	 * Method to get Student Id
	 * @return Student Id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Method to get Batch of student
	 * @return Batch
	 */
	public int getBatch() {
		return batch;
	}
	
	/**
	 * Method to set Batch of student
	 * @param batch
	 */
	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	/**
	 * Method to check approval status of student
	 * @return Approval Status
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * Method to set approval status of student
	 * @return Approval Status
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
