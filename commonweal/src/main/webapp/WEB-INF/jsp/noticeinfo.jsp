<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
	<head lang="en">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
		<meta charset="UTF-8">
		<link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet">
		<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
		<script src="<%=basePath%>/static/js/bootstrap.js"></script>
		<link rel="stylesheet" href="<%=basePath%>/static/css/noticeInfo.css">
		<title>云公益启事详细信息</title>
	</head>

	<body>
		<div id="noticeinfopage">

			<!--头部图片-->
			<header>
				<div class="container">
					<a href="#"><img src="<%=basePath%>/static/image/noticeinfo/noticeinfo_1.jpg" alt="" class="img-responsive" style="width: 100%"></a>
				</div>
			</header>
			<!--当前位置-->
			<div class="container" id="firstdiv">
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> 您的当前位置 >
					<a href="#">
						<span class="glyphicon glyphicon-home"></span> 首页
					</a> >
					<span class="glyphicon glyphicon-info-sign"></span> 启事详细信息
				</p>

			</div>
			<!--左侧为详细信息，右侧为新闻，公告-->
			<div class="container" id="thirddiv">
				<div class="row">
					<!--详细信息-->
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 ">
						<div class="media">
							<div class="media-left">
								<a href="#" id="firsta">
									<img src="<%=basePath%>/static/image/noticeinfo/noticeinfo_person1.jpg" class="media-object" alt="">
								</a>
							</div>
							<div class="media-body" id="seconddiv">
								<h4 class="media-heading">类型 ：寻人启事</h4>
								<p>失踪地点 ：金水区文化路街道</p>
								<p id="firstp">失踪时间 ：2017年11月20日</p>
								<p>状态 ：未找到</p>
								<p>联系人 ：小朝先生</p>
								<p>联系电话 ：14521452146</p>
								<p>
									<a href="#">
										<span class="glyphicon glyphicon-share"></span> 分享
									</a>
									<a href="#">
										<span class="glyphicon glyphicon-flag"></span> 举报
									</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<ul class="nav nav-tabs">
							<li class="active ">
								<a href="#pane1" data-toggle="tab" style="font-size: 2rem">新闻</a>
							</li>
							<li>
								<a href="#pane2" data-toggle="tab" style="font-size: 2rem">公告</a>
							</li>
						</ul>
						<!--选项卡新闻 公告-->
						<div class="tab-content" id="fourdiv">
							<div class="tab-pane fade in active" id="pane1">
								<p>张女生女士包包已认领</p>
								<p>孔先生于17年12月15日在花园路捡到一只拉布拉多</p>
								<p>赵女士于17年12月1日在紫荆山地铁站捡到绿城卡一张</p>
								<p>马女士于17年12月10日在紫荆山地铁站捡到工作卡一张</p>
							</div>
							<div class="tab-pane fade" id="pane2">
								<p>云公益Web端3.1.1版本已上线</p>
								<p>云沃客Web端3.1.2版本已上线</p>
								<p>云沃客Web端3.1.3版本已上线</p>
								<p>云沃客Web端3.1.4版本已上线</p>
							</div>
						</div>

						<!--选项卡底部-->
						<div class="media " id="fivediv">
							<div class="media-left">
								<a href="#">

								</a>
							</div>
							<div class="media-body ">
								<h4 class="media-heading">寻物启事</h4>
								<p>二七区</p>
								<p>12.18&nbsp;&nbsp;&nbsp;寻物</p>
							</div>
							<div class="media-left">
								<a href="#">

								</a>
							</div>
							<div class="media-body ">
								<h4 class="media-heading">寻人启事</h4>
								<p>金水区</p>
								<p>12.18&nbsp;&nbsp;&nbsp;寻人</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html> 