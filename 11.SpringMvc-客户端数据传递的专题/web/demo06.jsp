<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/19
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<script type="text/javascript">
	//给对象赋值的几种方 式
    var obj = {
        user_name: "悟空",
        sex: "男",
        hobby: ["basktball", "football"],
        classInfo: {
            class_name: "计算机",
	        number:8
        }
    };
    obj.nickname = "齐天大圣";
    obj["age"] = 500;

    console.log(obj);

    //1.将JavaScript对象转换为JSON格式的字符串
    var jsonStr = JSON.stringify(obj);
    console.log(jsonStr);
    //2.将JSON格式的字符串转换为JavaScript对象
    var hs = JSON.parse(jsonStr);
    console.log(hs);
</script>

</body>
</html>
