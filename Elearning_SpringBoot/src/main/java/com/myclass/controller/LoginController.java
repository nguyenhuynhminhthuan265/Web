package com.myclass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.LoginUserDto;
import com.myclass.entity.User;
import com.myclass.service.UserService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	UserService userService;

	@GetMapping("login")
	public String loginPage(@RequestParam(defaultValue = "") String error, Model model) {

		if (!error.equals("")) {
			model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");

		}
		model.addAttribute("loginUserDto", new LoginUserDto());
		return "login/index";
	}

	@PostMapping("login")
	public String post(@Valid @ModelAttribute("loginUserDto") LoginUserDto loginUserDto, BindingResult errors,
			Model model, HttpServletRequest req) {
		System.out.println("Email login: " + loginUserDto.getEmail());
		System.out.println("Password login: " + loginUserDto.getPassword());
		User user = userService.findByEmail(loginUserDto.getEmail());
		if (user == null) {
			model.addAttribute("error", "Email not in database");
			return "login/index";
		}
		System.out.println("password in database: " + user.getPassword());
		if (BCrypt.checkpw(loginUserDto.getPassword(), user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("USER_LOGIN", user);
			System.out.println("FullName Login: " + user.getFullname());
			return "redirect:/admin/home";
		}

		else {
			model.addAttribute("error", "Check account");
			return "login/index";
		}

	}

}
