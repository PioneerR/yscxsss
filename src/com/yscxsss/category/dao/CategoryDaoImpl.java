package com.yscxsss.category.dao;


import com.yscxsss.category.entity.Category;
import com.yscxsss.util.MyBatisUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> getAllCategories() {
		List<Category> list=new ArrayList<Category>();
		
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			list=sqlSession.selectList("category.CategoryMapper.getAllCategoryList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
		Logger log=Logger.getLogger("console");
		return list;
	}

}
