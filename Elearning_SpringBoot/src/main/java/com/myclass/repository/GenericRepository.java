package com.myclass.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface GenericRepository<T, K> {
	public void SaveOrUpdate(T t);

	public List<T> FindAll();

	public T FindById(K id);

	public void RemoveById(K id);
}
