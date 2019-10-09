package com.myclass.service.impl;

import java.io.Serializable;

import com.myclass.service.GenericService;

public abstract class GenericServiceImpl<T, K extends Serializable> implements GenericService<T, K> {
//	@Autowired
//	protected GenericRepository<T, K> genericRepository;
//
//	public List<T> findAll() {
//		// TODO Auto-generated method stub
//		return genericRepository.FindAll();
//	}
//
//	public void add(T t) {
//		// TODO Auto-generated method stub
//		genericRepository.SaveOrUpdate(t);
//	}
//
//	public T findById(K id) {
//		// TODO Auto-generated method stub
//		return genericRepository.FindById(id);
//	}
//
//	public void removeById(K id) {
//		// TODO Auto-generated method stub
//		genericRepository.RemoveById(id);
//	}
//
//	public void update(T t) {
//		// TODO Auto-generated method stub
//		genericRepository.SaveOrUpdate(t);
//	}

}
