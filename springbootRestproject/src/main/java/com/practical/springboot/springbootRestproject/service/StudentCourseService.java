package com.practical.springboot.springbootRestproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practical.springboot.springbootRestproject.model.Course;
import com.practical.springboot.springbootRestproject.model.Student;

@Service
public class StudentCourseService {
	private static  List<Student> studentList = new ArrayList<Student>();
	private static  List<Course> courseList = new ArrayList<Course>();

	static {
		Course java = new Course(1, "OpenSource-Java");
		Course oracle = new Course(2, "SQL-Oracle");
		Course aws = new Course(3, "ColudService-AWS");
		Course gcp = new Course(4, "CloudService-GCP");
		Course react = new Course(5, "UI/UX/Backend-ReactJS");

		Student s1 = new Student(123, "Praneeth", "Kadiri", new ArrayList<>(List.of(oracle, java)));
		Student s2 = new Student(124, "Praneeth1", "Chennai", new ArrayList<>(List.of(aws, gcp)));
		Student s3 = new Student(125, "Praneeth2", "Bangalore", new ArrayList<>(List.of(aws, gcp)));
		Student s4 = new Student(126, "Praneeth3", "Germany", new ArrayList<>(List.of(aws, react)));

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		courseList.add(java);
		courseList.add(oracle);
		courseList.add(aws);
		courseList.add(gcp);
		courseList.add(react);
		
	}

	public Student getStudentByID(int id) {
		System.out.println("Student Details "
				+ studentList.stream().filter(student -> student.getStudentId() == (id)).findAny().orElse(null));
		return studentList.stream().filter(student -> student.getStudentId() == (id)).findAny().orElse(null);
	}

	public List<Student> getListofStudents() {
		System.out.println(studentList.toString());
		return studentList;
	}
	
	
	public List<Course> retriveAllCourse() {
		return courseList;
	}

	public List<Course> retriveCourse(int studentId) {
		Student student = getStudentByID(studentId);
		return student == null ? null : student.getCourseList();
	}

	public Course addCourse(int studentId, Course course) {
		Student student = getStudentByID(studentId);
		System.out.println("Test0 " +student.toString());
		try {
			student.getCourseList().add(course);
		}catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println("Test" +student.toString());
		return course;

	}

}
