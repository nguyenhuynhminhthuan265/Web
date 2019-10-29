package com.myclass.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.LoginUserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api")
public class ApiLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

//	@GetMapping("login")
//	public ResponseEntity<List<Category>> get() {
//		List<Category> categories = categoryService.findAll();
//		if (categories == null) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<String>(token, HttpStatus.OK);
//	}

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginUserDto userLogin, HttpServletResponse response) {

		final String JWT_SECRET = "chuoi_bi_mat";
		// Bước 1: Thực hiện đăng nhập
		System.out.println("Client email: " + userLogin.getEmail());
		System.out.println("Client password: " + userLogin.getPassword());
		// Tạo đối tượng chứa email, password
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userLogin.getEmail(),
				userLogin.getPassword());
		// Thực hiện đăng nhập
		try {
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Bước 2: Nếu đăng nhập thành công thi tạo token
			// Nếu thất bại thì trả về lỗi cho client
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			Date now = new Date();

			// Tiến hành tạo token
			String token = Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(now) // Thời điểm phát hành
					.setExpiration(new Date(now.getTime() + 864000000L)) // Thời gian tồn tại của token
					.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
			/// response.setHeader("Authorization", "Bearer " + token);
			System.out.println("Token: " + token);
			// response.addHeader("Authorization", "Bearer " + token);
			return new ResponseEntity<String>(token, HttpStatus.OK);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Sai tên đăng nhập hoặc mật khẩu", HttpStatus.BAD_REQUEST);
	}
}
