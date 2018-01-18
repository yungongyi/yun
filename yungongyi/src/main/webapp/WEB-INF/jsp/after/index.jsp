<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<base href="<%=basePath%>">
<head>
<meta charset="utf-8" />

<title>云公益后台管理平台</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="请叫我大师" name="description" />

<meta content="孙家伟、高俊东" name="author" />


<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />

<!-- 开始全局强制样式 -->
<link href="<%=basePath%>/statics/after/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=basePath%>/statics/after/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />
<!--图标--> 
<link href="<%=basePath%>/statics/after/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/statics/after/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/statics/after/css/style-responsive.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/statics/after/css/default.css"
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
					src="<%=basePath%>/statics/after/image/logo.png" alt="logo" /> 
				</a>
				<!-- END LOGO -->
				<!-- 开始菜单显示开关响应 -->
				<a href="javascript:;" class="btn-navbar collapsed"
					data-toggle="collapse" data-target=".nav-collapse"> <img
					src="<%=basePath%>/statics/after/image/menu-toggler.png" alt="" /> 
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
							src="<%=basePath%>/statics/after/image/avatar1_small.jpg" /> <span
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
		<!-- 左侧菜单栏 -->
		<jsp:include page="leftmenu.jsp"></jsp:include>
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
						<!-- 用户管理 -->
						<jsp:include page="person.jsp"></jsp:include>
						<!--启示管理-->
						<jsp:include page="notice.jsp"></jsp:include>
						<!--系统通知-->
						<jsp:include page="info.jsp"></jsp:include>
						<!--用户消息-->
						<jsp:include page="message.jsp"></jsp:include>
						<!--资源管理-->
						<jsp:include page="resource.jsp"></jsp:include>
						<!--地域管理-->
						<jsp:include page="region.jsp"></jsp:include>
						<!--模块管理-->
						<jsp:include page="table.jsp"></jsp:include>
						<!--用户反馈-->
						<jsp:include page="idea.jsp"></jsp:include>
						<!--企业合作-->
						<jsp:include page="partner.jsp"></jsp:include>
						<!--操作记录-->
						<jsp:include page="operation.jsp"></jsp:include>
						<div id="paging" style='line-height:60px;padding:0em 2em'></div>
					</div>

				</div>
			</div>
			<!-- 结束页面 -->
		</div>
		<!-- 结束容器 --> 
		<!-- 核心js-->
		<script src="<%=basePath%>/statics/after/js/public/jquery-1.10.1.min.js"
			type="text/javascript"></script>
		<script
			src="<%=basePath%>/statics/after/js/public/jquery-migrate-1.2.1.min.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="<%=basePath%>/statics/after/js/public/time.js"></script>
		<!-- index.jsp 页面引入的js -->
		<script src="<%=basePath%>/statics/after/js/public/index.js"
			type="text/javascript"></script>
		<!--数据表格-->
		<script
			src="<%=basePath%>/statics/after/js/public/jquery.dataTables.min.js"></script>
		<script src="<%=basePath%>/statics/after/js/public/table-advanced.js"></script>
		<!-- 防止jquryUI与Bootstrap冲突-->
		<script
			src="<%=basePath%>/statics/after/js/public/jquery-ui-1.10.1.custom.min.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/public/bootstrap.min.js"
			type="text/javascript"></script>
		<!-- 结束核心js-->
		<script src="<%=basePath%>/statics/after/js/public/app.js"
			type="text/javascript"></script>
			 
		<!-- 开始页面脚本 -->
		<script src="<%=basePath%>/statics/after/js/index.js"
			type="text/javascript"></script>
		<!-- 模块js -->
		<script src="<%=basePath%>/statics/after/js/tablemanage.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/person.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/notice.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/info.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/message.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/idea.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/partner.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/resource.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/operation.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/statics/after/js/region.js"
			type="text/javascript"></script>
		<!-- 分页 -->
		<script src="<%=basePath%>/statics/after/js/Houtaipaging.js"
			type="text/javascript"></script>
		<script>
			$(function() {
				App.init(); // initlayout and core plugins
				Index.init();
				Index.initCalendar(); // 分页索引

				$('.chooses').click(
						function() {
							var titletext = $(this).children().children(
									'.title').html();
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
					$("#formPartner").hide();

				});
				$('.partneradd').click(function() {
					$(".partnertable").show(500);
					$(".partnerul").hide(500);
					$("#formPartner").show();

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

