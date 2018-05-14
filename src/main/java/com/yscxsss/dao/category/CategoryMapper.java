package com.yscxsss.dao.category;

import com.yscxsss.pojo.Category;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
	/**
	 * 添加类别
	 * @param c
	 * @return
	 */
	public int addCategory(Category c)throws SQLException;
	
	/**
	 * 根据id删除类别
	 * @param CategoryId
	 * @return
	 */
	public int deleteCategoryById(@Param("categoryId")Integer categoryId)throws SQLException;
	
	/**
	 * 更新类别
	 * @param c
	 * @return
	 */
	public int updateCategory(Category c)throws SQLException;
	
	/**
	 * 获取所有类别的集合
	 * @return
	 */
	public List<Category> getAllCategories()throws SQLException;
	
	/**
	 * 通过id获取类别
	 * @param categoryId
	 * @return
	 */
	public Category getCategoryById(@Param("categoryId")Integer categoryId)throws SQLException;
	
	/**
	 * 通过level获取类别集合
	 * @param level
	 * @return
	 */
	public List<Category> getListCategoryByLevel(@Param("level")Integer level)throws SQLException;
}
