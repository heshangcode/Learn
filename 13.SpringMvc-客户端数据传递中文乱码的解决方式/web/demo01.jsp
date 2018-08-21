<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/14
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>GET请求中文乱码-传统方式解决方案</h2>
<form action="client01" method="get">
	<input type="text" name="user_name">
	<button>GET请求</button>
</form>
<h2>GET请求中文乱码-修改tomcat服务里的sever.xml文件</h2>
<form action="client02" method="get">
	<input type="text" name="user_name">
	<button>GET请求</button>
</form>
<h2>POST请求中文乱码-在web.xml中配置过滤器</h2>
<form action="client03" method="post">
	<input type="text" name="user_name">
	<button>post请求</button>
</form>
</body>
</html>
