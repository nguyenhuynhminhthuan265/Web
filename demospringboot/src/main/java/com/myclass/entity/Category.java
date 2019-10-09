package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "categories")
/* @Table */
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Vui lòng nhập tiêu đề!")
	private String title;
	@NotBlank(message = "Vui lòng nhập icon!")
	private String icon;
	
	@Column(name = "order_index")
	private int orderIndex;
	
	public Category() {}

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

