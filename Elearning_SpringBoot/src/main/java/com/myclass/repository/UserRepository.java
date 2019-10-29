package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT u FROM users u WHERE u.email= :email ")
	User findByEmail(@Param("email") String email);

//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE users SET email= ?2, fullname= ?3, avatar= ?4, phone= ?5, address= ?6, website= ?7, facebook= ?8, role_id= ?9 WHERE id= ?1")
//	public void MyUpdate(String id, String email, String fullname, String avatar, String phone, String address,
//			String website, String facebook, String roleId);
}
