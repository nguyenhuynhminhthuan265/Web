package com.myclass.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
//
//	public List<Category> findAll() {
//		// TODO Auto-generated method stub
//		return categoryRepository.FindAll();
//	}
//
//	public void add(Category category) {
//
//		category.setId(categoryRepository.FindAll().size() + 1);
//
//		categoryRepository.SaveOrUpdate(category);
//
//	}
//
//	public Category findById(int id) {
//		// TODO Auto-generated method stub
//		return categoryRepository.FindById(id);
//	}
//
//	public void update(Category category) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void removeById(int id) {
//		categoryRepository.RemoveById(id);
//
//	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public boolean insert(Category category) {
		// TODO Auto-generated method stub
		try {
			int id = categoryRepository.findAll().size();
			category.setId(id + 1);

			categoryRepository.save(category);
			// categoryRepository.myInsert(id, category.getTitle(), category.getIcon(),
			// category.getOrderIndex());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public boolean update(Category category) {
		try {
			categoryRepository.saveAndFlush(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

}
