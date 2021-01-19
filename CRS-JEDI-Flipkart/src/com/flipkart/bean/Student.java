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
	private String studentId;
	private int batch;
	private boolean isAppproved;
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	
	
}
