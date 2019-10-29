package com.myclass.service;

import java.util.List;
import java.util.Optional;

import com.myclass.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	Optional<Category> findById(int id);
	boolean insert(Category category);
	boolean update(Category category);
	void delete(int id);
}
