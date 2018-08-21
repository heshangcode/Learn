<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/11
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<%--
	为了支持其他的请求方式，把method都改为post，然后加入一个
	<input type="hidden" name="_method" value="get|post|put|delete|patch">
	value不分大小写，name=xxx固定
--%>
	<h2>get请求</h2>
	<form action="http/user" method="post">
		<button>get请求</button>
		<input type="hidden" name="_method" value="get">
	</form>
	<h2>post请求</h2>
	<form action="http/user" method="post">
		<button>post请求</button>
		<input type="hidden" name="_method" value="post">
	</form>
	<h2>delete请求</h2>
	<form action="http/user" method="post">
		<button>delete请求</button>
		<input type="hidden" name="_method" value="delete">
	</form>
	<h2>put请求</h2>
	<form action="http/user" method="post">
		<button>put请求</button>
		<input type="hidden" name="_method" value="put">
	</form>
	<h2>patch请求</h2>
	<form action="http/user" method="post">
		<button>patch请求</button>
		<input type="hidden" name="_method" value="patch">
	</form>
</body>
</html>
