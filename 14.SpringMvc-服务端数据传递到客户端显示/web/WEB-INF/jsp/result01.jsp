<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/15
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>数据获取方式</h2>
<h2>${requestScope.hs}</h2>
<h2>${requestScope["class"]}</h2>
<h2>${number} ---默认情况下是从pageContext->request->session->application下开始寻找</h2>
</body>
</html>
