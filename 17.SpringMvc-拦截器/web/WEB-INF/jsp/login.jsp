<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
	<base/>标签解决路径问题
	参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
<h2>登录</h2>
<%--action的路径问题，sys/login绝对路径，login相对路径，因为请求转发到login.jsp,但是网址栏还是在sys这层，表单提交要到login那个，要不然就用相对路径，要不然就是绝对路径，相对直接login就行，绝对就是这样上面那一大堆--%>
<form action="sys/login" method="post">
	<input type="text" name="account">
	<button>登录</button>
</form>
</body>
</html>