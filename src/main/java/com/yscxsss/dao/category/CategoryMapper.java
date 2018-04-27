package com.yscxsss.dao.category;

import com.yscxsss.entity.Category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
	/**
	 * 添加类别
	 * @param c
	 * @return
	 */
	public int addCategory(Category c);
	
	/**
	 * 根据id删除类别
	 * @param CategoryId
	 * @return
	 */
	public int deleteCategoryById(@Param("categoryId")Integer categoryId);
	
	/**
	 * 更新类别
	 * @param c
	 * @return
	 */
	public int updateCategory(Category c);
	
	/**
	 * 获取所有类别的集合
	 * @return
	 */
	public List<Category> getAllCategories();
	
	/**
	 * 通过id获取类别
	 * @param categoryId
	 * @return
	 */
	public Category getCategoryById(@Param("categoryId")Integer categoryId);
	
	/**
	 * 通过level获取类别集合
	 * @param level
	 * @return
	 */
	public List<Category> getListCategoryByLevel(@Param("level")Integer level);
}
