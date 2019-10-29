package com.myclass.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Course;
import com.myclass.service.CategoryService;
import com.myclass.service.CourseService;

@Controller
@RequestMapping("admin/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("courses", courseService.findAll());
		return "course/index";
	}

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("categories", categoryService.findAll());
		return "course/add";
	}

	@PostMapping("add")
	public String add(Model model, @Valid @ModelAttribute("course") Course course, BindingResult errors) {
		// Kiểm tra nhập liệu
		if (errors.hasErrors()) {
			model.addAttribute("categories", categoryService.findAll());
			return "course/add";
		}

		courseService.insert(course);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/course";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		System.out.println(id);
		model.addAttribute("course", courseService.findById(id));
		model.addAttribute("categories", categoryService.findAll());
		return "course/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("course") Course course, BindingResult errors) {
		// Bắt lỗi nhập liệu
		if (errors.hasErrors()) {
			System.out.println("ERROR");
			model.addAttribute("categories", categoryService.findAll());
			return "course/edit";
		}

		courseService.update(course);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/course";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		// Xóa User theo id
		courseService.delete(id);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/course";
	}

}
