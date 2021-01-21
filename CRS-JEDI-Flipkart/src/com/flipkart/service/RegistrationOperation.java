package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);

	/**
	 * Register Courses selected by student
	 * @param studentId 
	 * @param clist  --> list of courses selected by student
	 * @return s
	 */
	
	@Override
	public boolean registerCourses(int studentId, List<String> courseList) {
		for (String courseCode : courseList) {
			for (Course course : DummyDB.courseList) {
				if (courseCode.equals(course.getCourseCode()))
					course.setSeats(course.getSeats() - 1);
			}
		}
		logger.info("Courses added to DB");
		DummyDB.registeredCourses.put(studentId, courseList);
		return true;
	}

	/**
	 * Add Course selected by student 
	 * @param courseCode --> code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	
	
	public boolean addCourse(String courseCode, int studentId) {

		DummyDB.registeredCourses.get(studentId).add(courseCode);
		for (Course course : DummyDB.courseList) {
			if (courseCode.equals(course.getCourseCode()))
				course.setSeats(course.getSeats() - 1);
		}
		return true;
	}

	/**
	 * Drop Course selected by student
	 * @param courseCode --> code for selected course
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId) throws CourseNotFoundException {
		try {
			
		
		DummyDB.registeredCourses.get(studentId).remove(courseCode);

		logger.info("Course " + courseCode + "dropped successfully");
		for (Course course : DummyDB.courseList) {
			if (courseCode.equals(course.getCourseCode()))
				course.setSeats(course.getSeats() + 1);
		}}
		catch(NullPointerException e){
			throw new CourseNotFoundException(courseCode);
		}
		return true;
	}
	
	/**
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return
	 */
	@Override
	public double calculateFees(int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	@Override
	public float generateReportCard(int semester, int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * View the list of available courses
	 * The list will not display the courses registered by student
	 * @param studentId
	 */
	@Override
	public void viewCourses(int studentId) {
		logger.info("CourseCode  CourseName Instructor Seats\n");
		boolean exist = DummyDB.registeredCourses.containsKey(studentId);
		for (Course course : DummyDB.courseList) {
			if (course.getSeats() != 0 && (!exist || !DummyDB.registeredCourses.get(studentId).contains(course.getCourseCode()))) {
				logger.info(course.getCourseCode() + ", " + course.getCourseName() + ", "+ course.getInstructor() + ", " + course.getSeats());
			}
		}
	}

	/**
	 * View the list of courses registered by the student
	 * @param studentId
	 */
	@Override
	public void viewRegisteredCourses(int studentId) {
		if (!DummyDB.registeredCourses.containsKey(studentId)) {
			logger.warn("You have not registered any course yet ");
		} else {
			logger.info("CourseCodes: ");
			for (String courseCode : DummyDB.registeredCourses.get(studentId)) {
				logger.info(courseCode + " ");
			}
		}
	}
}
