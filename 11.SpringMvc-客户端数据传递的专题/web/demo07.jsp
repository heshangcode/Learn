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
        //2.将该字符串传递到controller
		/*$.get("json01",{hs:jsonStr},function (data) {
		    //date是后台返回了一个JSON格式的字符串
		    alert(data);    //alert(data)弹出这个字符串全部，下面那个是把json对象转换为JavaScript字符串好取值
        })*/
		$.get("json01",{hs:jsonStr},function (data) {
		    //data转换一、或者加"json"
		    // alert(JSON.parse(data);
            alert(data);
            //取这个JavaScript字符串的某个值
            alert(data.role.role_name);
        },"json")
    });
</script>
</body>
</html>
