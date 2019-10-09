package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.repository.UserRepository;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@GetMapping("")
	public Object index() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("findByEmail")
	public Object findEmail(@RequestParam String email) {
		return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
	}
}
