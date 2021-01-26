
package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * 
 * @author JEDI-03
 * User Class
 *
 */
public abstract class User {
	private String userId;
	private String name;
	private Role role;
	private String password;
	private Gender gender;
	private String address;
	private String country;
	

	/**
	 * Parameterized Constructor
	 * @param userId
	 * @param name
	 * @param role
	 * @param password
	 * @param gender
	 * @param address
	 * @param country
	 */
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
	
	/**
	 * Method to get Gender of user
	 * @return Gender
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * Method to set Gender of user
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * Method to get Address of user
	 * @return Address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Method to set Address of user
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Method to get country user is staying in
	 * @return User's Country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Method to set country user is staying in
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Default Constructor
	 */
	public User(){
		
	}
	
	/**
	 * Method to get User's Id
	 * @return User Id
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Method to set User's Id
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Method to get User's Name
	 * @return User Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to set User's Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to get User's Role
	 * @return User Role
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * Method to set User's Role
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * Method to get User's Password
	 * @return User Password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Method to set User's Password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
