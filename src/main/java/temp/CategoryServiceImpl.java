package temp;

import com.yscxsss.dao.category.CategoryMapper;
import com.yscxsss.entity.Category;
import com.yscxsss.service.category.CategoryService;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private List<Category> categories=new ArrayList();
	boolean flag=false;
	private Logger log=Logger.getLogger(CategoryServiceImpl.class);
	private SqlSession sqlSession=null;
	private Object obj=null;
	
	@Autowired(required=false)	
	private CategoryMapper categoryMapper;
	
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

	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

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
	

	public boolean updateCategory(Category c) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			int sqlNum=sqlSession.getMapper(CategoryMapper.class).updateCategory(c);
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
	
	
	public List<Category> getAllCategories() {
		//TODO 

		return categories;
	}

	
	public Category getCategoryById(int categoryId) {
		Category c=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			c=sqlSession.getMapper(CategoryMapper.class).getCategoryById(categoryId);
			//FIXME 
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return c;
	}
	
	
	public List<Category> getListCategoryByLevel(int level) {
		try {
			//sqlSession=MyBatisUtil.createSqlSession();
			//categories=sqlSession.getMapper(CategoryMapper.class).getListCategoryByLevel(level);
			categories=categoryMapper.getListCategoryByLevel(level);
		} catch (Exception e) {
			log.error(e);
		} finally {
			//MyBatisUtil.closeSqlSession(sqlSession);
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
