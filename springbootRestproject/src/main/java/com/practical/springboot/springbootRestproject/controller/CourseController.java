package com.practical.springboot.springbootRestproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practical.springboot.springbootRestproject.model.Course;
import com.practical.springboot.springbootRestproject.service.StudentCourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseController {
	
	@Autowired
	private StudentCourseService studentCourseService;

	@GetMapping()
	public ResponseEntity<Course> getCourseListofStudent(@RequestParam(name = "courseId") int courseId) {
		Course listCourse = studentCourseService.retriveCourseByCourseID(courseId);
		if (listCourse != null) {
			return ResponseEntity.ok(listCourse);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
