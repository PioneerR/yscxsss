package temp;

import com.yscxsss.dao.category.CategoryMapper;
import com.yscxsss.entity.Category;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
	
	List<Category> list=new ArrayList<Category>();
	
	public List<Category> getAllCategories() {
		String sql="category.CategoryMapper.getAllCategories";
		list=super.selectList(sql);
		return list;
	}
	
	private Logger log=Logger.getLogger("console");
	private SqlSession sqlSession=null;
	private Object obj=null;
	
	public List<Category> getListCategoryByLevel(int level) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			list=sqlSession.getMapper(CategoryMapper.class).getListCategoryByLevel(level);
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return list;
	}

	
	public int addCategory(Category c) {
		
		
		
		return 0;
	}

	
	public int deleteCategoryById(int CategoryId) {
		
		
		
		return 0;
	}

	
	public Category getCategoryById(int categoryId) {
		
		
		
		return null;
	}
	

}
