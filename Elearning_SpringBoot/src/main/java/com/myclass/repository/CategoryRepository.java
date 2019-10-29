package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
//	public void SaveOrUpdate(Category category);
//
//	public List<Category> FindAll();
//
//	public Category FindById(int id);
//
//	public void RemoveById(int id);
//	@Modifying
//	@Query("insert into categories (id,title,icon,order_index) values (:id, :title, :icon, :orderIndex)")
//	public int myInsert(@Param("id") Integer id, @Param("title") String title, @Param("icon") String icon,
//			@Param("order_index") Integer orderIndex);
}
