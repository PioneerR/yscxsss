package com.yscxsss.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/index")
public class IndexController{

	private Logger log=Logger.getLogger(IndexController.class);
	
	@RequestMapping("/toindex")
	public ModelAndView toindex(){	
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("SpringMvc");
		modelAndView.setViewName("index");	
		log.info("退出IndexController");
		return modelAndView;
	}

}
