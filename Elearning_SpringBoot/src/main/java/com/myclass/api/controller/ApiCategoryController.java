package com.myclass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@RestController
@RequestMapping("/api")
public class ApiCategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("category")
	// @CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<List<Category>> get() {
		List<Category> categories = categoryService.findAll();
		if (categories == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
}
