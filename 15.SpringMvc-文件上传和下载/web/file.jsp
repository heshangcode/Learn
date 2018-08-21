<%--
  Created by IntelliJ IDEA.
  User: CXK
  Date: 2018/8/16
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h2>单文件上传</h2>
<form action="upload01" method="post" enctype="multipart/form-data" id="uploadForm">
	标题：<input type="text" name="title">
	文件：<input type="file" name="myfile" id="myfile"><br>
	<button>文件上传</button>
</form>
<script type="text/javascript" src="resource/jquery.js"></script>
<script type="text/javascript">
    $(function () {
        //元素选择器
        $("button").click(function () {
            //1.获取上传文件的对象，是数组，获取的第一个
            var myfile = $("#myfile").prop("files")[0];
            //2.判断文件是否有
            if (myfile) {
                //3.获取文件名称
                var fileName = myfile.name;
                //4.获取文件的后缀名称
                var ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                //5.设置允许上传的文件后缀名称
                var allowFileTypes = ["jpg", "png", "gif", "jpeg", "dmp", "rar"];
                //6.设置一个标识，用来做判断
                var flag = false;
                //循环判断上传格式是否正确
                for (var i = 0; i < allowFileTypes.length; i++) {
                    if (ext == allowFileTypes[i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    alert("您上传的文件格式不正确，允许的格式为：" + allowFileTypes.join("  |  "));
                    return false;
                }
                //7.判断文件的大小
                if (myfile.size > 20 * 1024 * 1024) {
                    alert("您上传的文件过大，请重新选择")
                }
                return false;
                //8.表单提交
                ${"#uploadForm"}.submit();
            }
            else {
                alert("请选择您要上传的文件");
                return false;
            }
        })
    })
</script>
</body>
</html>
