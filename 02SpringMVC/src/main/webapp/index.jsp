<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--引入css文件-->
    <style type="text/css">
        @import url("statics/css/style.css");
    </style>
</head>
<body>
<%--  当用户点击hello的时候，
 01.web.xml文件中配置的核心控制器会拦截这个请求
 02.然后根据url的映射去核心配置文件中查询有没有对应的bean--%>
<a href="/hello">Holle</a>
<img src="statics/images/cat.jpg" height="100px" width="100px"/>
<!-- 静态资源访问-->
<script type="text/javascript" src="statics/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        alert("大猫猫");
    })
</script>

</body>


</html>
