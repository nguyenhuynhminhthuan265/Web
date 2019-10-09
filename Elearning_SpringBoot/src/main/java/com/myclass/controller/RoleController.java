package com.myclass.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	List<Role> roles= new ArrayList<Role>();
	public RoleController() {
		
	}
	@GetMapping("")
	public String index(Model model) {
	    
		
		model.addAttribute("roles", roleService.findAll());
		return "role/index";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("role", new Role());
		return "role/add";
	}
	
	@PostMapping("add")
	public String add(Model model, 
			@Valid @ModelAttribute("role") Role role, 
			BindingResult errors) {
		// Kiểm tra nhập liệu
		if(errors.hasErrors()) {
			return "role/add";
		}
		System.out.println(role.getName());
		System.out.println(role.getDescription());
		// Thêm mới role và danh sách
		roleService.insert(role);
		
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/role";
	}
	
	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		System.out.println("ID EDIT: " + id);
		Optional<Role> role = roleService.findById(id);
		
		System.out.println("Name Role edit: " + role.get().getName());
		System.out.println("Description Role edit: " + role.get().getDescription());
		
		model.addAttribute("roleEdit", role);
		
		return "role/edit";
	}
	
	@PostMapping("edit")
	public String edit(@Valid @ModelAttribute("roleEdit") Role role, BindingResult errors) {
		if (errors.hasErrors()) {
			return "role/edit";
		}
		System.out.println(role.toString());
		roleService.update(role);
		return "redirect:/admin/role";
	}
	
	@GetMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") String id) {
		System.out.println("ID DELETE: " + id);
		Optional<Role> role = roleService.findById(id);
		
		System.out.println("Name Role delete: " + role.get().getName());
		System.out.println("Description Role delete: " + role.get().getDescription());
		
		roleService.delete(id);
		
		return "redirect:/admin/role";
	}
}
