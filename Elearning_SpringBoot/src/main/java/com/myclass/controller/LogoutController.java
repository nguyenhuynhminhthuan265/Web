package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LogoutController {

	@GetMapping("logout")
	public String index() {
		return "redirect:/admin/login";
	}
}
