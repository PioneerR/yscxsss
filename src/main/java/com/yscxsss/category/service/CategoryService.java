package com.yscxsss.category.service;

import com.yscxsss.category.entity.Category;

import java.util.List;

public interface CategoryService {
	/**
	 * 增加类别
	 * @param c
	 * @return
	 */
	public boolean addCategory(Category c);
	
	/**
	 * 删除类别
	 * @param CategoryId
	 * @return
	 */
	public boolean deleteCategoryById(int categoryId);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean updateCategory(Category c);
	

	/**
	 * 查询所有类别
	 * @return
	 */
	public List<Category> getAllCategories();
	
	/**
	 * 根据类别id查询类别
	 * @param categoryId
	 * @return
	 */
	public Category getCategoryById(int categoryId);
	
	/**
	 * 根据level查询类别
	 * @param level
	 * @return
	 */
	public List<Category> getCategoriesByLevel(int level);
	
}
