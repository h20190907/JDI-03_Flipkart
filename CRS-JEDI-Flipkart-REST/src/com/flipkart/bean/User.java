
package com.flipkart.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * 
 * @author JEDI-03
 *
 */
public abstract class User {
	@Email(message = "Invalid User ID: Not in email format")
	@NotNull
	private String userId;
	
	@Size(min = 4 , max = 30 , message = "Name length should be between 4 and 30 characters")
	private String name;
	
	private Role role;
	
	@Size(min = 4 , max = 20 , message = "Password length should be between 4 and 20 characters")
	private String password;
	
	private Gender gender;
	
	@Size(min = 4 ,message = "Address length should be minimum 4 characters")
	private String address;
	
	@Size(min = 3 , max = 20, message = "Country name length should be between 3 and 20 characters")
	private String country;

	public User(String userId, String name, Role role, String password, Gender gender, String address,
			String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.country = country;
	}
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
