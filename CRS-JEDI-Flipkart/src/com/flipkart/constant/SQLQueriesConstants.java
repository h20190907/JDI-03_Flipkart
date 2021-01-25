package com.flipkart.constant;
/**
 * 
 * @author JEDI-03
 *
 */

public class SQLQueriesConstants {

	public static final String DELETE_COURSE_QUERY = "delete from Course where courseCode = ?";
	public static final String ADD_COURSE_QUERY = "insert into Course(courseCode, courseName, catalogId) values (?, ?, ?)";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, role, gender, address, country, studentId from student natural join user where isApproved = 0";
	public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static final String ADD_USER_QUERY = "insert into User(userId, name, password, role, gender, address, country) values (?, ?, ?, ?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into Professor(userId, department, designation) values (?, ?, ?)";
	public static final String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseCode = ?";
	public static final String ADD_STUDENT="insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
	public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
	public static final String GET_ROLE="select role from user where userId = ? ";
	public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
	public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
	public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
	public static final String GET_PROF_NAME = "select name from user where userId = ?";
	
	
	// Student Query
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseCode not in  (select courseCode  from registeredcourse where studentId = ?) and course.isOffered = ?";
	public static final String IS_REGISTERED=" select courseCode from registeredcourse where courseCode=? and studentId=? ";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from registeredcourse where studentId = ? ";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseCode = ? ";
	public static final String ADD_COURSE="insert into registeredcourse (studentId,courseCode) values ( ? , ? )";
	public static final String DROP_COURSE_QUERY = "delete from registeredcourse where courseCode = ? AND studentId = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where  courseCode = ?;";
	public static final String CALCULATE_FEES  = "select sum(courseFee) from course where courseCode in (select courseCode from registeredcourse where studentID = ?);";
	public static final String VIEW_GRADE = "select course.courseCode,course.courseName,registeredcourse.grade from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?;";	
	public static final String GET_SEATS = "select seats from course where courseCode = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";
	public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
	public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";
	public static final String ADD_GRADE="update registeredcourse set Grade=? where courseCode=? and studentId=?";
	public static final String GET_COURSES="select * from course where professorId=?";
}
