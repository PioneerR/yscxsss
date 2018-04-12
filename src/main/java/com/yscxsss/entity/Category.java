package com.yscxsss.entity;

public class Category {
	//TODO 暂时不知道这两个参数的用途，是否有优化方式
	public static final int MAX_GRADE=3;//最多三个级别
	public static final int LEVEL_LENGTH=2;//每个级别用两位数表示

	private int categoryId;
	private String categoryName;
	private String describe;
	private int level;
	
	//对应表字段pid
	private int parentId;
	//TODO 这里的categoryNo对应字段cno
	private int categoryNo;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
