<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/12
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>JAVA WEB阶段 服务端如何获取客户端的数据</h2>
<form action="client01" method="get">
	<input type="text" name="user_name"><br>
	<input type="checkbox" name="hobby" value="basketball">篮球
	<input type="checkbox" name="hobby" value="football">足球
	<input type="checkbox" name="hobby" value="book">看书
	<br>
	<button>传统模式</button>

</form>

</body>
</html>
