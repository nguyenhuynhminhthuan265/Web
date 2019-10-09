package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/target")
public class TargetController {
	
	@GetMapping("")
	public String index() {
		return "target/index";
	}
	
	@GetMapping("add")
	public String add() {
		return "target/add";
	}
	
}
