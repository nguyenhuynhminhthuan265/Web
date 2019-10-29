package com.myclass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Course;
import com.myclass.service.CourseService;

@RestController

@RequestMapping("/api")
public class ApiCourseController {
	@Autowired
	private CourseService courseService;

	// @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("course")
	public ResponseEntity<List<Course>> get() {
		List<Course> categories = courseService.findAll();

		if (categories == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Course>>(categories, HttpStatus.OK);
	}
}
