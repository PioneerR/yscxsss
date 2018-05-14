package com.yscxsss.controller;

import com.yscxsss.pojo.Category;
import com.yscxsss.service.category.CategoryService;

import java.util.List;

import javax.annotation.Resource;

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
	
	@RequestMapping("/index")
	public ModelAndView index(){	
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
		
		return modelAndView;
	}

}
