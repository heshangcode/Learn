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
<h2>简单对象数据传递：传递的名称(name)为类中的属性名字一样即可</h2>
<form action="client08">
	姓名：<input type="text" name="user_name">
	性别：<input type="text" name="sex">
	<button>提交数据</button>
</form>
<h2>多个对象</h2>
<form action="client09">
	姓名：<input type="text" name="user_name">
	性别：<input type="text" name="sex">
	角色名称：<input type="text" name="role_name">
	<button>提交数据</button>
</form>
<h2>多个对象进行关联方式一:后台处理</h2>
<form action="client10">
	姓名：<input type="text" name="user_name">
	性别：<input type="text" name="sex">
	角色名称：<input type="text" name="role_name">
	<button>提交数据</button>
</form>
<h2>多个对象进行关联方式二：前台处理</h2>
<form action="client11">
	姓名：<input type="text" name="user_name">
	性别：<input type="text" name="sex">
	角色名称：<input type="text" name="role.role_name"><%--name=类中.属性--%>
	<button>提交数据</button>
</form>

<h2>不同对象同属性传递借助第三方类</h2>
<form action="client12">
	<h3>用户</h3>
	姓名：<input type="text" name="user.user_name">
	性别：<input type="text" name="user.sex">
	角色信息：<input type="text" name="user.role.role_name">
	<h3>学生</h3>
	姓名：<input type="text" name="student.user_name">
	性别：<input type="text" name="student.sex">
	<button>提交数据</button>
</form>
<h2>如果是Map属性也是借助第三方类</h2>
<form action="client13">
	姓名：<input type="text" name="query['user_name']"<%--属性['需要设置的key值']--%>>
	性别：<input type="text" name="query['sex']">
	<button>提交数据</button>
</form>
<h2>传递List也是借助第三方类</h2>
<form action="client14">
	姓名：<input type="text" name="studentList[0].user_name"> <%--设置第1条数据的user_name--%>
	性别：<input type="text" name="studentList[0].sex"><%--设置第1条数据的sex--%>
	<hr/>
	姓名：<input type="text" name="studentList[1].user_name"> <%--设置第2条数据的user_name--%>
	性别：<input type="text" name="studentList[1].sex">
	<hr/>
	姓名：<input type="text" name="studentList[5].user_name"> <%--设置第6条数据的user_name,同时也设置了这个list长度是6--%>
	性别：<input type="text" name="studentList[5].sex">
	<button>提交数据</button>
</form>
<h2>占位符传递数据</h2>
<a href="client15/11110/tomcat?sex=man">占位符传递数据</a>
<h2>占位符传递数据——可以直接使用Map来接收数据</h2>
<a href="client16/123/tomcat?sex=man">使用Map接收数据</a>
</body>
</html>
