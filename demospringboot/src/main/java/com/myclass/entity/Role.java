package com.myclass.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity(name = "roles")
public class Role {
	@Id
	private String id;
	
	@NotBlank(message = "Vui lòng nhập tên!")
	private String name;
	
	@NotBlank(message = "Vui lòng nhập mô tả!")
	private String description;
	
	@OneToMany(mappedBy = "role",
			fetch = FetchType.LAZY)
	private List<User> users;

	public Role() {
	}

	public Role(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
