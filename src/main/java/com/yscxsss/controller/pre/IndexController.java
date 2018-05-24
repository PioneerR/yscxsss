package com.yscxsss.controller.pre;

import com.yscxsss.pojo.Category;
import com.yscxsss.pojo.User;
import com.yscxsss.service.category.CategoryService;
import com.yscxsss.service.user.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pre")
public class IndexController{
	//TODO 为controller写一个环绕增强
	private Logger log=Logger.getLogger(IndexController.class);
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpSession session){	
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		
		List<Category> list=categoryService.getListCategoryByLevel(2);
		modelAndView.addObject("categories", list);		
		
		//获取第一个类别，样式不同，单独取出
		Category c=list.get(0);
		modelAndView.addObject("c",c);
		
		//获取最后一个类别，样式不同，单独取出
		Category cg=list.get(list.size()-2);
		modelAndView.addObject("cg",cg);
		
		User u=(User)session.getAttribute("user");
		//读取cookie
		if(u==null){
			Cookie [] cookies=request.getCookies();		
			if(cookies!=null && cookies.length>1){
				String loginName=null;
				String password=null;
				for(int i=0;i<cookies.length;i++){
					String str=cookies[i].getName();
					if(str.equals("loginName")){
						loginName=cookies[i].getValue();
						//对中文用户名转回原码
						try {
							loginName=URLDecoder.decode(loginName,"UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					else if(str.equals("password")){
						password=cookies[i].getValue();
					}
				}
				User user=userService.loginCheck(loginName, password);
				if(user!=null){
					session.setAttribute("user", user);
					log.info("读取cookie成功，用户登录成功");
				}
			}
		}		
		return modelAndView;
	}

}
