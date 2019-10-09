package com.myclass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@RestController
@RequestMapping("/api/admin")
public class ApiRoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("role")
	public ResponseEntity<List<Role>> get(){
		List<Role> roles = roleService.findAll();
		if(roles == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
}
