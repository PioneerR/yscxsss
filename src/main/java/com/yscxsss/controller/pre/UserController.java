package com.yscxsss.controller.pre;

import com.alibaba.fastjson.JSON;
import com.yscxsss.pojo.Category;
import com.yscxsss.pojo.User;
import com.yscxsss.service.category.CategoryService;
import com.yscxsss.service.user.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger log=Logger.getLogger(IndexController.class);
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("pre/login");
		
		List<Category> list=categoryService.getListCategoryByLevel(2);
		modelAndView.addObject("categories", list);		
		
		//获取第一个类别，样式不同，单独取出
		Category c=list.get(0);
		modelAndView.addObject("c",c);
		
		//获取最后一个类别，样式不同，单独取出
		Category cg=list.get(list.size()-2);
		modelAndView.addObject("cg",cg);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestParam String loginName,@RequestParam String cookieTime,
					@RequestParam String password,HttpSession session,HttpServletResponse response){
		
		Map map=new HashMap();
		String info=null;
		User user=userService.loginCheck(loginName, password);
		if(user!=null && user.getType()==0){
			session.setAttribute("user", user);
			
			map.put("info", "userLogin");
			info=JSON.toJSONString(map);
			System.out.println("用户上线了！");
		}else if(user!=null && user.getType()==1){
			session.setAttribute("user", user);
			map.put("info", "adminLogin");
			info=JSON.toJSONString(map);
			System.out.println("管理员上线了！");			
		}else{
			map.put("info", "error");
			info=JSON.toJSONString(map);
		}
		
		//cookieTime为真，写入cookie
		if(cookieTime.equals("true")){
			//限制登录名为英文和数字等的组合，就不需要考虑转码的问题了
			try {
				//对中文进行转码，cookie读取时只能读取英文
				loginName=URLEncoder.encode(loginName,"UTF-8");
			} catch (UnsupportedEncodingException e) {				
				log.info("用户名转码出错");
			}
			
			
			//密码和账号都要写到cookie内
			Cookie cookun=new Cookie("loginName",loginName);
			//由于cookie数组是存放在栈中，所以是先进后出，后进先出
			Cookie cookpw=new Cookie("password",password);
			//先存放的username，取出时的角标反而是靠后的
			cookun.setMaxAge(90*24*3600);
			//cookun.setDomain("C:/Users/Administrator/AppData/Local/Temp");
			//设置根目录下的页面都可以访问该cookie
			cookun.setPath("/");
			//后存放的password，取出时的角标反而靠前
			cookpw.setMaxAge(90*24*3600);
			//cookpw.setDomain("C:/Users/Administrator/AppData/Local/Temp");
			cookpw.setPath("/");
			//System.out.println(cookun.getValue()+"---"+cookpw.getValue());
			response.addCookie(cookun);
			response.addCookie(cookpw);
			log.info("将用户名密码写入cookie");
		}
		
		return info;
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session,HttpServletRequest request,
				HttpServletResponse response){
		
		if((User)session.getAttribute("user")!=null){
			session.removeAttribute("user");
			
			//移除cookie
			Cookie [] cookies=request.getCookies();
			if(cookies.length>1){
				for(int i=0;i<cookies.length;i++){
					//移除cookie
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					response.addCookie(cookies[i]);
				}
			}	
			log.info("移除cookie成功");
		}
		//<a>中请求处理后，到新页面，需要再次发送一个新请求
		return "redirect:/pre/index";
	}
	
	//局部异常处理
	@ExceptionHandler(value={RuntimeException.class})
	public  String handlerException(RuntimeException e,HttpServletRequest request){
		request.setAttribute("exception", e);
		return "error";
	}
	
	
	/*<%
	
	if(action !=null && action.trim().equals("login"))
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//User u=null;		
		if(!username.equals("yscxadmin"))
		{
			try
			{
				u=User.check(username,password);
			}
			catch(UserNotFoundException e)
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:300px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#03a9f4;text-align:center;padding:8%;'>"+e.getMessage()+"</h2>");
				out.println("</div></div>");
				return;
			}
			catch(PasswordNotCorrectException e1)
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:300px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#03a9f4;text-align:center;padding:8%;'>"+e1.getMessage()+"</h2>");
				out.println("</div></div>");
				return;
			}
			session.setAttribute("user", u);
			
			//设置session时间为三个月           /////////////session+cookie实现自动登录暂缓+Index1.jsp
			String sessiontime=request.getParameter("cookietime");
			if(sessiontime!=null && sessiontime.equals("true"))//&&左边为假，右边不执行
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				HttpSession sess=request.getSession(true);//取消了session的持久化设置,sess实际上就是上面的session，只不过有了名字
				sess.setMaxInactiveInterval(90*24*3600);//设置session的时间为三个月
	System.out.println("create"+sess.getId());
				
				Cookie cookie=new Cookie("JSESSIONID",sess.getId());
					   cookie.setMaxAge(90*24*3600);
				cookie.setDomain("C:/Users/Administrator/AppData/Local/Temp");
				cookie.setPath("C:/Users/Administrator/AppData/Local/Temp");
				response.addCookie(cookie);
			}
			
			

		else
		{
			if(!password.equals("123456"))
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:250px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#ff9632;text-align:center;padding:0% 8%;'>");
				out.println("<img src='${ctx}/statics/images/icon/yscx.png' style='width:200px;height:auto;'/>");
				out.println("管理员密码输入错误~");
				out.println("</h2></div></div>");
				
				out.println("<a href='javascript:window.history.go(-1)' style='text-decoration:none;");
				out.println("background:#03a9f4;padding-bottom:5px;padding-top:5px;color:#fff;float:right;");
				out.println("margin:2% 5% 5% 5%;padding-left:30px;padding-right:30px;text-align:center;border-radius:5px;'>");
				out.println("返回</a>");
				return;
			}
			session.setAttribute("yscxadmin", "admin");
			//管理员获得权限别忘了写，因为后面的页面需要确认是否有管理员权限，会用到session
			response.sendRedirect("admin/AdminIndex1.jsp");	
		}
	}	
%>*/
	
	
	
	
	
}
