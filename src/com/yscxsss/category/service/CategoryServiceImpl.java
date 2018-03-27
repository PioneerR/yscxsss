package com.yscxsss.category.service;

import com.yscxsss.category.dao.CategoryDao;
import com.yscxsss.category.dao.CategoryDaoImpl;
import com.yscxsss.category.entity.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=new ArrayList();
		CategoryDao cd=new CategoryDaoImpl();		
		categories=cd.getAllCategories();
		return categories;
	}

}
