package com.yscxsss.service.category;

import com.yscxsss.dao.category.CategoryMapper;
import com.yscxsss.pojo.Category;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private List<Category> categories=new ArrayList();
	boolean flag=false;
	private Logger log=Logger.getLogger(CategoryServiceImpl.class);	
	private Object obj=null;
	
	@Autowired(required=false)	
	private CategoryMapper categoryMapper;
	
	@Transactional
	public boolean addCategory(Category c) {
		try {			
			int sqlNum=categoryMapper.addCategory(c);
			int i=1/0;
			if(sqlNum>0){
				flag=true;
			}			
		} catch (Exception e) {
			log.error(e);
		} 
		return flag;
	}

	public boolean deleteCategoryById(int categoryId) {
		try {
			int sqlNum=categoryMapper.deleteCategoryById(categoryId);
			if(sqlNum>0){
				flag=true;
			}		
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}
	

	public boolean updateCategory(Category c) {
		try {
			int sqlNum=categoryMapper.updateCategory(c);
			if(sqlNum>0){
				flag=true;
			}
		} catch (Exception e) {
			log.error(e);
		} 
		return flag;
	}
	
	@Transactional(readOnly=true)
	public List<Category> getAllCategories() {
		//TODO 

		return categories;
	}

	@Transactional(readOnly=true)
	public Category getCategoryById(int categoryId) {
		Category c=null;
		try {
			c=categoryMapper.getCategoryById(categoryId);
			//FIXME 
		} catch (Exception e) {
			log.error(e);
		}
		return c;
	}
	
	@Transactional(readOnly=true)
	public List<Category> getListCategoryByLevel(int level) {
		try {
			categories=categoryMapper.getListCategoryByLevel(level);
		} catch (Exception e) {
			log.error(e);
		}
		return categories;
	}
	
	@Test
	public void test() {
		Category c=new Category();
		c.setDescribe("aa");
		c.setLevel(2);
		c.setParentId(1);
		boolean flag=this.addCategory(c);
		System.out.println(flag);
	}
	

}
