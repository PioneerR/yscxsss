package test;

import com.yscxsss.entity.Category;
import com.yscxsss.service.category.CategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//Spring整合mybatis的测试
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		//UserService service=(UserService)context.getBean("userService");
		//User u=service.getUserById(1);
    	CategoryService cs=(CategoryService)context.getBean("categoryService"); 
    	Category c=new Category();
    	c.setDescribe("数学课");
    	c.setLevel(2);
    	c.setName("数学课");
    	c.setParentId(0);
    	boolean flag=cs.addCategory(c);
    	
    	if(flag){
    		System.out.println("添加类别成功");
    	}else{
    		System.out.println("添加类别失败");
    	}
    	
    	/*List<Category> categories=cs.getListCategoryByLevel(2);
    	if(categories.size()>0){
    		for(Category c:categories){
    			System.out.println("----"+c.getName());
    		}     		
    	}*/
		
		//System.out.println("loginName:"+u.getLoginName());
		
	}

}
