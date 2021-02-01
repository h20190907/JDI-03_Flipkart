/**
 * 
 */
package com.flipkart.restController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

/**
 * @author Rag_Patel and Anurag
 *
 */
@Path("/admin")
public class AdminRestAPI {
	
	AdminInterface adminOperation = AdminOperation.getInstance();
	
	/**
	 * /admin/assignCourseToProfessor
	 * @param courseCode
	 * @param professorId
	 * @return
	 */
	@POST
	@Path("/assignCourseToProfessor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignCourseToProfessor(@QueryParam("courseCode") String courseCode, @QueryParam("professorId") String professorId) {
		
		try {
			adminOperation.assignCourse(courseCode, professorId);
			return Response.status(201).entity("courseCode: " + courseCode + " assigned to professor: " + professorId).build();
		} 
		catch (CourseNotFoundException e) {
			return Response.status(201).entity(e.getMessage()).build();
		}
		
	}
	
	/**
	 * /admin/addProfessor
	 * @param professor
	 * @return
	 */
	@POST
	@Path("/addProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(Professor professor) {
		
		try {
			adminOperation.addProfessor(professor);
			return Response.status(201).entity("Professor with professorId: " + professor.getUserId() + " added").build();
		} catch (ProfessorNotAddedException e) {
			return Response.status(201).entity(e.getMessage()).build();
		}
		
	}
	
	/**
	 * /admin/viewPendingAdmissions
	 * @return
	 */
	@GET
	@Path("/viewPendingAdmissions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> viewPendingAdmissions() {
		
		return adminOperation.viewPendingAdmissions();
		
	}
	
	/**
	 * /admin/approveStudent
	 * @param studentId
	 * @return
	 */
	@PUT
	@Path("/approveStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(@QueryParam("studentId") int studentId) {
		List<Student> studentList = adminOperation.viewPendingAdmissions();
		
		try {
			adminOperation.approveStudent(studentId, studentList);
			return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();
		} catch (StudentNotFoundException e) {
			return Response.status(201).entity(e.getMessage()).build();
		}
		
	}
	
	/**
	 * /admin/viewCoursesInCatalogue
	 * @return
	 */
	@GET
	@Path("/viewCoursesInCatalogue")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewCoursesInCatalogue() {
		
		return adminOperation.viewCourses(1);
		
	}
	
	/**
	 * /admin/deleteCourse
	 * @param courseCode
	 * @return
	 */
	@PUT
	@Path("/deleteCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCourse(@QueryParam("courseCode") String courseCode) {
		List<Course> courseList = adminOperation.viewCourses(1);
		
		try {
			adminOperation.deleteCourse(courseCode, courseList);
			return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
		} catch (CourseNotFoundException e) {
			return Response.status(201).entity(e.getMessage()).build();
		}	
	}
	
	/**
	 * /admin/addCourse
	 * @param course
	 * @return
	 */
	@POST
	@Path("/addCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(Course course) {
		List<Course> courseList = adminOperation.viewCourses(1);
		
		try {
			adminOperation.addCourse(course, courseList);
			return Response.status(201).entity("Course with courseCode: " + course.getCourseCode() + " added to catalog").build();
		} catch (CourseFoundException e) {
			return Response.status(201).entity(e.getMessage()).build();
		}
			
	}
}
	
