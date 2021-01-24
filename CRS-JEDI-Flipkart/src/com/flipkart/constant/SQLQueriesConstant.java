
package com.flipkart.constant;

/**
 *  SQL Queries
 */
public class SQLQueriesConstant {
	
	
	// Student Query
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ? and where course.isOffered = ?;";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseCode not in  (select courseCode  from registeredcourse where studentId = ?) ";
	public static final String IS_REGISTERED=" select courseCode from registeredcourse where courseCode=? and studentId=? ";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from registeredcourse where studentId = ? ";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseCode = ? ";
	public static final String ADD_COURSE="insert into registeredcourse (studentId,courseCode) values ( ? , ? )";
	public static final String ADD_COURSE_QUERY = "insert into registeredcourse values(?,?,?);";
	public static final String DROP_COURSE_QUERY = "delete from registeredcourse where courseCode = ? AND studentId = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where  courseCode = ?;";
	public static final String CALCULATE_FEES  = "select sum(courseFee) from course where courseCode in (select courseCode from registeredcourse where studentID = ?);";
	public static final String VIEW_GRADE = "select course.courseCode,course.courseName,registeredcourse.grade from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?;";	
	public static final String GET_SEATS = "select seats from course where courseCode = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";
	public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
	public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";
	
	
}
