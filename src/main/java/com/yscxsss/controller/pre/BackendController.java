package com.yscxsss.controller.pre;

import com.yscxsss.pojo.User;
import com.yscxsss.service.category.CategoryService;
import com.yscxsss.service.user.UserService;
import com.yscxsss.util.EmptyUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backend")
public class BackendController{
	private Logger log=Logger.getLogger(BackendController.class);
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpSession session){	
		ModelAndView modelAndView=new ModelAndView();		
		
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
				if(user!=null && user.getType()==1){
					session.setAttribute("user", user);
					log.info("读取cookie成功，管理员登录成功");
					modelAndView.setViewName("/backend/index");
				}else{
					modelAndView.setViewName("/pre/login");
				}
			}
		}else{
			modelAndView.setViewName("/backend/index");
		}	
		return modelAndView;
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session,HttpServletRequest request,
				HttpServletResponse response){
		
		User user=(User)session.getAttribute("user");
		log.info(user.getLoginName()+"-----");
		if(EmptyUtils.isNotEmpty(user)){
			session.removeAttribute("user");
			Cookie[] cookie=request.getCookies();
			if(cookie.length>1){
				for(Cookie c:cookie){
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
				log.info("移除cookie成功");
			}
		}		
		return "redirect:/pre/index";
	}
	
}
