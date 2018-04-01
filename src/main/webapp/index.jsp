<%@ page import="com.yscxsss.category.service.CategoryServiceFactory"%>
<%@ page import="com.yscxsss.category.service.CategoryServiceImpl"%>
<%@ page import="com.yscxsss.category.service.CategoryService"%>
<%@ page import="com.yscxsss.category.entity.Category"%>
<%@ page import="com.yscxsss.category.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE HTML>
<html>
  <head>    
    <title>艺术创想</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="images/icon/yscx.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="css/base.css" />
    <style type="text/css">
		.header{
		background:url("images/background/background.jpg") no-repeat;
		background-position: 50% 40%;
		background-size:cover;
		position: absolute;
		top:0;
		left:0;
		z-index:-1;
		}
		.title{
		text-shadow:10px 10px 20px #373638;
		font-size: 55px;
		font-weight: 600;
		}
		.header-filter{
		background-color:rgba(0,0,0,0.1);
		position: absolute;
		top:0;
		left:0;
		margin:0;
		}
		.title-text{
		font-size: 21px;
		text-align: center;
		text-shadow:10px 10px 20px #373638;
		}
		.button-1{
		 border:#F44336 solid;
		 border-radius:50px;
		 width: 100px;
		 text-align: right;
		 background: #F44336;
		 padding:10px;
		 padding-right: 20px;
		 margin: auto;
		 margin-bottom: 20px;			
		 transition:all 0.6s;
		}
		div.button-1:hover{
		 border:#F44336 solid;
		 border-radius:50px;
		 width: 100px;
		 text-align: right;
		 background: #F44336;
		 padding:10px;
		 padding-right: 20px;
		 margin: auto;
		 box-shadow:0px 0px 20px 0px #F44336;
		}
		.button-2{
		 width: 0px;
		 height: 0px;
		 padding:0px;
		 margin-left:15px;
		 float: left;
		 border-top: 10px solid transparent;
		 border-bottom: 10px solid transparent;
		 border-left: 20px solid #fff;
		}
		.section-top{
		margin: 40% 50px 0px ;
		box-shadow:10px 25px 15px #B5B4B4,
				  -10px 25px 15px #B5B4B4;
		z-index:1;
		}
		.section-mid{
		margin: 0px 50px 0px;
		padding: 10% 0%;
		box-shadow:10px 25px 15px #B5B4B4,
					-10px 25px 15px #B5B4B4;
		}
		.section-bottom{
		background:url("images/background/bottom.jpg")no-repeat;
		background-size:cover;
		background-position:50% 50%;
		margin: 0px 50px 50px;
		box-shadow:10px 25px 15px #B5B4B4,
					-10px 25px 15px #B5B4B4;
		}
		.section-photo{
		background: url("https://ws1.sinaimg.cn/large/006tKfTcly1fg2e1y440tj304g04g0nx.jpg")repeat;
		}
    </style>
    <script type="text/javascript">
    	window.onscroll=function()
    	{
    		var t=document.documentElement.scrollTop || document.body.scrollTop;
    		var nav=document.getElementById("nav");
    		if(t<=500)
    		{
    			nav.style.backgroundColor='rgba(50,170,220,-0.1)';
    			nav.style.boxShadow='none';
    		}
    		else
    		{
    			nav.style.backgroundColor='rgba(50,170,220,1)';//如果用双引号就会无效
    			nav.style.boxShadow='5px 5px 8px #B5B4B4,-5px 5px 8px #B5B4B4';
    		} 
    	}
    </script>
  </head>  
  <body>
    
    <%
    	//CategoryService cs=new CategoryServiceImpl();用以下工厂模式，降低耦合性
    	CategoryService cs=CategoryServiceFactory.build();
    	
    	List<Category> categories=cs.getCategoriesByLevel(2);//---------取出的类别必须是二级的类目，此处需要修改
    	//以下句子极其重要，否则无法取到categories极其长度
    	request.setAttribute("categories", categories);
    	
    	Category c=categories.get(0);
    	Category cg=categories.get(categories.size()-1);
    %>
	
    <div class="widpc100" style="position:fixed;top:0;height:70px;" id="nav">
			<nav style="" class="overfh">
				<div class="flol" style="margin-right:20px;margin-left:7%;">
					<a href="index.jsp" style="color:white;" class="fontw700">				
						<img src="images/icon/yscx.png" class="wida" style="height:50px;">艺术创想
					</a>
				</div>
				
				<div class="itemshow flol wid100 textc" style="margin-top:17px; ">
					<a href="showProducts.jsp" class="" style="color:#fff;">课程</a>
					<div class="itemhide" style="margin-left:18%;width:150px;padding-bottom:5px;">
			
						<a href="showProducts.jsp?categoryId=<c:out value='${c.categoryId}'/>">
							<div class="item backgw borrt5 textc fonts16 colgy" style="line-height:37px;">								
								<!--<c:out value="${c.categoryName}"/>-->
								<%= c.getCategoryName() %>
							</div>
						</a>						
					
					<c:forEach var="category" items="${requestScope.categories}" 
									begin="1" end="${requestScope.categories.size()-2}" >		
						<a href="showProducts.jsp?categoryId=<c:out value='${category.categoryId}'/>">
							<div class="item backgw textc fonts16 colgy" style="line-height:37px;">
								<c:out value="${category.categoryName}"/>
							</div>
						</a>
					</c:forEach>
					
						<a href="showProducts.jsp?categoryId=<c:out value='${cg.categoryId}'/>" >
							<div class="item backgw borrb5 textc fonts16 colgy" style="line-height:37px;">
								<!--<c:out value='${cg.categoryId}'/>-->
								<%= cg.getCategoryName() %>
							</div>
						</a>	
					</div>
				</div>
				
				<div class="itemshow flol wid100 textc" style="margin-top:17px;margin-left:45%; ">
					<a href="buy.jsp" class="" style="color:#fff;">
						<img src="images/background/cart2.png" class="wida" style="height:22px;">
					</a>
					<div class="itemhide" style="width:150px;padding-bottom:5px; ">
						<a href="buy.jsp">
							<div class="item backgw textc fonts16 colgy borr5" style="line-height:37px;margin-right:15%;">
								查看购物车
							</div>
						</a>
					</div>
				</div>				
		<c:choose>	
			<c:when test="${empty sessionScope.user}">
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="register.jsp" style="color:white;">
						<img src="images/icon/signup.png" class="wida" style="height:20px;margin-right:5px;">注册
					</a>
				</div>
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="userLogin.jsp?url=index" style="color:white;">
						<img src="images/icon/signin.png" class="wida" style="height:20px;">登录
					</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="itemshow flol marlr15"  >
					<a href="" style="color:white;">
						<img src="images/user/${sessionScope.user.userId}+'.jpg'" class="wida" 
							 style="height:30px;width:30px;margin-right:5px;margin-top:25px;margin-bottom:-8px; "
							 onerror="javascript:this.src='images/icon/user.png'">
						${sessionScope.user.userName}
					</a>
					<div class="itemhide" style="width:150px;padding-bottom:5px;">
						<a href="orderstatus.jsp">
							<div class="item borrt5 textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								我的订单
							</div>
						</a>
						<a href="userinfo.jsp">
							<div class="item textc backgw colgy fonts16" style="line-height:37px;margin-right:10%;">
								个人信息
							</div>
						</a>
						<a href="index.jsp?action=exit">
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
		
		<div class="widpc100 heipc100 header">
	      <div class="widpc100 heipc100 header-filter">
	          <div class="heia wida textc" style="padding-top:10%">
	            <h1 class="title coly" >与孩子有关的一切，都充满意义 </h1>
	            <p class="title-text coly">艺术创想，带孩子到属于他的绘画王国，与大师结盟，开启充满想象的艺术之旅</p>
	          </div>
	          
	          <div class="wid100" style="margin-left:46%;">
		          <a href="showProducts.jsp">
			          <div class="button-1">
			            <div class="button-2"></div>
			          	<div class="title-text colw" style="font-size:14px;">开始上课</div>
			          </div>
		          </a>
	          </div>
	      </div>
	    </div>

	    <div class="section-top section-photo borrt20 fonts30 padtbpc10">
	      <div class="heia widpc100">
	        <div class="heia wida textc colb">
	          <h3 style="margin:0px;">不仅要「教」，还要「育」</h3>
		        <p style="font-size:20px;" >
		          <br>根据孩子的天性及领先的教育理念，我们打造了科学高效的教学方法
		          <br>帮助孩子快乐学习，快速学会，全面提升综合素质
		          <br>同时，我们融入 “ 好奇心呵护计划 ”
		          <br>让孩子不仅学得好，学得快，学得更起劲
		        </p>
	        </div>
	      </div>
	    </div>

	    <div class="section-mid heipc100 wida backgw" style="overflow:hidden;">
	        <div class="heia widpc30 flol colb" 
	        	 style="margin-left:12%;margin-right:9%;margin-top:20px;">
	          <h3 style="margin:20px;" class="fonts30" >手把手教学</h3>
		        <p  style="font-size:20px;">
		          <br>以「学会」为原则的教程体系，第一件事就是绘画出完整作品。
		          <br>
		          <br>在教学的过程中，学会对构图设计、色理知识、绘画工具的精准掌握。
		          <br>
		          <br>我们的教学根据认知原理重塑，让孩子每一节课，都绘出一幅充满想象力的作品。
		        </p>
	        </div>
			<div class="flol" style="width:35%;" >
				<img src="images/background/11.jpg" style="width:100%;" class="borr15"/>
	        </div>
	    </div>


      <div  class="heia wida section-mid backgw" style="overflow:hidden;">
		<div style="margin-left:12%;margin-right:9%;width:35%" class="heia flol">
			<img src="images/background/22.jpg" class="widpc100 borr15" />
        </div>
        <div class="heia widpc30 flol colb" style="margin-top:70px; "> <!--块级宽度会影响排版-->
          <h3 style="margin:25px;" class="fonts30">学习游戏化</h3>
	        <p style="font-size:20px;">
	          <br>为什么学习不可以像游戏一样，让孩子沉迷上瘾呢？
	          <br>
	          <br>课程内容，将被设计成生动有趣的游戏，符合孩子充满好奇的天性。
	        </p>
        </div>
      </div>

	    <div class="section-mid heipc100 wida backgw" style="overflow:hidden;">
	  		<div class="heia widpc30 flol colb" style="margin-left:12%;margin-right:9%;">
	          <h3 style="margin-top:20px;" class="fonts30">全面辅导</h3>
		        <p style="font-size:20px;">
		          <br>一切的学习均是拼图游戏。
		          <br>
		          <br>每一次的课程，都让孩子获取更多的科普知识，拓展孩子的视野。
		          <br>
		          <br>每一次的课程，都让孩子获得一小片拼图，让孩子学习一次，运用千遍。
		          <br>
		          <br>同时，针对孩子不同的特点，老师以及助教会全程给予差异化教学。
		        </p>
	        </div>
			<div class="flol" style="width:35%">
				<img src="images/background/33.jpg" class="borr15" style="width:100%;"/>
	        </div>
	      </div>


	    <div class="section-mid section-photo" style="overflow:hidden;">
	        <div class="heia wida colb textc">
		       <h5 style="margin:0 0 50px 0;font-size:30px;">艺 术 创 想</h5>		
		       <div class="heipc70 wida fonts22 colb textl" 
		       	    style="padding-left:25%;padding-right:25%;" >
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					艺术创想致力于3-14岁幼少儿美术教育的研究开发及项目整体运营，
					我们希望与托辅机构及幼少儿教育培训机构达成战略合作伙伴关系，
					共同践行教育的本质，做面向未来的教育。
					<br><br>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				         艺术创想以创意美术为特色，为中国幼少儿提供完整的进阶课程体系，
				         致力于开发儿童观察力、想象力、创造力、专注力等，
				         强调对孩子“ 保护好奇心 ”的教育理念。 	
		       </div>
	        </div>
	    </div>
	    <div class="section-bottom borrb20 padtbpc10">
	    </div>
	    <div style="margin-bottom:50px;">
		    <a href="showProducts.jsp" class="boxs5 borr10 padtb10 backgw padlr20 fonts24 fontw700 textc" 
		    	style="margin-left:42%;color:#03a9f4;">马上开始绘画创作</a>
	    </div>
     
    <%@ include file="footer.html" %>
  </body>
</html>
