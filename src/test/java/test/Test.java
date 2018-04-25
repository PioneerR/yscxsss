package test;

import com.yscxsss.entity.User;
import com.yscxsss.service.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//Spring整合mybatis的测试
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		UserService service=(UserService)context.getBean("userService");
		User u=service.getUserById(1);
		System.out.println("loginName:"+u.getLoginName());
		
	}

}
