<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div class="widpc100" style="position:fixed;top:0;height:70px;" id="nav">
		<nav style="" class="overfh">
			<div class="flol" style="margin-right:20px;margin-left:7%;">
				<a href="index.jsp" style="color:white;" class="fontw700">				
					<img src="${ctx}/statics/images/icon/yscx.png" class="wida" style="height:50px;">艺术创想
				</a>
			</div>
			
			<div class="itemshow flol wid100 textc" style="margin-top:17px; ">
				<a href="showProducts.jsp" class="" style="color:#fff;">课程</a>
				<div class="itemhide" style="margin-left:18%;width:150px;padding-bottom:5px;">
		
					<a href="showProducts.jsp?categoryId=<c:out value='${c.id}'/>">
						<div class="item backgw borrt5 textc fonts16 colgy" style="line-height:37px;">								
							<c:out value="${c.name}"/>
						</div>
					</a>						
				
				<c:forEach var="category" items="${categories}" 
								begin="1" end="${categories.size()-2}" >		
					<a href="showProducts.jsp?categoryId=<c:out value='${category.id}'/>">
						<div class="item backgw textc fonts16 colgy" style="line-height:37px;">
							<c:out value="${category.name}"/>
						</div>
					</a>
				</c:forEach>
				
					<a href="showProducts.jsp?categoryId=<c:out value='${cg.id}'/>" >
						<div class="item backgw borrb5 textc fonts16 colgy" style="line-height:37px;">
							<c:out value='${cg.name}'/>
						</div>
					</a>	
				</div>
			</div>
			
			<div class="itemshow flol wid100 textc" style="margin-top:17px;margin-left:45%; ">
				<a href="buy.jsp" class="" style="color:#fff;">
					<img src="${ctx}/statics/images/background/cart2.png" class="wida" style="height:22px;">
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
					<a href="../pre/register" style="color:white;">
						<img src="${ctx}/statics/images/icon/signup.png" class="wida" style="height:20px;margin-right:5px;">注册
					</a>
				</div>
				<div class="flol marlr15" style="margin-top:25px;" >
					<a href="${ctx}/user/login" style="color:white;">
						<img src="${ctx}/statics/images/icon/signin.png" class="wida" style="height:20px;">登录
					</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="itemshow flol marlr15"  >
					<a href="" style="color:white;">
						<img src="${ctx}/statics/images/user/${sessionScope.user.id}.jpg" class="wida" 
							 style="height:30px;width:30px;margin-right:5px;margin-top:25px;margin-bottom:-8px;"
							 onerror="javascript:this.src='${ctx}/statics/images/icon/user.png'">
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
						<a href="${ctx}/user/exit">
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
	<script type="text/javascript" src="${ctx}/statics/js/jquery-1.8.2.min.js"></script>
	<!-- <script type="text/javascript">
		function exit(){
			$.ajax({
				"url":"${ctx}/user/exit",
				"method":"post",				
				"dataType":"json",
				"success":function(data){
					var obj=eval("("+data+")");
					if(obj.info=="success"){
						window.location.reload();
					}else{
						alert("注销失败");
					}
				}				
			});
		}	
	</script> -->