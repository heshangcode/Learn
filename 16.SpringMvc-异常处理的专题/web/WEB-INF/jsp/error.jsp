<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/18
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>${requestScope.message}</h2>
<a href="javascript:void(0)" id="debug">[DEBUG]</a>
<p id="error" style="display: none">
	${requestScope.ex}
</p>
<script>
    window.onload = function () {
        document.getElementById("debug").onclick = function () {
	        document.getElementById("error").style.display = "block";
        }
    }
</script>
</body>
</html>
