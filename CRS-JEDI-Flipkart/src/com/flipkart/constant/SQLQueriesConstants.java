package com.flipkart.constant;

public class SQLQueriesConstants {

	public static String DELETE_COURSE_QUERY = "delete from Course where courseCode = ?";
	public static String ADD_COURSE_QUERY = "insert into Course(courseCode, courseName, catalogId) values (?, ?, ?)";
	public static String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, role, gender, address, country, studentId from student natural join user where isApproved = 0";
	public static String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static String ADD_USER_QUERY = "insert into User(userId, name, password, role, gender, address, country) values (?, ?, ?, ?, ?, ?, ?)";
	public static String ADD_PROFESSOR_QUERY = "insert into Professor(userId, department, designation) values (?, ?, ?)";
	public static String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseCode = ?";
	public static final String ADD_STUDENT="insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
	public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
	public static final String GET_ROLE="select role from user where userId = ? ";
	public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
	public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
	public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
}
