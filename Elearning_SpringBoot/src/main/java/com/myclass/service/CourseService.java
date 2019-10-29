package com.myclass.service;

import java.util.List;
import java.util.Optional;

import com.myclass.entity.Course;

public interface CourseService {
//	List<Course> findAll();
//
//	public void add(Course course);
//
//	public Course findById(int id);
//
//	public void update(Course course);
//
//	public void removeById(int id);
	List<Course> findAll();

	Optional<Course> findById(int id);

	boolean insert(Course course);

	boolean update(Course course);

	public void add(Course course);

	void delete(int id);
}
