<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 左侧选项栏 -->
		<div class="page-sidebar nav-collapse collapse" id="functional">
			<!-- 开始左侧菜单 -->
			<ul class="page-sidebar-menu nav nav-pills ">
				<!--点击此按钮左侧菜单往左缩进-->
				<li>
					<div class="sidebar-toggler hidden-phone"></div>
				</li>
				<li><br></li>
				<!--第一个选项-->

				<!--用户管理-->
				<li class="start active  chooses "><a href="#user"
					data-toggle="pill" id="personManage"> <i class="icon-user"></i> <span
						class="title">用户管理</span> <span class="selected"></span>

				</a></li>
				<!--启事管理-->
				<li class="chooses"><a href="#notice" data-toggle="pill"
					id="noticManage"> <i class="icon-edit"></i> <span class="title">启事管理</span>
						<span class="selected"></span>
				</a></li>

				<!--系统通知-->
				<li class="chooses "><a href="#info" data-toggle="pill"
					id="infoManage"> <i class="icon-bullhorn"></i> <span
						class="title">系统通知</span> <span class="selected"></span>
				</a></li>

				<!--用户消息-->
				<li class="chooses "><a href="#message" data-toggle="pill"
					id="messageManage"> <i class="icon-bell"></i> <span
						class="title">用户消息</span> <span class="selected"></span>

				</a></li>

				<!--资源管理-->
				<li class="chooses "><a href="#resource" data-toggle="pill"
					id="resourceManage"> <i class="icon-upload-alt"></i> <span
						class="title">资源管理</span> <span class="selected"></span>

				</a></li>

				<!--地域管理-->
				<li class="chooses" id="territorymanage"><a href="#area"
					data-toggle="pill"> <i class="icon-home"></i> <span
						class="title">地域管理</span> <span class="selected"></span>
				</a></li>

				<!--模块管理-->
				<li class=" chooses"><a href="#table" data-toggle="pill"
					id="tablemanage"> <i class="icon-th-large"></i> <span
						class="title">模块管理</span> <span class="selected"></span>
				</a></li>
				<!--用户反馈-->
				<li class="chooses "><a href="#idea" data-toggle="pill"
					id="ideaManage"> <i class="icon-tags"></i> <span class="title">用户反馈</span>
						<span class="selected"></span>
				</a></li>
				<!--企业合作-->
				<li class=" chooses"><a href="#partner" data-toggle="pill"
					id="partnerManage"> <i class="icon-thumbs-up"></i> <span
						class="title">企业合作</span> <span class="selected"></span>

				</a></li>

				<!--操作记录-->
				<li class="chooses "><a href="#operation" data-toggle="pill"
					id="operationmanage"> <i class="icon-time"></i> <span
						class="title">操作记录</span> <span class="selected"></span>
				</a></li>

			</ul>
			<!-- 结束左边菜单栏 -->
		</div>
		<!--结束左侧选项栏 -->

</body>
</html>