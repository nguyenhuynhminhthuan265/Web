//package com.myclass.filter;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.myclass.entity.Role;
//import com.myclass.entity.User;
//import com.myclass.service.RoleService;
//
//@Component
//public class AuthFilter implements Filter {
//
//	@Autowired
//	RoleService roleService = null;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//		List<Role> roles = roleService.findAll();
//		session.setAttribute("name_roles", roles);
//		String action = req.getServletPath();
//
//		System.out.println("ACTION: " + action);
//		// Trường hợp request yêu cầu vào trang login
//		if (action.startsWith("/admin/login") || action.startsWith("/error") || action.equals("/register")
//				|| action.startsWith("/api")) {
//
//			chain.doFilter(request, response);
//			return;
//		}
//
//		// Trường hợp client (chưa đăng nhập lần nào) gửi request muốn vào các trang
//		// khác mà không thông qua login thì chuyển hướng qua login
//		// check login
//
//		if (session.getAttribute("USER_LOGIN") == null) {
//			// chuyển hướng về trang đăng nhập
//			resp.sendRedirect(req.getContextPath() + "/login?error=123");
//			return;
//		}
//		Decentralization(request, response, chain, req, resp, session, action);
//
//	}
//
//	public void Decentralization(ServletRequest request, ServletResponse response, FilterChain chain,
//			HttpServletRequest req, HttpServletResponse resp, HttpSession session, String action)
//			throws IOException, ServletException {
//		// ====-----------------PHÂN QUYỀN-------------------------
//		// kiểm tra url có bắt đầu = /admin
//		// admin được vào user, role
//		if (action.startsWith("/admin")) {
//			User user = (User) session.getAttribute("USER_LOGIN");
//			// kiểm tra quyền của người dùng
//			System.out.println("ROLE OF USER: " + user.getRole().getName());
//			if (user.getRole().getName().equals("ROLE_ADMIN")) {
//				// cho phép đi vào servlet đích
//				chain.doFilter(request, response);
//
//			} else if (user.getRole().getName().equals("ROLE_MANAGER")) {
//
//				chain.doFilter(request, response);
//
//			} else if (user.getRole().getName().equals("ROLE_USER")) {
//				resp.sendRedirect(req.getContextPath() + "/home");
//				return;
//
//			} else {
//				System.out.println("req.getContextPath() :" + req.getContextPath());
//				resp.sendRedirect(req.getContextPath() + "/login");
//			}
//			// manager chỉ được vào user
//		} else if (action.startsWith("/manager")) {
//			User user = (User) session.getAttribute("USER_LOGIN");
//			// kiểm tra quyền của người dùng
//			if (user.getRole().getName().equals("ROLE_ADMIN") || user.getRole().getName().equals("ROLE_MANAGER")) {
//				// cho phép đi vào servlet đích nếu có quyền là manager hoặc admin
//				chain.doFilter(request, response);
//
//			} else {
//				resp.sendRedirect(req.getContextPath() + "/login");
//			}
//		} else if (action.startsWith("/admin/home")) {
//			User user = (User) session.getAttribute("USER_LOGIN");
//			// kiểm tra quyền của người dùng
//			if (user.getRole().getName().equals("ROLE_ADMIN") || user.getRole().getName().equals("ROLE_MANAGER")
//					|| user.getRole().getName().equals("ROLE_USER")) {
//				// cho phép đi vào servlet đích nếu có quyền là manager hoặc admin
//				chain.doFilter(request, response);
//
//			} else {
//				resp.sendRedirect(req.getContextPath() + "/login");
//			}
//
//		} else {
//			// Trường hợp client (đã đăng nhập) muốn vào các trang khác thì accept
//			chain.doFilter(request, response);
//		}
//	}
//
//}
