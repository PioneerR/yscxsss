package com.yscxsss.product.service;


public class ProductServiceFactory {

	private ProductServiceFactory() {
	}
	private static ProductService ps=null;
	public static ProductService getInstance() {
		if(ps==null){
			ps=new ProductServiceImpl();					
		}
		return ps;
	}
}
