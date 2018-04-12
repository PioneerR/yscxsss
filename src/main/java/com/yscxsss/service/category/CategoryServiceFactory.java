package com.yscxsss.service.category;

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
