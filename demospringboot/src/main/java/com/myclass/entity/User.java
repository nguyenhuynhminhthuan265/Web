package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class User {
	
	@Id
	private String id;
	
	@NotBlank(message = "Vui lòng nhập email!")
	@Email(message = "Email không đúng định dạng!")
	private String email;
	
	@NotBlank(message = "Vui lòng nhập họ tên!")
	private String fullname;
	
	private String password;
	
	private String avatar;
	private String phone;
	private String address;
	private String website;
	private String facebook;
	
	@Column(name = "role_id")
	@NotBlank(message = "Vui lòng chọn loại người dùng!")
	private String roleId;
	
	@ManyToOne()
	@JoinColumn(name = "role_id", 
		insertable = false, updatable = false)
	@JsonIgnore // layy user ma khong lay role
	private Role role;
	
	public User() {}

	public User(String id, String email, String fullname, String password, String avatar, String phone, String address,
			String website, String facebook, String roleId) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.website = website;
		this.facebook = facebook;
		this.roleId = roleId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
