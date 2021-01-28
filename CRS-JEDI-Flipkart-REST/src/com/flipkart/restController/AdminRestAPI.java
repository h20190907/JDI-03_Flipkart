/**
 * 
 */
package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

/**
 * @author dilpreetkaur
 *
 */
public class AdminRestAPI {
	
	AdminInterface adminOperation =AdminOperation.getInstance();
	private void assignCourseToProfessor() {
	
	}
	
	private void addProfessor() {
	
	}
	
	private List<Student> viewPendingAdmissions() {
		List<Student> students=new ArrayList<Student>();
		return students;
		
	}
	
	private void approveStudent() {
	}
	
	private void deleteCourse() {
	}
	

	private List<Course> viewCoursesInCatalogue() {
		List<Course> courses=new ArrayList<Course>();
		return courses;
	}

}
	
