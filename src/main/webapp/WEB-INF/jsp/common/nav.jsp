<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <%!
	public int check(int a)
	{
		int n=0;
		if(a>10)
		{
			a=a-10;
			n++;
			check(a);//递归计算56中的整十数5
		}
		return n;
	}
%> --%>


<%-- <%	
	String actions=request.getParameter("action");
	if(actions !=null && actions.equals("exit"))
	{
		session.invalidate();
		response.sendRedirect("/Gouwu/");
		return;
	}
%> --%>

	<div class="widpc100 backgb" style="position:fixed;top:0;height:50px;
		 box-shadow:5px 5px 8px #B5B4B4,-5px 5px 8px #B5B4B4;" id="nav">
	  <nav style="" class="overfh">
		<div class="flol" style="margin-right:10%;margin-left:7%;">
			<a href="${ctx}/backend/index" style="color:white;" class="fontw700">				
				<img src="${ctx}/statics/images/icon/yscx.png" class="wida" style="height:30px;">艺术创想管理中心
			</a>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="${ctx}/backend/index" style="color:#fff;">首页</a>
			<div class="ishide " style="line-height:35px;">						
				<a href="${ctx}/pre/index">
					<div class="is colgy backgw" style="line-height:34px">用户首页</div>						
				</a>		
			</div>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="/Gouwu/admin/UserList1.jsp" style="color:#fff;">用户管理</a>
			<div class="ishide " style="line-height:35px;">						
				<a href="/Gouwu/admin/UserList1.jsp"  class=""  >
					<div class="is colgy backgw" style="line-height:34px">用户列表</div>						
				</a>		
			</div>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="/Gouwu/admin/CategoryList1.jsp" class="" style="color:#fff;">课程类别</a>
			<div class="ishide " style="line-height:35px;  ">						
				<a href="/Gouwu/admin/CategoryList1.jsp" >
					<div class="is colgy backgw"style="line-height:34px">类别列表</div>
				</a>		
			</div>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="/Gouwu/admin/ProductList1.jsp" style="color:#fff;">课程管理</a>
			<div class="ishide " style="line-height:35px;  ">						
				<a href="/Gouwu/admin/ProductList1.jsp">
					<div class="is colgy backgw"style="line-height:34px">课程列表</div>
				</a>
				<a href="/Gouwu/admin/ProductSearch1.jsp" class="" onclick="">
					<div class="is colgy backgw"style="line-height:34px">课程搜索</div>
				</a>
				<a href="/Gouwu/admin/ProductComplexSearch1.jsp" class="" onclick="">
					<div class="is colgy backgw"style="line-height:34px">高级搜索</div>
				</a>		
			</div>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="/Gouwu/admin/OrderList1.jsp" class="" style="color:#fff;">报名管理</a>
			<div class="ishide " style="line-height:35px;  ">						
				<a href="/Gouwu/admin/OrderList1.jsp">
					<div class="is colgy backgw"style="line-height:34px">报名列表</div>
				</a>		
			</div>
		</div>
		
		<div class="isshow flol textc" style="margin-top:0px;width:100px;padding-bottom:1px;">
			<a href="/Gouwu/servlet/SalesCountServlet" class="" style="color:#fff;">数据统计</a>
			<div class="ishide " style="line-height:35px;  ">						
				<a href="/Gouwu/servlet/SalesCountServlet">
					<div class="is colgy backgw"style="line-height:34px">分类统计</div>
				</a>		
			</div>
		</div>
	
		<c:choose>
			<c:when test="${empty user}">
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="/Gouwu/UserLogin1.jsp" style="color:white;">
						<img src="${ctx}/statics/images/icon/signin.png" class="wida" style="height:20px;">登录
					</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="itemshow flol" style="margin-top:0px;margin-left:10%;" >
					<a href="" style="color:white;">
						<img src="${ctx}/statics/images/icon/user.png" class="wida" 
							 style="height:20px;margin-right:5px;">
						管理员
					</a>
					<div class="itemhide" style="width:150px;padding-bottom:5px;">
						<a href="/Gouwu/admin/OrderList1.jsp">
							<div class="item borrt5 textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								待处理预报名
							</div>
						</a>
						<a href="${ctx}/backend/exit" >
							<div class="item borrb5 textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								退出
							</div>
						</a>					
					</div>
				</div>
			</c:otherwise>		
		</c:choose>	
	  </nav>
	 </div>
	
	