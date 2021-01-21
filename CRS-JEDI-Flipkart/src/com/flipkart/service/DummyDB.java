package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class DummyDB {

	public static Map<Integer,Student> studentList;
	public static List<Course> courseList;
	public static Map<Integer,List<String>> registeredCourses;

	
	public static void init() {
		
		studentList = new HashMap<Integer,Student>();
		courseList = new ArrayList<Course>();
		registeredCourses = new HashMap<Integer, List<String>>();
		
		studentList.put(1,new Student(1,"Dilpreet","Student","1234","CS",101,2019,true));
		studentList.put(2,new Student(2,"Rag","Student","1235","CS",102,2017,true));
		studentList.put(3,new Student(3,"Umang","Student","1236","CS",003,2017,true));
		studentList.put(4,new Student(4,"Lakshya","Student","1237","EEE",004,2017,true));
		studentList.put(5,new Student(5,"Anurag","Student","1238","ENI",005,2017,true));
		
		for(int i=0; i<10; i++)
		{
			courseList.add(new Course(String.valueOf(i+1),Character.toString('A' + i),"I" +String.valueOf(i+1),10,true));
		}
		
	}
		
}
