<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	List<Category> categories=CategoryService.getInstance().getCategoriesGradeTwo();
	User u=(User)session.getAttribute("user");

	String action=request.getParameter("action");
	if(action !=null && action.equals("exit"))
	{
		session.invalidate();
		response.sendRedirect("/Gouwu/");
	}

	String url=request.getParameter("url");//确认--是从首页跳转到登录页面的
	if(action !=null && action.trim().equals("login"))
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//User u=null;		
		if(!username.equals("yscxadmin"))
		{
			try
			{
				u=User.check(username,password);
			}
			catch(UserNotFoundException e)
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:300px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#03a9f4;text-align:center;padding:8%;'>"+e.getMessage()+"</h2>");
				out.println("</div></div>");
				return;
			}
			catch(PasswordNotCorrectException e1)
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:300px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#03a9f4;text-align:center;padding:8%;'>"+e1.getMessage()+"</h2>");
				out.println("</div></div>");
				return;
			}
			session.setAttribute("user", u);
			
/*			//设置session时间为三个月           /////////////session+cookie实现自动登录暂缓+Index1.jsp
			String sessiontime=request.getParameter("cookietime");
			if(sessiontime!=null && sessiontime.equals("true"))//&&左边为假，右边不执行
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				HttpSession sess=request.getSession(true);//取消了session的持久化设置,sess实际上就是上面的session，只不过有了名字
				sess.setMaxInactiveInterval(90*24*3600);//设置session的时间为三个月
	System.out.println("create"+sess.getId());
				
				Cookie cookie=new Cookie("JSESSIONID",sess.getId());
					   cookie.setMaxAge(90*24*3600); 
				cookie.setDomain("C:/Users/Administrator/AppData/Local/Temp");
				cookie.setPath("C:/Users/Administrator/AppData/Local/Temp");
				response.addCookie(cookie);
			}*/
			
			//设置cookie时间为三个月 
			//只有用户页面写cookie，管理员页面需要输入密码
			String cookietime=request.getParameter("cookietime");
			if(cookietime!=null && cookietime.equals("true"))//&&左边为假，右边不执行
			{
				username=URLEncoder.encode(username);//对中文进行转码，cookie读取时只能读取英文
				Cookie cookun=new Cookie("username",username);//密码和账号都要写到cookie内
				Cookie cookpw=new Cookie("password",password);//由于cookie数组是存放在栈中，所以是先进后出，后进先出
				cookun.setMaxAge(90*24*3600);//先存放的username，取出时的角标反而是靠后的
				//cookun.setDomain("C:/Users/Administrator/AppData/Local/Temp");
				cookun.setPath("/");//设置根目录下的页面都可以访问该cookie
				cookpw.setMaxAge(90*24*3600);//后存放的password，取出时的角标反而靠前
				//cookpw.setDomain("C:/Users/Administrator/AppData/Local/Temp");
				cookpw.setPath("/");
				//System.out.println(cookun.getValue()+"---"+cookpw.getValue());
				response.addCookie(cookun);
				response.addCookie(cookpw);
			}
			
			if(url!=null && url.equals("index"))
			{	
				response.sendRedirect("/Gouwu/");
%>
			<script type="text/javascript">
				window.history.go(1);//表单提交相当于又一次页面请求，所以是回到上一个页面的上一个页面.进入上一个缓存页面，读取缓存
			</script>
<%			
			}
			else
			{
%>
			<script type="text/javascript">
				window.history.go(-2);
			</script>
<%
			}
		}
		else
		{
			if(!password.equals("123456"))
			{
				out.println("<div style='padding:10% 5% 5% 5%;box-shadow:0 0 10px #B5B4B4;border-radius:10px;width:80%;height:250px;margin-left:5%;margin-top:5%;'");
				out.println("<div style=''>");
				out.println("<h2 style='color:#ff9632;text-align:center;padding:0% 8%;'>");
				out.println("<img src='/Gouwu/images/icon/yscx.png' style='width:200px;height:auto;'/>");
				out.println("管理员密码输入错误~");
				out.println("</h2></div></div>");
				
				out.println("<a href='javascript:window.history.go(-1)' style='text-decoration:none;");
				out.println("background:#03a9f4;padding-bottom:5px;padding-top:5px;color:#fff;float:right;");
				out.println("margin:2% 5% 5% 5%;padding-left:30px;padding-right:30px;text-align:center;border-radius:5px;'>");
				out.println("返回</a>");
				return;
			}
			session.setAttribute("yscxadmin", "admin");
			//管理员获得权限别忘了写，因为后面的页面需要确认是否有管理员权限，会用到session
			response.sendRedirect("admin/AdminIndex1.jsp");	
		}
	}	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="/Gouwu/images/icon/yscx.ico" type="image/x-icon"/>
		<title>艺术创想</title>
		<link type="text/css" rel="stylesheet" href="/Gouwu/css/base.css" />
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
				background:url("/Gouwu/images/background/background.jpg") no-repeat;
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
		<div class="widpc100" style="position:fixed;top:0;height:70px;" id="nav">
			<nav style="" class="overfh">
				<div class="flol" style="margin-right:20px;margin-left:7%;">
					<a href="Index1.jsp" style="color:white;" class="fontw700">				
						<img src="/Gouwu/images/icon/yscx.png" class="wida" style="height:50px;">艺术创想
					</a>
				</div>
				
				<div class="itemshow flol wid100 textc" style="margin-top:17px; ">
					<a href="ShowProducts1.jsp" class="" style="color:#fff;">课程</a>
					<div class="itemhide" style="margin-left:18%;width:150px;padding-bottom:5px;">
					<%
						Category cg=categories.get(0);				
					%>		
						<a href="ShowProducts1.jsp?categoryId=<%= cg.getId() %>">
							<div class="item backgw borrt5 textc fonts16 colgy" style="line-height:37px;">
								<%= cg.getName() %>
							</div>
						</a>						
					<%						
						for(int i=1;i<categories.size()-1;i++)
						{							
							cg=categories.get(i);							
					%>	
						<a href="ShowProducts1.jsp?categoryId=<%= cg.getId() %>">
							<div class="item backgw textc fonts16 colgy" style="line-height:37px;">
								<%= cg.getName() %>
							</div>
						</a>
					<%
						}
							cg=categories.get(categories.size()-1);							
					%>
						<a href="ShowProducts1.jsp?categoryId=<%= cg.getId() %>" >
							<div class="item backgw borrb5 textc fonts16 colgy" style="line-height:37px;">
								<%= cg.getName() %>
							</div>
						</a>	
					</div>
				</div>
				
				<div class="itemshow flol wid100 textc" style="margin-top:17px;margin-left:45%; ">
					<a href="Buy1.jsp" class="" style="color:#fff;">
						<img src="/Gouwu/images/background/cart2.png" class="wida" style="height:22px;">
					</a>
					<div class="itemhide" style="width:150px;padding-bottom:5px; ">
						<a href="Buy1.jsp">
							<div class="item backgw textc fonts16 colgy borr5" style="line-height:37px;margin-right:15%;">
								查看购物车
							</div>
						</a>
					</div>
				</div>
				
		<%
			if(u==null)
			{
		%>	
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="Register1.jsp" style="color:white;">
						<img src="/Gouwu/images/icon/signup.png" class="wida" style="height:20px;margin-right:5px;">注册
					</a>
				</div>
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="UserLogin1.jsp" style="color:white;">
						<img src="/Gouwu/images/icon/signin.png" class="wida" style="height:20px;">登录
					</a>
				</div>
		<%
			}
			else
			{
		%>
				<div class="itemshow flol marlr15"  >
					<a href="" style="color:white;">
						<img src="/Gouwu/images/user/<%= u.getId()+".jpg" %>" class="wida" 
							 style="height:30px;width:30px;margin-right:5px;margin-top:25px;margin-bottom:-8px; "
							 onerror="javascript:this.src='/Gouwu/images/icon/user.png'">
						<%= u.getUsername() %>
					</a>
					<div class="itemhide" style="width:150px;padding-bottom:5px;">
						<a href="Orderstatus1.jsp">
							<div class="item borrt5 textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								我的订单
							</div>
						</a>
						<a href="Userinfo1.jsp">
							<div class="item textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								个人信息
							</div>
						</a>
						<a href="Index1.jsp?action=exit">
							<div class="item borrb5 textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								退出
							</div>
						</a>					
					</div>
				</div>
		<%
			}
		%>	
			</nav>
		</div>
	
		<div class="widpc100 heipc100 header">
	      <div class="widpc100 heipc100 header-filter">	
	            
	          <form class="heia borr10 padtb30 boxsg backgw marlra marpc15 colb textc fonts18 letters1" 
	          	    style="padding-bottom:0;overflow:hidden;width:300px;" method="post" action="UserLogin1.jsp">
		          <input type="hidden" name="action" value="login">	
		          <input type="hidden" name="url" value="<%= url %>">	    
		           	 用户登录<br>
		          <div class="flol" style="margin-left:30px;margin-right:5px; padding-top:20px; "> 	 
		          	<img src="/Gouwu/images/icon/email.png" />
		          </div>
		          <div class="flol widpc70" style="margin-right:15px;" > 
		          	<input type="text" name="username" placeholder="Email"/>
		          </div>		          
		          <div class="flol" style="margin-left:30px;margin-right:3px; padding-top:20px;"> 
		          	<img src="/Gouwu/images/icon/password.png" style="margin-right:3px;"/>
		          </div>
		          <div class="flol widpc70" style="margin-right:15px;"  > 	
		          	<input type="password" name="password" placeholder="登录密码" /><br>
		          </div>
		          <div class="flol" style="letter-spacing:0em;padding-left:33px;margin-top:14px;">
		          	<div class=" flol" style="margin-right:4px;">
		          		<input type="checkbox" class="checkbox" id="sessiontime" name="cookietime" value="true" />
		          		<label for="sessiontime"></label>	
		          	</div>
		          	<div class="textl fonts14 colgy flol" style="margin-left:2px;">
		          		记住我
		          	</div>		          	
		          </div>
		          <div class="fonts14 textr flor" style="letter-spacing:0em;margin-top:15px;">
		          	<a href="UserModify1.jsp" class="colgy padlr20" >忘记密码？</a>
		          </div>	
		          <div class="widpc100">          
			          <input type="submit" value="登录" class="flol backgb boxs5 colw borr25 padtb5 wid100 fonts16 martb20" 
			          		 style="border-bottom:none;margin-top:30;cursor:pointer;margin-left:35%;" />
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
	    			<td>贵贵</td>
	    			<td>123456</td>
	    		</tr>
	    	</table>
	    </div>    
	    	
	</body>
</html>