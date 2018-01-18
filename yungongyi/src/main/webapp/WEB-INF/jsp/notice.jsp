<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<html>
<base href="<%=basePath%>">
<head>
<title>启示大厅</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<style>
</style>
</head>

<body>

	<jsp:include page="common/header2.jsp"></jsp:include>
	<!-- <link href="/yungongyi/statics/noticehall/css/style.css"
		rel="stylesheet" type="text/css" media="all" /> -->
 <link rel="stylesheet"
		href="/yungongyi/statics/noticehall/css/noticehall.css" /> 
	<script src="/yungongyi/statics/public/js/public.js"
		type="text/javascript"></script>
	<div id="NoticeHall" class="container">
		<div>
			<div id="halloption" class="container ">
				<!-- 选择省市 -->
				<div class="row" style="margin-bottom: 3em">
					<div class="col-md-2 col-lg-2 col-xs-3 text-center">
						<span>选择省市：</span>
					</div>
					<div class="col-md-10 col-lg-10 col-xs-10 ">
						<select id="porvince">
						</select> <select id="city">
						</select>

					</div>
				</div>
				<!--选择区-->
				<div class="row">
					<div class="col-md-2 col-lg-2 col-xs-3 text-center">
						<span>地区：</span>
					</div>
					<div class="col-md-10 col-lg-10 col-xs-9 ">
						<ul id="area" class="area"></ul>
						<select class="phonearea"></select>
					</div>
				</div>
				<hr />
				<!--选择启示类型-->
				<div class="row">
					<div class="col-md-2 col-lg-2 col-xs-3 text-center">
						<span>类型：</span>
					</div>
					<div class="col-md-10 col-lg-10 col-xs-9 ">
						<ul class="type list-inline">
						</ul>

					</div>
				</div>
				<hr />
				<!--选择启示状态-->
				<div class="row">
					<div class="col-md-2 col-lg-2 col-xs-3 text-center">
						<span>状态：</span>
					</div>
					<div class="col-md-10 col-lg-10 col-xs-9 ">
						<ul class="state list-inline">
						</ul>
					</div>
				</div>
				<hr />
				<!--关键字搜索-->
				<div class="row">
					<div class="col-md-2 col-lg-2 col-xs-3 text-center">
						<span>关键字：</span>
					</div>
					<div class="col-md-8 col-lg-4 col-xs-9 text-left ">
						<div class="input-group keyword">
							<input type="text" class="form-control" placeholder="请输入启事关键词"
								name="describe" /> <span
								class="input-group-addon describesearch"> <span
								class="search glyphicon glyphicon-search"></span>
							</span>
						</div>
					</div>
				</div>
				<br />
			</div>
		</div>
	</div>

	<div class="main_bg">
		<div class="wrap">
			<div class="main">
				<div class="container">
					<div class="col-lg-12 col-md-12 col-xs-12">
						<span style="color: #A0A0A0; line-height: 30px;">时间↑</span>
					</div>
					<div id="ajaxNotice"></div>
					<!-- 分页系统 -->
					<div class="col-lg-12 col-md-12 col-xs-12 text-right">
						<div id="paging" style="color: gray;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="/yungongyi/statics/noticehall/js/getnotice.js"
		type="text/javascript"></script>
	<jsp:include page="common/footer2.jsp"></jsp:include>
</body>

</html>