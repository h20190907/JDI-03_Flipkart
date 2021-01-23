/**
 * 
 */
package com.flipkart.bean;

/**
 * @author dilpreetkaur
 *
 */
public class Student extends User {
	private String branchName;
	private int studentId;
	private int batch;
	private boolean isApproved;
	
	
	// Parameterized Constructor
	public Student(String userId, String name, String role, String password,String branchName, int studentId, int batch, boolean isAppproved) {
		super(userId, name,  role, password);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isAppproved;
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
