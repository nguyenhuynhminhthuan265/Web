package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	@GetMapping("/admin/home")
	public String index() {
		return "home/index";
	}

	@GetMapping("/home")
	public String index1() {
		return "home/index";
	}
}
