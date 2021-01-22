
package com.flipkart.bean;

import com.flipkart.constant.Gender;

// User bean class	
public abstract class User {
	private String userId;
	private String name;
	private String role;
	private String password;
	private Gender gender;
	private String address;
	private String country;
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public User(){
		
	}
	public User(String userId, String name, String role, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
