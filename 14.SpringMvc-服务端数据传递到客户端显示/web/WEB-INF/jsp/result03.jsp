<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/15
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>${requestScope.integer }</h2>
<h2>${requestScope.string }</h2>
<h2>${requestScope["double"] }-----因为double是关键字，所以不能.double</h2>
<h2>${requestScope.user.mydate }</h2>
<h2>${requestScope["user"]["mydate"] }</h2>
日期格式化
<fmt:formatDate value="${user.mydate }" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>
