package com.yscxsss.controller.pre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String name,
			@RequestParam String password,HttpSession session){
		
		
		
		return null;
	}
	
	//局部异常处理
	@ExceptionHandler(value={RuntimeException.class})
	public  String handlerException(RuntimeException e,HttpServletRequest request){
		request.setAttribute("exception", e);
		return "error";
	}
	
	
	
}
