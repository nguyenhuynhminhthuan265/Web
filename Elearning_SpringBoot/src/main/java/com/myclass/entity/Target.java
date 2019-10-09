package com.myclass.entity;

public class Target {
	private int id;
	private String title;
	private int orderIndex;
	private int courseId;
	
	public Target() {}

	public Target(int id, String title, int orderIndex, int courseId) {
		super();
		this.id = id;
		this.title = title;
		this.orderIndex = orderIndex;
		this.courseId = courseId;
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

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
