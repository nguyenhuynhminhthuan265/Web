package com.myclass.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository = null;

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

//
//	public void removeById(String id) {
//		userRepository.RemoveById(id);
//
//	}
	public void add(User user) {
		try {
			String id = UUID.randomUUID().toString();
			user.setId(id);
			// mã hóa mật khẩu
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			System.out.println("password encoding: " + hashed);
			user.setPassword(hashed);
			userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void update(User user) {
		System.out.println("ID EDIT: " + user.getId());
//		userRepository.MyUpdate(user.getId(), user.getEmail(), user.getFullname(), user.getAvatar(), user.getPhone(),
//				user.getAddress(), user.getWebsite(), user.getFacebook(), user.getRoleId());
		userRepository.saveAndFlush(user);

	}

	@Override
	public boolean insert(User user) {
		// Tạo Random Id
		try {
			String id = UUID.randomUUID().toString();
			user.setId(id);
			// mã hóa mật khẩu
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			user.setPassword(hashed);
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public void delete(String id) {

		userRepository.deleteById(id);

	}

	public boolean updatePassword(ChangePassword changePassword) {
		try {

			String hashed = BCrypt.hashpw(changePassword.getPassword(), BCrypt.gensalt(12));

			User user = userRepository.findByEmail(changePassword.getEmail());
			if (user != null) {
				user.setPassword(hashed);
			}

			userRepository.saveAndFlush(user);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public User findByEmail(String email) {
		try {
			User user = userRepository.findByEmail(email);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
