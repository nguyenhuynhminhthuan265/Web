package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
//	public void SaveOrUpdate(Course course);
//
//	public List<Course> FindAll();
//
//	public Course FindById(int id);
//
//	public void RemoveById(int id);
}
