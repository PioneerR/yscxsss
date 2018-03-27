<%@page import="com.yscxsss.category.service.CategoryServiceImpl"%>
<%@page import="com.yscxsss.category.service.CategoryService"%>
<%@ page import="com.yscxsss.category.entity.Category"%>
<%@ page import="com.yscxsss.category.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


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
    	CategoryService css=new CategoryServiceImpl();
    	List<Category> cs=css.getAllCategories();
    	request.setAttribute("cs", cs);
    %>   
    
    <c:if test="${not empty requestScope.cs}">
    	<c:forEach var="category" items="${cs}">
    		<c:out value="${category.categoryId}"></c:out><br>
    	</c:forEach>
    </c:if>
    
     
    
    
  </body>
</html>
