package com.flipkart.constant;

public class SQLQueriesConstants {

	public static String DELETE_COURSE_QUERY = "delete from Course where courseCode = ?";
	public static String ADD_COURSE_QUERY = "insert into Course(courseCode, courseName, catalogId) values (?, ?, ?)";
	public static String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, role, gender, address, country from student natural join user where isApproved = 0";
	public static String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static String ADD_USER_QUERY = "insert into User(userId, name, password, role, gender, address, country) values (?, ?, ?, ?, ?, ?, ?)";
	public static String ADD_PROFESSOR_QUERY = "insert into Professor(userId, department, designation) values (?, ?, ?)";
	public static String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseCode = ?";
}
