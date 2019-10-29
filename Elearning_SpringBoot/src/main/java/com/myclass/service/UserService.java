package com.myclass.service;

import java.util.List;
import java.util.Optional;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;

public interface UserService {

	public void add(User user);

	boolean updatePassword(ChangePassword changePassword);

	List<User> findAll();

	Optional<User> findById(String id);

	boolean insert(User entity);

	public void update(User user);

	void delete(String id);

	public User findByEmail(String email);

}
