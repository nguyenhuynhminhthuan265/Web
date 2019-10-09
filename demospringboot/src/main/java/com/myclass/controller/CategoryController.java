package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.repository.CategoryRepository;
@RestController
@RequestMapping("api/category")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	@GetMapping("")
	public Object index() {
		return new ResponseEntity<>(categoryRepository.findAllOrderByName(), HttpStatus.OK);
	}
	
}


