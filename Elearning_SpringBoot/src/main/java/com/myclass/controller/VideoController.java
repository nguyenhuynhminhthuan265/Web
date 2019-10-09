package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/video")
public class VideoController {
	
	@GetMapping("")
	public String index() {
		return "video/index";
	}
	
	@GetMapping("add")
	public String add() {
		return "video/add";
	}
	
}
