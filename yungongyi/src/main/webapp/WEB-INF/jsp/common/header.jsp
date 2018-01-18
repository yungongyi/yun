<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String serverPath = "http://172.0.0.1:8080/commonweal/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/flexslider.css">
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/jquery.fancybox.css">
<link rel="stylesheet" href="/yungongyi/statics/main/css/main.css">
<link rel="stylesheet" href="/yungongyi/statics/main/css/responsive.css">
<link rel="stylesheet" href="/yungongyi/statics/main/css/font-icon.css">
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/animate.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<script src="/yungongyi/statics/public/js/public.js"
	type="text/javascript"></script>
<script src="/yungongyi/statics/public/js/bootstrap.min.js"></script>
</head>
<body>
	<header id="header">
	<div class="header-content clearfix">
		<!-- 声音引擎 -->
		<audio id="voice" autoplay="autoplay">
		<source id="voiceAudio" src='' /></audio>
		<a class="logo" href="../main.jsp">云公益</a>
		<nav class="navigation" role="navigation">
		<ul class="primary-nav">
			<li><a href="/yungongyi/" >首页</a></li>
			<li><a href="#services" >本站菜单</a></li>
			<li><a href="#content-3-10" >全站查找</a></li>
			<li><a href="#gallery">最新启事</a></li>
			<li><a href="#teams" >大厅广播</a></li>
			<li><a href="/yungongyi/registerpage.html" >注册</a></li>
			<li><a href="/yungongyi/login.html" >登录</a></li>
		</ul>
		</nav>
	</div>
	<a class="nav-toggle">Menu<span></span></a> </header>
</body>
</html>