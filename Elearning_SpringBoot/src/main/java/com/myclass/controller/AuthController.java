package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AuthController {
	
	@GetMapping("login")
	public String loginPage(@RequestParam(defaultValue="") String error, Model model) {
		if (!error.equals("")) {
			model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
		}
		return "login/index";
}
	
	
	
//	@PostMapping("login")
//	public String post() {
//		return "redirect:/admin/user";
//	}

}
