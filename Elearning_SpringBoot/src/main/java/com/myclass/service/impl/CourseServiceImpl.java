package com.myclass.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
//	@Autowired
//	CourseRepository courseRepository;
//
//	public List<Course> findAll() {
//		// TODO Auto-generated method stub
//		return courseRepository.FindAll();
//	}
//
//	public void add(Course course) {
//		course.setId(courseRepository.FindAll().size() + 1);
//		courseRepository.SaveOrUpdate(course);
//	}
//
//	public Course findById(int id) {
//		// TODO Auto-generated method stub
//		return courseRepository.FindById(id);
//	}
//
//	public void update(Course course) {
//		// TODO Auto-generated method stub
//		courseRepository.SaveOrUpdate(course);
//	}
//
//	public void removeById(int id) {
//		// TODO Auto-generated method stub
//		courseRepository.RemoveById(id);
//	}
	@Autowired
	private CourseRepository courseRepository = null;

	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	public void add(Course course) {
		// Tạo Random Id
		int id = courseRepository.findAll().size() + 1;
		course.setId(id);
		courseRepository.save(course);

	}

	public Optional<Course> findById(int id) {
		return courseRepository.findById(id);
	}
//
//	public void removeById(String id) {
//		userRepository.RemoveById(id);
//
//	}
//	public void add(User user) {
//		try {
//			String id = UUID.randomUUID().toString();
//			user.setId(id);
//			// mã hóa mật khẩu
//			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
//			user.setPassword(hashed);
//			userRepository.SaveOrUpdate(user);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}

	public boolean update(Course course) {
		try {
			courseRepository.save(course);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean insert(Course course) {
		// Tạo Random Id
		try {
			int id = courseRepository.findAll().size() + 1;
			course.setId(id);
			courseRepository.save(course);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public void delete(int id) {

		courseRepository.deleteById(id);

	}

}
