package com.flipkart.business;

import java.util.List;
import com.flipkart.bean.RegisteredCourse;

public interface RegistrationInterface {
	public List<RegisteredCourse>  registerCourses(int semester,String studentId);
	public boolean addCourse(String courseCode,int semester,String studentId);
	public boolean dropCourse(String courseCode,int semester,String studentId);
	public double calculateFees(String studentId);
	public float generateReportCard(int semester,String studentId);
}
