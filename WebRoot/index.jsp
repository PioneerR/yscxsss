<%@page import="com.yscxsss.category.entity.Category"%>
<%@ page import="com.yscxsss.category.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML>
<html>
  <head>    
    <title>艺术创想</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="images/icon/yscx.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="css/base.css" />
  </head>  
  <body>
 
    <%
    	CategoryDao cd=new CategoryDaoImpl();
    	List<Category> cs=cd.getAllCategories();
    	for(Category c:cs){
    		out.println(c.getCategoryId()+"------"+c.getCategoryName());
    	}
    %>    
    
  </body>
</html>
