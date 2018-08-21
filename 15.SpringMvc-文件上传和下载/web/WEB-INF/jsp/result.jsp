<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/17
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>直接超链接方式显示</h2>
<a href="upload/${newFileName }">${fileName }</a>
<h2>HTML5 中的download属性</h2>
<a href="upload/${newFileName }" download="${fileName }">${fileName }</a>
<h2>使用流的方法--到控制层处理</h2>
<a href="download?newFileName=${newFileName}&fileName=${fileName}">${fileName }下载</a>
</body>
</html>
