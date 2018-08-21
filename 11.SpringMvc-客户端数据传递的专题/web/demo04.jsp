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
<h2>超链接传递数组</h2>
<a href="client04?role_id=100&role_id=200&role_id=300">传递数组</a>
<h2>复选框传递数组</h2>
<form action="client05">
	<input type="checkbox" name="hobby" value="basketball">篮球
	<input type="checkbox" name="hobby" value="football">足球
	<input type="checkbox" name="hobby" value="book">看书
	<button>简写方式</button>
</form>
<h2>文本框传递数组</h2>
<form action="client06">
	<input type="text" name="hobby">
	<input type="text" name="hobby">
	<button>简写方式</button>
</form>
<h2>多选列表</h2>
<form action="client07">
	<select name="hobby" multiple="multiple">
		<option value="music">音乐</option>
		<option value="book">看书</option>
		<option value="football">足球</option>
	</select>
	<button>简写方式</button>
</form>
</body>
</html>
