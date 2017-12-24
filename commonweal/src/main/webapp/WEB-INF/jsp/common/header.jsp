<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>云公益头部</title>
    <link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=basePath%>/static/css/header.css" rel="stylesheet"/>
    
</head>
<style>

</style>
<body>
<nav style="background-color: #B31800" id="header" class="navbar  navbar-fixed-top my-navbar">
    <div class="navbar-header">
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <!--<img class="navbar-brand " src="image/public/LOGO.png" style="width: 8rem">-->
        <a style="color: white;margin-top: 2px" href="<%=basePath%>/main.html"  class="navbar-brand">首页</a>
        <a class="navbar-brand" style="color: white"  ><span class="glyphicon glyphicon-map-marker" ></span>地区》郑州</a>

    </div>
    <div  class="collapse navbar-collapse navbar-right">
        <ul id="header_hide"  class="nav navbar-nav">
            <li><input type="text"  style="float: left" />
                <a  class="navbar-brand" style='margin-top: 0.13em;font-family:"微软雅黑" '>全局搜索</a></li>
            <li><a class="" href="#"><span class="glyphicon glyphicon-bell"></span>通知</a></li>
            <li><a class="" href="#"><span class="glyphicon glyphicon-eye-close"></span>换肤</a></li>
            <li><a class="" href="#"><span class="glyphicon glyphicon-registration-mark"></span>注册</a></li>
            <li><a class="" href="#"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
        </ul>
    </div>
</nav>

<!--<script src="js/jquery-1.12.4.js"></script>
<script src="js/bootstrap.js"></script>-->
<script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 2) {
            $(".navbar-fixed-top").addClass("top-nav");

        }else {
            $(".navbar-fixed-top").removeClass("top-nav");
        }
    });
</script>
</body>
</html> 