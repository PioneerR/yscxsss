package com.yscxsss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {


	private FilterConfig filterConfig;
	private String charset=null;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String initParam=filterConfig.getInitParameter("charset").trim();
		if(initParam != null && initParam.length()!=0){
			charset=initParam;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) {

		try {
			if(charset!=null){
				req.setCharacterEncoding(charset);
				res.setCharacterEncoding(charset);   
			}
			filterChain.doFilter(req,res);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {

	}
}