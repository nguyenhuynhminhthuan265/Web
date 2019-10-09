package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity(name = "categories")
public class Category {
	@Id
	private int id;

	@NotBlank(message = "Vui lòng nhập tiêu đề!")
	private String title;
	// @NotBlank(message = "Vui lòng nhập icon!")
	private String icon;

	@Column(name = "order_index")
	private int orderIndex;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Course> courses;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String title, String icon, int orderIndex) {
		super();
		this.id = id;
		this.title = title;
		this.icon = icon;
		this.orderIndex = orderIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
}
