package com.yscxsss.product.entity;


import com.yscxsss.category.entity.Category;

import java.util.Date;

public class Product {

	private int productId;
	private String productName;
	private String describe;
	private double normalPrice;
	private double memberPrice;
	private Date productDate;
	private int categoryId;
	private Category category;
	
	
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public double getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}
	public double getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(double memberPrice) {
		this.memberPrice = memberPrice;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
	
	
}
