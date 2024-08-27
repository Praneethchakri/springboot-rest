package com.practical.springboot.springbootRestproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practical.springboot.springbootRestproject.model.Course;
import com.practical.springboot.springbootRestproject.model.Student;
import com.practical.springboot.springbootRestproject.service.StudentCourseService;

@RestController
@RequestMapping("/app/{studentId}/courses")
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;

	@GetMapping()
	public ResponseEntity<Student> getStudentByID(@PathVariable("studentId") int studentId) {
		Student student = studentCourseService.getStudentByID(studentId);

		if (student != null) {
			return ResponseEntity.ok(student);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/studentList")
	public ResponseEntity<List<Student>> getListofStudents() {
		List<Student> studentList = studentCourseService.getListofStudents();
		if (studentList == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(studentList);
		}
	}


	@PostMapping()
	public ResponseEntity<Void> addCourseToStudent(@PathVariable("studentId") int studentId,
			@RequestBody Course course) {

		Course newCourse = studentCourseService.addCourse(studentId, course);
		if (newCourse == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}")
				.buildAndExpand(course.getCourseId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
