package com.myclass.service;

import java.util.List;
import java.util.Optional;

import com.myclass.entity.Role;

public interface RoleService {
	List<Role> findAll();
	Optional<Role> findById(String id);
	boolean insert(Role entity);
	boolean update(Role entity);
	void delete(String id);
}
