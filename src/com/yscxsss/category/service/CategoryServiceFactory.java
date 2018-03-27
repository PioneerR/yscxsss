package com.yscxsss.category.service;

public class CategoryServiceFactory {
	
	private CategoryServiceFactory() {
	}
	private static CategoryService cs=null;
	public static CategoryService build() {
		if(cs==null){
			cs=new CategoryServiceImpl();					
		}
		return cs;
	}
	
}
