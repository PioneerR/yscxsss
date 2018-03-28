package temp;

import com.yscxsss.category.dao.CategoryMapper;
import com.yscxsss.category.entity.Category;
import com.yscxsss.util.MyBatisUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {
	
	List<Category> list=new ArrayList<Category>();
	@Override
	public List<Category> getAllCategories() {
		String sql="category.CategoryMapper.getAllCategories";
		list=super.selectList(sql);
		return list;
	}
	
	private Logger log=Logger.getLogger("console");
	private SqlSession sqlSession=null;
	private Object obj=null;
	@Override
	public List<Category> getCategoriesByLevel(int level) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			list=sqlSession.getMapper(CategoryMapper.class).getCategoriesByLevel(level);
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return list;
	}

	@Override
	public int addCategory(Category c) {
		
		
		
		return 0;
	}

	@Override
	public int deleteCategoryById(int CategoryId) {
		
		
		
		return 0;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		
		
		
		return null;
	}

	

}
