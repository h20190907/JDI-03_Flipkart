package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;

public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);

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

	@Override
	public boolean addCourse(String courseCode, int studentId) {

		DummyDB.registeredCourses.get(studentId).add(courseCode);
		for (Course course : DummyDB.courseList) {
			if (courseCode.equals(course.getCourseCode()))
				course.setSeats(course.getSeats() - 1);
		}
		return true;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) {
		
		DummyDB.registeredCourses.get(studentId).remove(courseCode);

		logger.info("Course " + courseCode + "dropped successfully");
		for (Course course : DummyDB.courseList) {
			if (courseCode.equals(course.getCourseCode()))
				course.setSeats(course.getSeats() + 1);
		}
		return true;
	}
	
	@Override
	public double calculateFees(int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float generateReportCard(int semester, int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

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
