<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="${ctx}/statics/images/icon/yscx.ico" type="image/x-icon"/>
		<title>艺术创想</title>
		<link type="text/css" rel="stylesheet" href="${ctx}/statics/css/base.css" />
		<style type="text/css">
			td{
				text-align:center;
				border:3px solid #fff1cc;				
			}
			table{ border-collapse:collapse;}
			a{
				text-decoration: none;
			}
			.header{
				background:url("${ctx}/statics/images/background/background.jpg") no-repeat;
				background-position: 50% 40%;
				background-size:cover;
				position: absolute;
				top:0;
				left:0;
				z-index: -1;
			}
			.header-filter{
				background-color:rgba(0,0,0,0.2);
				position: absolute;
				top:0;
				left:0;
			}
			input{
			  color: #B5B4B4;
			  font-size: 16px;
			  width: 100%;
			  border: none;
			  border-bottom: solid #B5B4B4 1px;
			  margin: 6% 0 3% 0;
			  padding-bottom:10px; 
			}
			.boxs5{
				box-shadow:0 0 1px #B5B4B4;
				transition:all 0.6s;
			}
			.boxs5:hover {  
				box-shadow:0 0 10px #B5B4B4;
			} 
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
		
		<div class="widpc100 heipc100 header">
	      <div class="widpc100 heipc100 header-filter">	
	            
	          <form class="heia borr10 padtb30 boxsg backgw marlra marpc15 colb textc fonts18 letters1" 
	          	    style="padding-bottom:0;overflow:hidden;width:300px;" action="javascript:void(0)">
		          <input type="hidden" name="action" value="login">	
		          <%-- <input type="hidden" name="url" value="<%= url %>"> --%>	    
		           	 用户登录<br>
		          <div class="flol" style="margin-left:30px;margin-right:5px; padding-top:20px; "> 	 
		          	<img src="${ctx}/statics/images/icon/email.png" />
		          </div>
		          <div class="flol widpc70" style="margin-right:15px;" >
		          	<input type="text" id="loginName" name="loginName" placeholder="Email"/>
		          </div>		          
		          <div class="flol" style="margin-left:30px;margin-right:3px; padding-top:20px;"> 
		          	<img src="${ctx}/statics/images/icon/password.png" style="margin-right:3px;"/>
		          </div>
		          <div class="flol widpc70" style="margin-right:15px;"  > 	
		          	<input type="password" id="password" name="password" placeholder="登录密码" /><br>
		          </div>
		          <div class="flol" style="letter-spacing:0em;padding-left:33px;margin-top:14px;">
		          	<div class=" flol" style="margin-right:4px;">
		          		<input type="checkbox" class="checkbox" id="sessiontime" name="cookietime" value="true" />
		          		<label for="sessiontime" id="cookie"></label>
		          	</div>
		          	<div class="textl fonts14 colgy flol" style="margin-left:2px;">
		          		记住我
		          	</div>		          	
		          </div>
		          <div class="fonts14 textr flor" style="letter-spacing:0em;margin-top:15px;">
		          	<a href="UserModify1.jsp" class="colgy padlr20" >忘记密码？</a>
		          </div>
		          <div>
		          	<span id="info"></span>
		          </div>	
		          <div class="widpc100">          
			          <input type="submit" value="登录" class="flol backgb boxs5 colw borr25 padtb5 wid100 fonts16 martb20" 
			          		 style="border-bottom:none;margin-top:30;cursor:pointer;margin-left:35%;"
			          		 onclick="loginCheck();" />
		          </div>		 
	          </form>	  
			  
	      </div>
	    </div>	
	    
	    <div class="hei150 wid200 boxs10 backgw borr10 pad10 marlr20"
	         style="position:absolute;bottom:10px;right:-10px;">
	    	<div class="colb textc letters1" style="margin-bottom:20px;">欢迎体验</div>
	    	<table class="fonts14">
	    		<tr>
	    			<td style="width:100px;">管理员账号</td>
	    			<td style="width:100px;">密码</td>
	    		</tr>
	    		<tr>
	    			<td>yscxadmin</td>
	    			<td>123456</td>
	    		</tr>
	    		<tr>
	    			<td>用户账号</td>
	    			<td>密码</td>
	    		</tr>
	    		<tr>
	    			<td>guigui</td>
	    			<td>123456</td>
	    		</tr>
	    	</table>
	    </div>
	    <script type="text/javascript">
	    	function loginCheck(){
	    		var loginName=$("#loginName").val();
	    		var password=$("#password").val();
	    		
	    		if($("#sessiontime").attr("checked")){
	    			var cookieTime=true;	
	    		}else{
	    			var cookieTime=false;
	    		}
	    		$.ajax({
	    			"url":"${ctx}/user/loginCheck",
		    		"method":"post",
		    		"data":{
		    			"loginName":loginName,
		    			"password":password,
		    			"cookieTime":cookieTime
		    		},
		    		"dataType":"json",
		    		"success":function(data){
		    			var obj=eval("(" + data + ")");
		    			if(obj.info=="userLogin"){
		    				window.location.href="${ctx}/pre/index";
		    			}else if(obj.info=="adminLogin"){
		    				window.location.href="${ctx}/backend/index";
		    			}else{
		    				$("#info").html("用户名或密码错误");
		    			}		    			
		    		}
	    		});
	    	}
	    </script>    
	    	
	</body>
</html>