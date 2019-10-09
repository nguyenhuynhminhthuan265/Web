package com.myclass.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Optional<Role> findById(String id) {
		return roleRepository.findById(id);
	}

	public boolean insert(Role entity) {
		try {
			String id = UUID.randomUUID().toString();
			entity.setId(id);
			roleRepository.save(entity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Role entity) {
		try {
			roleRepository.save(entity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void delete(String id) {
		roleRepository.deleteById(id);
	}

	
}
