package com.myclass.service;

import java.util.List;

public interface GenericService<T, K> {
	List<T> findAll();

	public void add(T t);

	public T findById(K id);

	public void update(T t);

	public void removeById(K id);
}
