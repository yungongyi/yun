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

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en" class="no-js">
<base href="<%=basePath%>">
<head>
<meta charset="utf-8" />

<title>云公益后台管理平台</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="请叫我大师" name="description" />

<meta content="孙家伟、高俊东" name="author" />

<!-- 开始全局强制样式 -->
<link href="<%=basePath%>static/css/houtaicss/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=basePath%>static/css/houtaicss/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />
<!--图标-->
<link href="<%=basePath%>static/css/houtaicss/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/css/houtaicss/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/css/houtaicss/style-responsive.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/css/houtaicss/default.css"
	rel="stylesheet" type="text/css" id="style_color" />
<style>
#functional>ul>li {
	width: 100%;
}

@media all and (min-width:1200px) {
	.page-title {
		display: block;
	}
	.page-title-small {
		display: none;
	}
}

@media all and (max-width:1200px) {
	.page-title {
		display: none;
	}
	.page-title-small {
		display: block;
	}
	.hidden-phone {
		display: none;
	}
}

@media all and (max-width:320px) {
	#time {
		display: none;
	}
}
</style>
</head>
<!-- 开始主体 -->

<body class="page-header-fixed">
	<!-- 开始主体头部-->
	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- 开始顶部导航栏 -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- logo -->

				<a class="brand" href="index.html"> <img
					src="<%=basePath%>/static/image/logo.png" alt="logo" />

				</a>

				<!-- END LOGO -->

				<!-- 开始菜单显示开关响应 -->

				<a href="javascript:;" class="btn-navbar collapsed"
					data-toggle="collapse" data-target=".nav-collapse"> <img
					src="<%=basePath%>/static/image/menu-toggler.png" alt="" />

				</a>

				<!-- 结束菜单显示开关响应 -->

				<!-- 开启顶部导航菜单 -->
				<ul class="nav pull-right">
					<!--开始顶部导航栏用户下拉框-->
					<li><span class="page-title-small"
						style="color: white; line-height: 50px; margin-right: 75px;">云公益后台管理</span>
					</li>
					<li class="dropdown user">
						<!--头像加姓名--> <a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <img alt=""
							src="<%=basePath%>/static/image/avatar1_small.jpg" /> <span
							class="username">让爱传递</span> <i class="icon-angle-down"></i>
					</a>
						<ul class="dropdown-menu">

							<li><a href="extra_profile.html"><i class="icon-user"></i>
									待修改</a></li>

							<li><a href="page_calendar.html"><i
									class="icon-calendar"></i> 待修改</a></li>

							<li><a href="inbox.html"><i class="icon-envelope"></i>
									待修改</a></li>

							<li><a href="#"><i class="icon-tasks"></i>待修改</a></li>

							<li class="divider"></li>

							<li><a href="extra_lock.html"><i class="icon-lock"></i>锁定当前用户</a>
							</li>

							<li><a href="login.html"><i class="icon-key"></i>退出</a></li>

						</ul>

					</li>

				</ul>

				<!-- 结束顶端导航菜单 -->

			</div>

		</div>

		<!-- 结束顶端导航栏 -->

	</div>
	<!-- 结束主体头部 -->

	<!-- 开始主体内容-->
	<div class="page-container">

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
					data-toggle="pill"> <i class="icon-user"></i> <span
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

		<!-- 开始页 -->

		<div class="page-content">

			<!-- 开始页面容器-->

			<div class="container-fluid">

				<!-- 开始页面头部-->

				<div class="row-fluid">

					<div class="span12">

						<!-- 开始风格定制 -->
						<div class="color-panel hidden-phone">

							<div class="color-mode-icons icon-color"></div>

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								<label> <span>布局</span> <select
									class="layout-option m-wrap small">

										<option value="fluid" selected>充满</option>

										<option value="boxed">盒状</option>

								</select>

								</label> <label> <span>左侧选项卡</span> <select
									class="sidebar-option m-wrap small">

										<option value="fixed">悬浮弹出</option>

										<option value="default" selected>悬浮不弹出</option>

								</select>

								</label>
							</div>

						</div>

						<!-- 结束风格定制-->

						<h3 class="page-title">

							云公益后台管理<small> &nbsp;键盘的敲打声让我变得更加稳重</small>

						</h3>

						<ul class="breadcrumb">

							<li class="titletext"><i class="icon-wrench"></i> <span
								class="text">用户管理</span></li>

							<li class="pull-right no-text-shadow">

								<div id="time"
									style="background: red; color: white; padding: 8px; margin-top: -7px;"></div>
							</li>

						</ul>
						<!-- 结束页面标题-->
					</div>

				</div>
				<!--页面右内容-->
				<div id="dashboard">
					<!--选项卡面板-->
					<div class="tab-content" id="menu">
						<!--用户管理-->
						<div class="tab-pane fade in active" id="user">
							<form class="input-group" id="fromuser">
								<input type="text" class="form-control" placeholder="手机号查询"
									name="iphone" />
								<button type="button" class="btn btn-default"
									style="margin-top: -10px;" name="serachuser">搜索</button>
							</form>

							<div style="padding: 5px;">							
								<table class="usertable" width="100%" id="usertable">
								<p style="color: red" id="usertishi" ></p>
									<tr style="background: #cccccc;">
										<th>用户ID</th>
										<th>手机号</th>
										<th>昵称</th>
										<th>创建时间</th>
										<th>性别</th>
										<th>地址</th>
										<th>状态</th>
										<th>类型</th>
										<th>操作</th>
									</tr>
								</table>

								<ul class='text-center userul'
									style='list-style: none; display: none'>

								</ul>

								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>

							</div>

						</div>

						<!--启示管理-->
						<div class="tab-pane fade" id="notice">
							<form class="input-group" id="fromnotice">
								<input type="text" placeholder="请输入启事状态" name="noticeTittle" />
								<input type="date" name="noticeDate">
								<button type="button" class="btn btn-default"
									style="margin-top: -10px;" name="serachnotice">搜索</button>
							</form>
							<div>

								<table class="noticetable" width="100%" id="noticetable">
									<p style="color: red" id="noticetishi" ></p>
									<tr style="background: #cccccc;">
										<th>ID</th>
										<th>标题</th>
										<th>区县</th>
										<th>联系方式</th>
										<th>发布时间</th>
										<th>启事状态</th>
										<th>启事类型</th>
										<th>操作</th>
									</tr>

								</table>
								<ul class="text-center noticeul"
									style="list-style: none; display: none;">

								</ul>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>

						</div>

						<!--系统通知-->
						<div class="tab-pane fade" id="info">
							<form class="input-group">
								<input type="text" class="form-control" placeholder="通知ID"
									style="width: 55%" name="infoId" />
								<button type="button" class="btn btn-default"
									style="margin-top: -10px;" name="serach">搜索</button>
								<button type="button" class="btn btn-default addinfo"
									style="margin-top: -10px;">新增</button>
							</form>

							<ul class="text-center infoul"
								style="list-style: none; display: none">
								<li><span>通知内容：</span> <span> <input type="text"
										value="" id="firstinput">
								</span></li>
								<li>
									<button class="infoadd">提交</button>
								</li>

							</ul>
							<div style="padding: 5px;">
								<table class="infotable" width="100%" id="firsttable">
									<p style="color: red" id="infotishi" ></p>
									<tr style="background: #cccccc;">
										<th>通知ID</th>
										<th>通知内容</th>
										<th>创建时间</th>
										<th>操作</th>
									</tr>

								</table>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>

						<!--用户消息-->
						<div class="tab-pane fade" id="message">
							<form style="padding-top: 5px">
								<p>
									<span class="form-group"><input type="text"
										placeholder="消息ID" class="input-sm" name="messageId" /> </span> <span
										class="form-group"><button type="button"
											name="searchMessage" class="btn btn-default"
											style="margin-top: -10px">查询</button></span>
								</p>
							</form>

							<div style="padding: 5px;">
								<table width="100%" id="seconddiv">
								<p style="color: red" id="messagetishi" ></p>
									<tr style="background: #cccccc;">
										<th>消息ID</th>
										<th>消息内容</th>
										<th>发送人</th>
										<th>发送人电话</th>
										<th>消息状态</th>
										<th>发送时间</th>
										<th>接收人</th>
										<th>接收人电话</th>
										<th>操作</th>
									</tr>

								</table>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>

						<!--资源管理-->
						<div class="tab-pane fade" id="resource">
							<form class="input-group" id="formResource">
								<input name="searchBySourceId" type="text" class="form-control"
									placeholder="资源ID" style="width: 55%" />
								<button id="reourceById" type="button" class="btn btn-default"
									style="margin-top: -10px;" name="serachresource">搜索</button>
							</form>


							<div style="padding: 5px;">
								<table id="resourceList" class="resourcetable" width="100%">
									<tr style="background: #cccccc;">
										<th>资源ID</th>
										<th>资源路径</th>
										<th>资源类型</th>
										<th>操作</th>
									</tr>
								</table>

								<!--查看-->
								<ul class="text-center getresourceul"
									style="list-style: none; display: none">

								</ul>

								<div>
									<ul class="pager">
										<li><a onclick="prev();">上一页</a></li>

										<li><a onclick="next();">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>

						<!--地域管理-->
						<jsp:include page="region.jsp"></jsp:include>

						<!--模块管理-->
						<div class="tab-pane fade" id="table">
							<p id="tablewaring"></p>
							<div class="text-center tables">
								<select class="combobox2 tableName" id="tableManagesList">

								</select> <select class="combobox0" id="stateList">
								</select> <select class="combobox1" id="typeList">
								</select>

								<div class="text-center">
									<a class="findtable">编辑模块表..</a> <br /> <a class="addstates">编辑状态..</a><br />
									<a class="addtypes">编辑类型..</a><br />
								</div>
							</div>
							<div class="tablediv text-center" style="display: none;">
								<input type="text" name="tableNameZH" placeholder="请输入表的中文名字" /><br />
								<input type="text" name="tableNameUK" placeholder="请输入表的英文名字" /><br />
								<button type="submit" class="btn btn-default tablefind">提交</button>
							</div>
							<div class="statediv text-center" style="display: none;">
								<select class="tableName" id="selectState">

								</select><br /> <input type="text" name="stateName"
									placeholder="请输入要添加的状态" /><br />
								<button type="submit" class="btn btn-default statesadd"
									id="stateSubmit">提交</button>
							</div>
							<div class="typediv text-center" style="display: none;">
								<select class="tableName" id="selectType">

								</select><br /> <input type="text" name="typeName"
									placeholder="请输入要添加的类型" /><br />
								<button type="button" class="btn btn-default typesadd"
									id="typeSubmit">提交</button>
							</div>
						</div>

						<!--用户反馈-->
						<div class="tab-pane fade" id="idea">
							<form style="padding-top: 5px" id="formIdea">
								<p>
									<span class="form-group"><input type="text"
										placeholder="意见ID" name="iedaId" class="input-sm" /> </span> <span
										class="form-group"><button type="button"
											name="searchIdea" class="btn btn-default"
											style="margin-top: -10px;">查询</button></span>
								</p>
							</form>

							<div style="padding: 5px;">
								<table width="100%" id="thirddiv">
									<p style="color: red" id="ideaishi" ></p>
									<tr style="background: #cccccc;">
										<th>意见ID</th>
										<th>意见内容</th>
										<th>意见人联系方式</th>
										<th>意见人邮箱</th>
										<th>创建时间</th>
										<th>处理状态</th>
										<th>操作</th>
									</tr>
								</table>
								<ul class="text-center ideaul"
									style="list-style: none; display: none">

								</ul>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>


						<!--企业合作-->
						<div class="tab-pane fade" id="partner">
							<form class="input-group" id="formPartner">
								<input type="text" class="form-control" placeholder="合作名称"
									style="width: 55%" name="partnerName" />
								<button type="button" class="btn btn-default"
									style="margin-top: -10px;" name="serachpart">搜索</button>
								<button type="button" class="btn btn-default addpartner"
									style="margin-top: -10px;">新增</button>
							</form>

							<!--新增-->
							<ul class="text-center partnerul"
								style="list-style: none; display: none">

								<li><span>合作人：</span> <span> <input type="text"
										value="" id="addname">

								</span> <span id="name1"></span></li>
								<li><span>合作标志：</span> <span> <input type="text"
										value="" id="addmark">
								</span></li>
								<li><span>结束时间：</span> <span> <input type="date"
										value="" id="adddate">
								</span> <span id="date1"></span></li>
								<li><span>资源路径：</span> <input type="file" id="file">
									<button
										onclick='uploadFileById("file","/commonweal/partner/addPartner",12);'>提交</button>
									<!-- <input type="file" value="" id="addresourceid"> --></li>
								<li><span>合作状态：</span> <select id="addstateid">
										<option value="12">待合作</option>
										<option value="14" selected="selected">合作中</option>
										<option value="15">已解约</option>
								</select></li>
								<li>
									<button class="partneradd" name="partneradd">提交</button>
								</li>
							</ul>

							<div style="padding: 5px;">
								<table class="partnertable" width="100%" id="partnertables">
									<p style="color: red" id="partnertishi" ></p>
									<tr style="background: #cccccc;">
										<th>合作ID</th>
										<th>合作人</th>
										<th>开始时间</th>
										<th>结束时间</th>
										<th>资源路径</th>
										<th>合作状态</th>
										<th>操作</th>
									</tr>
								</table>
								<!--查看-->
								<ul class="text-center getpartnerul"
									style="list-style: none; display: none">



								</ul>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>



						<!--操作记录-->
						<div class="tab-pane fade" id="operation">
							<p>
								<span class="form-group"> 操作人：<input type="text"
									placeholder="请输入管理员姓名" class="input-sm"
									name="operationPersonName" />
								</span> <span class="form-group"><button type="submit"
										class="btn btn-default" style="margin-top: -10px;"
										id="operationsearch">查询</button></span>
							</p>
							<div>
								<table width="100%" id="operationlist">
									<tr style="background: #cccccc;">
										<th>操作ID</th>
										<th>操作时间</th>
										<th>操作表</th>
										<th>操作类型</th>
										<th>操作人</th>
									</tr>

								</table>
								<div>
									<ul class="pager">
										<li><a href="#">上一页</a></li>

										<li><a href="#">下一页</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			<!-- 结束页面 -->

		</div>

		<!-- 结束容器 -->
		<!-- 核心js-->
		<script src="<%=basePath%>/static/js/houtaijs/jquery-1.10.1.min.js"
			type="text/javascript"></script>
		<script
			src="<%=basePath%>/static/js/houtaijs/jquery-migrate-1.2.1.min.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="<%=basePath%>/static/js/houtaijs/time.js"></script>
		<!-- index.jsp 页面引入的js -->
		<script src="/commonweal/static/js/index/index.js"
			type="text/javascript"></script>

		<!--数据表格-->
		<script
			src="<%=basePath%>/static/js/houtaijs/jquery.dataTables.min.js"></script>
		<script src="<%=basePath%>/static/js/houtaijs/table-advanced.js"></script>

		<!-- 防止jquryUI与Bootstrap冲突-->
		<script
			src="<%=basePath%>/static/js/houtaijs/jquery-ui-1.10.1.custom.min.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/static/js/houtaijs/bootstrap.min.js"
			type="text/javascript"></script>
		<!-- 结束核心js-->
		<!-- 开始页面脚本 -->

		<!-- 模块js -->
		<script src="/commonweal/static/js/index/tablemanage.js"
			type="text/javascript"></script>

		<script src="<%=basePath%>/static/js/houtaijs/app.js"
			type="text/javascript"></script>
		<script src="/commonweal/static/js/houtaijs/index.js"
			type="text/javascript"></script>
		<script>
			jQuery(document).ready(
					function() {
						App.init(); // initlayout and core plugins
						Index.init();
						Index.initCalendar(); // 分页索引

						$('.chooses').click(
								function() {
									var titletext = $(this).children()
											.children('.title').html();
									$('.text').html(titletext);

								});
						$('.noticemanage').click(function() {
							$('.noticetable').hide(500);
							$('.noticeul').show(500);
						});
						$('.noticereturn').click(function() {
							$('.noticetable').show(500);
							$('.noticeul').hide(500);
						});
						$('.shengfenmanage').click(function() {
							$('.quyutable').hide(500);
							$('.addshengfen').show(500);
						});
						$('.shengfensubmit').click(function() {
							$('.quyutable').show(500);
							$('.addshengfen').hide(500);
						});

						$('.citymanage').click(function() {
							$('.quyutable').hide(500);
							$('.addcity').show(500);
						});
						$('.citysubmit').click(function() {
							$('.quyutable').show(500);
							$('.addcity').hide(500);
						});

						$('.quyumanage').click(function() {
							$('.quyutable').hide(500);
							$('.addquyu').show(500);
						});
						$('.quyusubmit').click(function() {
							$('.quyutable').show(500);
							$('.addquyu').hide(500);
						});

						<!--用户-->
						$('.usermanage').click(function() {
							$(".userul").show(500);
							$(".usertable").hide(500);

						});
						$('.userreturn').click(function() {
							$(".usertable").show(500);
							$(".userul").hide(500);

						});

						<!--系统-->
						$('.addinfo').click(function() {
							$(".infoul").show(500);
							$(".infotable").hide(500);

						});
						$('.infoadd').click(function() {
							$(".infotable").show(500);
							$(".infoul").hide(500);

						});

						<!--资源-->
						$('.resourceadd').click(function() {
							$(".resourcetable").show(500);
							$(".resourceul").hide(500);

						});
						$('.addresource').click(function() {
							$(".resourceul").show(500);
							$(".resourcetable").hide(500);

						});

						<!--企业新增-->
						$('.addpartner').click(function() {
							$(".partnerul").show(500);
							$(".partnertable").hide(500);

						});
						$('.partneradd').click(function() {
							$(".partnertable").show(500);
							$(".partnerul").hide(500);

						});

						<!--企业查看-->
						$('.showpartner').click(function() {
							$(".getpartnerul").show(500);
							$(".partnertable").hide(500);

						});
						$('.partnerget').click(function() {
							$(".partnertable").show(500);
							$(".getpartnerul").hide(500);

						});

						<!--模块-->
						$('.addstates').click(function() {
							$(".statediv").show(500);
							$(".tables").hide(500);

						});
						$('.statesadd').click(function() {
							$(".tables").show(500);
							$(".statediv").hide(500);

						});

						$('.addtypes').click(function() {
							$(".typediv").show(500);
							$(".tables").hide(500);

						});
						$('.typesadd').click(function() {
							$(".tables").show(500);
							$(".typediv").hide(500);

						});

						$('.findtable').click(function() {
							$(".tablediv").show(500);
							$(".tables").hide(500);

						});
						$('.tablefind').click(function() {
							$(".tables").show(500);
							$(".tablediv").hide(500);

						});

					});
		</script>
</body>

</html>

