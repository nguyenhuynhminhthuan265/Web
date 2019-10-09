package com.myclass.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity(name = "courses")
public class Course {
	@Id
	private int id;

	@NotBlank(message = "Vui lòng nhập tiêu đề")
	private String title;

	// @NotBlank(message = "Vui lòng đăng hình ảnh")
	private String image;

	// @NotBlank(message = "Nhập số lượng bài học")
	@Min(value = 0, message = "Số bài học không được âm")
	@Column(name = "letures_count")
	private int leturesCount;

	@Min(value = 0, message = "giờ học >= 0")
	@Column(name = "hour_count")
	private int hourCount;

	@Column(name = "view_count")
	private int viewCount;

	@Min(value = 0, message = "giá tiền không được âm")
	private long price;

	private int discount;

	@Column(name = "promotion_price")
	private long promotionPrice;

	@NotBlank(message = "Vui lòng nhập mô tả")
	private String description;
	private String content;

	@Min(value = 0, message = "Vui lòng chọn danh mục bạn muốn học")
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "last_update")
	private Date lastUpdate;

	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	List<Video> videos;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Course() {
	}

	public Course(int id, String title, String image, int leturesCount, int hourCount, int viewCount, long price,
			int discount, long promotionPrice, String description, String content, int categoryId, Date lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.leturesCount = leturesCount;
		this.hourCount = hourCount;
		this.viewCount = viewCount;
		this.price = price;
		this.discount = discount;
		this.promotionPrice = promotionPrice;
		this.description = description;
		this.content = content;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLeturesCount() {
		return leturesCount;
	}

	public void setLeturesCount(int leturesCount) {
		this.leturesCount = leturesCount;
	}

	public int getHourCount() {
		return hourCount;
	}

	public void setHourCount(int hourCount) {
		this.hourCount = hourCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public long getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(long promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
