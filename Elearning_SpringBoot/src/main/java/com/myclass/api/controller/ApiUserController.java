package com.myclass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.User;
import com.myclass.service.UserService;

@RestController

@RequestMapping("/api")
public class ApiUserController {
	@Autowired
	private UserService userService;

	@GetMapping("user")
	// @CrossOrigin(origins = "http://localhost:8080/api")
	public ResponseEntity<List<User>> get() {
		List<User> users = userService.findAll();
		if (users == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
