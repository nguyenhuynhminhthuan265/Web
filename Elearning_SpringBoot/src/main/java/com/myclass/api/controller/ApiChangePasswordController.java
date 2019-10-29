package com.myclass.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.ChangePassword;
import com.myclass.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiChangePasswordController {
	@Autowired
	UserService userService;

	@PutMapping(value = "put/user/changepassword")
	public ResponseEntity<List<ChangePassword>> put(@Valid @RequestBody ChangePassword changePassword,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("CHANGE PASSWORD: ");
		System.out.println(changePassword.getEmail());
		System.out.println(changePassword.getPassword());
		userService.updatePassword(changePassword);
		return new ResponseEntity<List<ChangePassword>>(HttpStatus.OK);

	}

}
