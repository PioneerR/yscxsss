package temp;

import com.yscxsss.service.category.CategoryService;
import com.yscxsss.service.category.CategoryServiceImpl;

public class CategoryServiceFactory {
	
	private CategoryServiceFactory() {
	}
	private static CategoryService cs=null;
	public static CategoryService getInstance() {
		if(cs==null){
			cs=new CategoryServiceImpl();					
		}
		return cs;
	}
	
}
