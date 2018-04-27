package temp;

import com.yscxsss.entity.Category;

import java.util.List;

public interface CategoryDao {

	/**
	 * 增加类别
	 * @param c
	 * @return
	 */
	public int addCategory(Category c);
	
	/**
	 * 删除类别
	 * @param CategoryId
	 * @return
	 */
	public int deleteCategoryById(int CategoryId);
	
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
	public List<Category> getListCategoryByLevel(int level);
	

	
	
}
