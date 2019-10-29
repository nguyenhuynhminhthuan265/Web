package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.CustomUserDetails;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	// lấy ra thông tin đăng nhập của ng dùng từ form
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Lấy ra thông tin từ databse mà có email trùng với email đăng nhập lấy ra từ
		// form
		User user = userRepository.findByEmail(email);
		// Kiểm tra
		// không tìm thấy thì xuất thông báo
		System.out.println("loadUserByUsername: ");
		System.out.println(user.toString());
		if (user == null)
			throw new UsernameNotFoundException("Không tìm thấy thông tin user");

		// Tạo danh sách chứa tên các quyền
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// Lấy ra tên quyền vào danh sách
		String roleName = user.getRole().getName();
		// thêm quyền vào danh sách
		authorities.add(new SimpleGrantedAuthority(roleName));
		CustomUserDetails customUserDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
		customUserDetails.setFullname(user.getFullname());
//		Model model = null;
//		model.addAttribute("customUserDetails", customUserDetails);// hiện fullname trên navbar

		return customUserDetails;
	}

}
