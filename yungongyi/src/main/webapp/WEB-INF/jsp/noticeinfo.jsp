<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<base href="/yungongyi">
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />


<title>启示详细信息</title>
</head>
<body>
	<jsp:include page="common/header2.jsp"></jsp:include>
	<script src="/yungongyi/statics/noticeInfo/js/noticeinfo.js"></script>
	<link rel="stylesheet"
		href="/yungongyi/statics/noticeInfo/noticeInfo.css">

	<div class="container " id="noticeInfo">
		<div class="row">
			<div class="col-md-4">
				<img class="noticeInfoImage" style="width: 70%" alt="无" src="">
			</div>
			<div style="margin-top: 9.77%" class="col-md-8">
				<h4 class="media-heading">
					类型 ：<span class="noticetype"></span>
				</h4>

				<p style="display: none">
					<strong>启事id :</strong><span class="noticeid">${noticeid}</span>
				</p>

				<p>
					<strong>发布时间 ：</strong><span class="noticecreatedate"> </span>
				</p>
				<p>
					<strong>状态 ：</strong><span class="noticestate"> </span>
				</p>
				<p>
					<strong>联系人 ：</strong><span class="personname"> </span>
				</p>
				<p>
					<strong>联系电话 ：</strong><span class="personphone"></span>
				</p>
				<p>
					<!-- JiaThis Button BEGIN -->
				<div class="jiathis_style">
					<span class="jiathis_txt" style="color: white">分享到：</span> <a
						class="jiathis_button_icons_1"></a> <a
						class="jiathis_button_icons_2"></a> <a
						class="jiathis_button_icons_3"></a> <a
						class="jiathis_button_icons_4"></a> <a
						href="http://www.jiathis.com/share"
						class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
					<a class="jiathis_counter_style"></a>
				</div>
				<script type="text/javascript"
					src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
			</div>
			<div class="col-md-12">
				<hr />
				<h4 style="color: #F2DEDE;">详细描述：</h4>
				<p style="text-indent: 8em; color: #F2DEDE;">
					<span class="noticedetail"></span>
				</p>
				<br /> <br /> <small
					style="font-style: italic; color: white; float: right;">---真者，精诚之至也。不精不诚，不能动人。</small>
			</div>
		</div>
	</div>
	<jsp:include page="common/footer2.jsp"></jsp:include>

</body>

</html>
