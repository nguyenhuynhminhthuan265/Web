package com.myclass.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	public void add(User user) {
		// Tạo Random Id
		String id = UUID.randomUUID().toString();
		user.setId(id);
		userRepository.save(user);

	}

	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}
//
//	public void removeById(String id) {
//		userRepository.RemoveById(id);
//
//	}
//	public void add(User user) {
//		try {
//			String id = UUID.randomUUID().toString();
//			user.setId(id);
//			// mã hóa mật khẩu
//			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
//			user.setPassword(hashed);
//			userRepository.SaveOrUpdate(user);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}

	public void update(User user) {
		userRepository.save(user);

	}

	@Override
	public boolean updatePassword(ChangePassword changePassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User user) {
		// Tạo Random Id
		try {
			String id = UUID.randomUUID().toString();
			user.setId(id);
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

//	public boolean updatePassword(ChangePassword changePassword) {
//		try {
//			String hashed = BCrypt.hashpw(changePassword.getPassword(), BCrypt.gensalt(12));
//			User user = userRepository.findByEmail(changePassword.getEmail());
//
//			userRepository.Update(user);
//			return true;
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//	}
}
