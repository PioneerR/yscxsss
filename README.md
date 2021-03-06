## 项目名称：艺术创想儿童绘画网站-SSM改造项目
网站链接：www.yscxsss.com    在登录页面右下角有登录使用的账号密码，欢迎登录体验。

### **项目简介**
该项目是一个创业项目，主要用于学生家长给自家孩子报名美术类的相关课程，获取校方的最新资讯，查询孩子在学校的表现情况，以及让校方能高校管理学校学生方面的数据信息。同时，有效宣传校方实力，扩大机构的影响力，为学校吸引更多用户打开一个入口。

### **开发流程**
	1. 项目需求分析  
	2. 架构分析与设计  
	3. 物理架构  
	4. 技术方案确定  

### **项目基本功能**
	1、用户页面
	   a、用户注册、登录、退出功能  
	   b、查询课程及详情功能  
	   c、课程报名、付款功能  
	   d、查询报名详情，取消报名功能  
	   e、用户个人信息修改功能  

	2、管理员页面
	   a、用户注册信息查询功能  
	   b、课程类别信息的增删改查功能，课程类别分级添加功能  
	   c、课程产品的上架、修改、删除、课程产品图片上传功能  
	   d、课程产品的搜索功能、高级搜索功能  
	   e、报名情况查询及状态修改功能  
	   f、报名情况统计功能  
  
	3、其他
	   a、前端整体界面设计  
	   b、分页功能  

### **MVC模式**
	1、Model模型层：采用Javabean、Service类、DAO接口、DAO实体类分层的模式来实现  
	2、View表现层：采用JSP、html、css等技术实现  
	3、Controller控制层：采用JavaScript、JQuery、Ajax等实现  
	4、数据库层：采用JDBC来实现对数据的操作  

### **开发工具及开发环境**
	1、Myeclipse  
	2、Tomcat  
	3、MySQL  
	4、Atom  
	5、Java SE  及 Java EE  

### **使用组件及技术使用**
	1、FileUpload组件  解决  用户头像上传及产品图片上传功能  
	2、JFreeChart组件  解决  报名情况统计功能  
	3、Ajax技术  解决  管理员页面修改产品价格  
	4、JQuery技术  解决  表单嵌套情况下的信息提交  
	5、HTML、CSS、JavaScript、JQuery、Ajax  解决  前端页面设计制作及交互  
	6、JSP、Servlet、JDBC、XML等  

### **使用表格数量**
	1、用户注册信息表  
	2、课程类别信息表  
	3、课程(产品)信息表  
	4、订单列表  
	5、订单详情表
	6、购物车信息表

### **后续开发计划**
	1、用户页面
	  * Ajax、正则表达式解决用户名的唯一性  
	  * 密码的格式检测，提高用户账户的安全性  
	  * 用户首页导航搜索功能  
	  * 校方的联系方式  
	  * 线上画廊  
	  * 将购物车数据写入数据库  
	  * 账号限制同时登录人数的唯一性  
	  * 用JavaScript给用户账号密码进行加密  
	  * 支付宝、微信支付接口串接  
	  * 忘记密码，修改密码功能  
	  
	2、管理员页面
	  * 用户列表排序  
	  * AJAX更改用户数据  
	  * 校园档案库  
	  * 统计当前登录人数
	  
	3、性能优化
	  * 解决路径的耦合性、类的耦合性、文件名等的耦合性问题  
	  * 解决图片格式耦合性问题  
	  * 优化相同代码的书写  
	  * 并发访问  
	  * 缓存技术  
	  * 提高网页加载速度，尤其是图片加载速度  

