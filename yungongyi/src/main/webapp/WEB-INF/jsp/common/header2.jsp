<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/bootstrap.min.css">
	<script src="/yungongyi/statics/public/js/jquery-1.12.4.js"></script>
<script src="/yungongyi/statics/public/js/bootstrap.min.js"></script>
<script src="/yungongyi/statics/public/js/public.js" type="text/javascript"></script>
<script src="/yungongyi/statics/horn/horn.js"></script>
<head> 

<style>
* {
	font-family: "微软雅黑"
}

@media all and (max-width: 768px) {
	.collapseout {
		display: inherit
	}
	.collapsein {
		display: none
	}
	#header_in {
		padding-left: 90%;
		padding-top: 0.5em;
		color: white;
		margin-bottom: 20%;
	}
	#header_out {
		border: none;
		background-color: transparent;
		color: white
	}
	#header_out:focus {
		background-color: transparent
	}
	#head_right>li>a {
		text-align: center;
		color: white;
		line-height: 2em;
		font-size: 2em
	}
}

@media all and (min-width: 767px) {
	#header_out, .collapseout {
		display: none
	}
	.collapsein {
		display: inherit
	}
	#header_in {
		display: none;
	}
	#head_right>li>a {
		text-align: center;
		color: white;
	}
}

#header_head {
	background-color: #3496D8;
	height: 5em;
	padding-top: 0.5em;
	margin-bottom:0;
}

img.navbar-brand {
	padding: 0
}

.header_allsilver {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0;
	background-color: rgba(0, 0, 0, 0.5)
}

#head_right>.header_zhuce {
	margin-top: 30%
}

#head_right {
	margin-top: 0
}
</style>
<body>
	<nav id="header_head" class="navbar navbar-default"  style="position: fixed;top:0;z-index:999999;width:100%" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<span id="header_out" onclick="out();"
				class="navbar-toggle glyphicon glyphicon-th-large"></span> <a
				href="#"><img class="navbar-brand"
				src="/yungongyi/statics/main/images/logo/LOGO.png"></a>
		</div>
		<ul id="head_right" class="collapsein nav navbar-nav navbar-right">
			<li id="header_in"><span onclick="ins();"
				class=" glyphicon glyphicon-remove"></span></li>
			<li><a href="/yungongyi/">回到首页</a></li>
			<li><a href="/yungongyi/notice.html/null">启事大厅</a></li>
			<li><a href="/yungongyi/welfare.html">全民公益</a></li>
			<li><a href="/yungongyi/literacy.html">系统推送</a></li>
			<li><a href="/yungongyi/registerpage.html">注册</a></li>
			<li><a href="/yungongyi/login.html">登录</a></li>
		</ul>
	</div>
	</nav>
	<script src="/yungongyi/statics/public/js/jquery-1.12.4.js"></script>
	<script src="/yungongyi/statics/public/js/bootstrap.min.js"></script>
	<script>
		function out() {
			$(".collapsein").show.addClass("header_allsilver");
		}
		function ins() {
			$(".collapsein").hide().removeClass("header_allsilver");
		}
	</script>
</body>
</html>