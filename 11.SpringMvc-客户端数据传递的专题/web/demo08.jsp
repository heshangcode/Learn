<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/19
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<script type="text/javascript" src="resource/jquery.js"></script>
<script type="text/javascript">
	$(function () {
		var obj = {
		    user_id:888,
			user_name:"悟空",
			sex:"男",
			role:{
		        role_name:"超级管理员"
			}
		};
		//1.JavaScript对象转换json格式字符串
        var jsonStr = JSON.stringify(obj);
        //2.使用原生的方式
		$.ajax({
			type:"POST",//必须为POST请求，如果你要传递JSON字符串
			url:"json02",
			data:jsonStr,
			dataType:"json",    //解析返回来的data数据的类型
			contentType: "application/json;charset=UTF-8",
			processData:false,
			success:function (data) {
                alert(data);
            }

		});

    });
</script>
</body>
</html>
