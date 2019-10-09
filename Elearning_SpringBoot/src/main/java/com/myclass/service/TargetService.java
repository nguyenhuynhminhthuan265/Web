package com.myclass.service;

import java.util.List;

import com.myclass.entity.Target;

public interface TargetService {
	List<Target> findAll();

	public void add(Target target);

	public Target findById(int id);

	public void update(Target target);

	public void removeById(int id);
}
