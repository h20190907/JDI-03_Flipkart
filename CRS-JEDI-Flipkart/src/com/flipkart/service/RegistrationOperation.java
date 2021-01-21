package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

public class RegistrationOperation implements RegistrationInterface {

	// TODO: arraylist of courses
	List<Course> courseCatalogue = new ArrayList<Course>();
	// TODO: add courses

	@Override
	public List<RegisteredCourse> registerCourses(int studentId, List<String> clist) {
		for (String l : clist) {
			for (Course cs : DummyDB.courseList) {
				if (l.equals(cs.getCourseCode()))
					cs.setSeats(cs.getSeats() - 1);
			}
		}
		DummyDB.registeredCourses.put(studentId, clist);
		return null;
	}

	@Override
	public boolean addCourse(String courseCode, int studentId) {

		DummyDB.registeredCourses.get(studentId).add(courseCode);
		for (Course cs : DummyDB.courseList) {
			if (courseCode.equals(cs.getCourseCode()))
				cs.setSeats(cs.getSeats() - 1);
		}
		return false;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) {
		
		DummyDB.registeredCourses.get(studentId).remove(courseCode);

		System.out.println(courseCode + "dropped successfully");
		for (Course cs : DummyDB.courseList) {
			if (courseCode.equals(cs.getCourseCode()))
				cs.setSeats(cs.getSeats() + 1);
		}
		return false;
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
		System.out.println("CourseCode  CourseName Instructor Seats\n");
		boolean exist = DummyDB.registeredCourses.containsKey(studentId);
		for (Course ls : DummyDB.courseList) {
			if (ls.getSeats() != 0
					&& (!exist || !DummyDB.registeredCourses.get(studentId).contains(ls.getCourseCode())))
				System.out.println(ls.getCourseCode() + "            " + ls.getCourseName() + "           "
						+ ls.getInstructor() + "       " + ls.getSeats());
		}
//		return null;
	}

	@Override
	public void viewRegisteredCourses(int studentId) {
//		System.out.println();
		if (!DummyDB.registeredCourses.containsKey(studentId)) {
			System.out.println("You have not registered any course yet ");
		} else {
			System.out.println("CourseCode \n");
			for (String ls : DummyDB.registeredCourses.get(studentId)) {

				System.out.println(ls);
			}
		}

	}

}
