<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<base href="/yungongyi/">
<head>
<meta charset="UTF-8">
<title>系统通知</title>

<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="/yungongyi/statics/literacycss/style.css"
	media="screen" />
<link rel="stylesheet"
	href="/yungongyi/statics/literacycss/media-queries.css" />
<link rel="stylesheet"
	href="/yungongyi/statics/flex-slider/flexslider.css" type="text/css"
	media="screen" />
<link href="/yungongyi/statics/literacycss/prettyPhoto.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="/yungongyi/statics/literacycss/tipsy.css" rel="stylesheet"
	type="text/css" media="screen" />


<script type="text/javascript"
	src="/yungongyi/statics/flex-slider/jquery.flexslider-min.js"></script>

<script src="/yungongyi/statics/liter/jquery.prettyPhoto.js"
	type="text/javascript"></script>
<script src="/yungongyi/statics/liter/jquery.tipsy.js"
	type="text/javascript"></script>
<script src="/yungongyi/statics/liter/jquery.knob.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="/yungongyi/statics/liter/jquery.isotope.min.js"></script>
<script type="text/javascript"
	src="/yungongyi/statics/liter/jquery.smooth-scroll.min.js"></script>
<script type="text/javascript"
	src="/yungongyi/statics/liter/waypoints.min.js"></script>
<script type="text/javascript" src="/yungongyi/statics/liter/setup.js"></script>




</head>
<body>
	<div><jsp:include page="common/header2.jsp"></jsp:include></div>
	<div id="wrap" style="padding-top: 50px">
		<!-- wrapper -->
		<div id="sidebar" style="background: rgb(0, 0, 0, 0.3);">
			<!-- the  sidebar -->
			<!-- logo -->
			<a href="#" id="logo" style="font-size: 20px; text-decoration: none;">云公益</a>
			<!-- navigation menu -->
			<ul id="navigation">
				<li><a href=".about" class="active">防丢失知识普及</a></li>
				<li><a href=".portfolio">防诈骗知识</a></li>
				<li><a href=".port">防骗“十要素”</a></li>
			</ul>
		</div>
		<div id="container" style="background: rgba(0, 0, 0, 0.5);">
			<div class="page about" id="about">
				<!-- page about -->
				<h3 class="page_title">防丢失知识普及</h3>
				<div class="page_content">
					<p id="diushi">
					
					</p>

					<div class="clear"></div>
				</div>
			</div>
			<div class="page portfolio" id="portfolio">
				<!-- page portfolio -->
				<h3 class="page_title">防诈骗须知</h3>
				<div class="page_content">
					<p id="zhapian">
					</p>
					<div class="clear"></div>
				</div>
			</div>
			<div class="page port" id="port">
				<!-- page portfolio -->
				<h3 class="page_title">防骗“十要素”</h3>
				<div class="page_content">
					<p id="shiyaosu">
					
					</p>
					<div class="clear"></div>

				</div>
			</div>
		</div>
	</div>
	<a class="gotop" href="#top">Top</a>
	
	<script type="text/javascript" src="/yungongyi/statics/liter/literacy.js"></script>
</body>
</html>