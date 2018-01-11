<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=basePath%>/static/main/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>/static/main/css/flexslider.css">
<link rel="stylesheet"
	href="<%=basePath%>/static/main/css/jquery.fancybox.css">
<link rel="stylesheet"
	href="<%=basePath%>/static/main/css/animate.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
<style>
</style>
</head>
<body>
	<header id="header" style="background-color: #3496D8;height:5em;">
	<div class="header-content clearfix" style="padding-top: 2em">
		<a class="logo" href="main.html">云公益</a>
		<nav class="navigation" role="navigation">
		<ul class="primary-nav">
			<li><a href="main.html">回到首页</a></li>
			<li><a href="welfare.html">全民公益</a></li>
			<li><a href="#">系统推送</a></li>
			<li><a href="index.html">进入后台</a></li>
			<li><a href="registerpage.html">注册</a></li>
			<li><a href="login.html">登录</a></li>
		</ul>
		</nav>
		<a href="#" class="nav-toggle">Menu<span></span></a>
	</div>
	</header>

</body>
</html>