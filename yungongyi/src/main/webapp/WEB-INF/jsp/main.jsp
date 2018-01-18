<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="page" content="main">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>云公益</title>
</head>
<body>

<!-- 头部 -->
<jsp:includepage="common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="/yungongyi/statics/main/css/style4.css" />


<!--轮播图 -->
<section class="banner" role="banner">
	<div class="banner" id="banner">
			<ul class="cb-slideshow">
				<li><span>Image 01</span>
					<div>
						<h3>让丢失东西的人不在着急</h3>
					</div></li>
				<li><span>Image 02</span>
					<div>
						<h3>帮丢失的孩子找到回家的路</h3>
					</div></li>
				<li><span>Image 03</span>
					<div>
						<h3>全民参与，这不是一个人的公益</h3>
					</div></li>
				<li><span>Image 04</span>
					<div>
						<h3>爱心不会枯萎</h3>
					</div></li>
				<li><span>Image 05</span>
					<div>
						<h3>让爱传递下去</h3>
					</div></li>
				<li><span>Image 06</span>
					<div>
						<h3>云公益，一个非商业性的公益网站</h3>
					</div></li>
			</ul>
			<!-- banner text -->
	</div>
</section>

<!-- 使用指南 -->
<section id="intro" class="section intro">
	<div class="container">
		<div class="col-md-8 col-md-offset-2 text-center">
			<h3>欢迎进入云公益系列网站</h3>
			<p>在本平台上您可以浏览别人发布的启事，浏览公益新闻，查看防丢失知识推送，寻找丢失的人或物品，也可以发布寻人，寻物启事，或者帮助他人寻找东西，当然您也可以联系我们加入我们的开发团队与我们一起打造这个所有人的公益平台；本平台所有素材都不用于商业用途，如遇广告或收费，欢迎积极举报哦！</p>
		</div>
	</div>
</section>
	
<!--本站菜单 menu -->
<section id="services" class="services service-section">
	<div class="container">
		<div class="section-header">
			<h2 class="wow fadeInDown animated">本站菜单</h2>
			<p class="wow fadeInDown animated">
				在这里您可以选择你想要浏览的内容<br> 点击头像进入.
			</p>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="/yungongyi/notice.html/null" class="noticepage icon icon-browser"></a>
				<div class="services-content">
					<a class="noticepage">
						<h5>启事大厅</h5>
						<p>进入查看所有启事信息</p>
					</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="/yungongyi/literacy.html" class="icon icon-documents"></a>
				<div class="services-content">
					<h5>系统推送</h5>
					<p>进入普及防丢失知识</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="/yungongyi/welfare.html" class="icon icon-chat"></a>
				<div class="services-content">
					<a href="/yungongyi/welfare.html">
						<h5>全民公益</h5>
						<p>进入参与全民公益.</p>
					</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="/yungongyi/personcenter.html" class="icon icon-genius"></a>
				<div class="services-content">
					<a href="/yungongyi/personcenter.html">
						<h5>个人中心</h5>
						<p>进入管理个人信息。</p>
					</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="#" class="icon icon-megaphone"></a>
				<div class="services-content">
					<h5>功能扩展</h5>
					<p>本功能暂未开通敬请期待.</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 services text-center">
				<a href="/yungongyi/index.html" class="icon icon-trophy"></a>
				<div class="services-content">
					<h5>进入后台管理</h5>
					<p>仅对开发者开放.</p>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- 全站查询 -->
<section id="content-3-10" class="container content-block data-section nopad content-3-10">
	<h1 class="text-center">全站查询</h1>
	<div class="row">
		<div class="col-md-6 col-md-offset-3 col-xs-12">
			<input name="Content" class="form-control" type="text"
				placeholder="请输入关键字" />
		</div>
	</div>
	<hr style="opacity: 0">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 col-xs-12">
			<input type="submit" id="noticesearch"
				class="form-control btn btn-success" value="立即查询" />
		</div>
	</div>
</section>

<!-- 视频启事 -->
<section class="video-section"> </section>

<!-- 最新启事 -->
<section id="gallery" class="gallery section">
	<div class="container-fluid">
		<div class="section-header">
			<h2 class="wow fadeInDown animated">最新启事</h2>
			<p class="wow fadeInDown animated">
				最新发布的启事，看看有没有需要帮助或者可以帮助别人的<br>
			</p>
		</div>
		<div class="row no-gutter" id="noticelist"></div>
	</div>
</section>

<!-- 全站广播 -->
<section id="teams" class="section teams">
	<div class="container">
		<div class="section-header">
			<h2 class="wow fadeInDown animated">全站广播</h2>
			<p class="wow fadeInDown animated">如果有连接到音响可以进行有声广播.</p>
			<p class="text-info text-center">未授权人员每天只能广播一次哦</p>
		</div>

		<div>
			<div>
				<textarea id="audio_text" style="width: 100%" placeholder="请输入要广播的内容"></textarea>
				<hr style="opacity: 0">
				<button id="audio_play" class="btn btn-block">立即广播</button>
			</div>
		</div>
	</div>
</section>

<!-- 底部footer -->
<jsp:include page="common/footer.jsp"></jsp:include>

<script src="/yungongyi/statics/main/js/menujump.js" type="text/javascript"></script>
<script>
//全站广播
$("#audio_play").click(function(){
    var str=$("#audio_text").val();

    sendAll("11",str) 
});
</script>
</body>
</html>