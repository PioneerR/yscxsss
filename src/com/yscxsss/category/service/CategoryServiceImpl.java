package com.yscxsss.category.service;

import com.yscxsss.category.dao.CategoryMapper;
import com.yscxsss.category.entity.Category;
import com.yscxsss.util.MyBatisUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


public class CategoryServiceImpl implements CategoryService {

	private List<Category> categories=new ArrayList();
	boolean flag=false;
	private Logger log=Logger.getLogger("console");
	private SqlSession sqlSession=null;
	private Object obj=null;
	
	@Override
	public boolean addCategory(Category c) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			int sqlNum=sqlSession.getMapper(CategoryMapper.class).addCategory(c);
			if(sqlNum>0){
				flag=true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			log.error(e);
			sqlSession.rollback();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean deleteCategoryById(int categoryId) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			int sqlNum=sqlSession.getMapper(CategoryMapper.class).deleteCategoryById(categoryId);
			if(sqlNum>0){
				flag=true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			log.error(e);
			sqlSession.rollback();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}
	
	@Override
	public boolean updateCategory(Category c) {
		
		
		
		return false;
	}
	
	@Override
	public List<Category> getAllCategories() {
		//TODO 

		return categories;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category c=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			c=sqlSession.getMapper(CategoryMapper.class).getCategoryById(categoryId);
			//FIXME 如果c为null，怎么处理？
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return c;
	}
	
	@Override
	public List<Category> getCategoriesByLevel(int level) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			categories=sqlSession.getMapper(CategoryMapper.class).getCategoriesByLevel(level);
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return categories;
	}

	@Test
	public void test() {
	

	}


}
