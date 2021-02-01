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
	
	@NotNull
	@Min(value = 1, message = "Student ID should not be less than 1")
	@Max(value = 9999, message = "Student ID should be less than 10000")
	private int studentId;
    
	
	@NotNull
	@Min(value = 2017, message = "Batch number should not be less than 2017")
	@Max(value = 9999, message = "Batch number should be less than 10000")
	private int batch;
	
	private boolean isApproved;
	
	
	// Parameterized Constructor
	public Student(String userId, String name, Role role, String password, Gender gender, String address,
			String country,String branchName,int studentId,int batch,boolean isApproved) {
		super(userId, name,  role, password,gender,address,country);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
