<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="/yungongyi">
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<link rel="stylesheet"
	href="/yungongyi/statics/public/css/bootstrap.min.css" />
<link rel="stylesheet" href="/yungongyi/statics/welfare/welfare.css" />
<script src="/yungongyi/statics/public/js/jquery-1.12.4.js"></script>
<script src="/yungongyi/statics/public/js/bootstrap.min.js"></script>

<title>全民公益</title>
<style>
</style>
</head>

<body>
	<jsp:include page="common/header2.jsp"></jsp:include>
	<div id="welfarepage">
		<!--头部-->
		<div class="qmgy_section carousel">

			<img src="/yungongyi/statics/main/images/welfare/welfare-01.jpg">
			<span class="carousel-caption qmgy_span">全民公益，是人人参与的公益，不管是个人还是集体，
				人们通过各种公益活动、 公益基金、公益网站等途径 ，通过直接参与、捐赠、公益广告、公益歌曲等方式 参与到公
				益中来。在中国古代，倡导日行一善，就 是每天做一些我们力所能及的事情，帮助更多的人，让社会更加美好和谐。</span>

		</div>
		<div>
			<!--推送公告-->
			<!--中间体部-->
			<div class="container">
				<ul class="row nav  input-group-addon text-center qmgy_text">

					<li class="col-md-4 col-xs-12"><a href="#gyyy"
						data-toggle="tab">公益的意义</a></li>
					<li class="col-md-4 col-xs-12"><a href="#hzgs"
						data-toggle="tab" id="getPartner">合作公司</a></li>
					<li class="col-md-4 col-xs-12"><a href="#lxwm"
						data-toggle="tab"> 联系我们</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in" id="gyyy">
						<div class="row text-center">

							<div class="col-md-6 col-xs-12">
								<img src="/yungongyi/statics/main/images/welfare/welfare-16.jpg"
									style="width: 70%; padding-top: 7%;">
							</div>
							<div class="col-md-6 col-xs-12" style="padding-top: 25px;">
								<h4 class="media-heading"
									style="border-bottom: 2px #b0b0b0 solid" id="yiyi">公益的意义</h4>

							</div>
						</div>
					</div>
					<div class="tab-pane fade in" id="hzgs">
						<div class="row" id="Partner">
							
						</div>

					</div>
					<div class="tab-pane fade in" id="lxwm">
						<div class="row text-center">

							<div class="col-md-6 col-xs-12">
								<img src="/yungongyi/statics/main/images/welfare/welfare-14.jpg"
									class="img-responsive">
							</div>
							<div class="col-md-6 col-xs-12" style="padding-top: 25px;">
								<h4 class="media-heading"
									style="border-bottom: 2px #b0b0b0 solid" id="yungongyi">云公益</h4>

							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-6 col-xs-12">
						<div class="media qmgy_media text-center">
							<div class="media-right qmgy-img" style="float: right;">
								<div id="myCarousel" class="carousel slide" data-ride="carousel">
									<div class="carousel-inner " id = "zuotuaaa">
									 <div class="item active">
											<a href="#" id="zuotu1"> <img id="zuoimg1"
												src="/yungongyi/statics/main/images/welfare/welfare-03.jpg">
												<span id="zuospan1" class="carousel-caption qmgy_carousel-caption">2017年度上海市公益广告宣传指南</span>
											</a>
										</div>
										<div class="item">
											<a href="#" id="zuotu2"> <img id="zuoimg2"
												src="/yungongyi/statics/main/images/welfare/welfare-09.jpg">
												<span id="zuospan2" class="carousel-caption qmgy_carousel-caption">上海市文明城区名单和2014-2015年度上
											</span>
											</a>
										</div>
										<div class="item">
											<a href="#" id="zuotu3"> <img id="zuoimg3"
												src="/yungongyi/statics/main/images/welfare/welfare-05.jpg">
												<span id="zuospan3" class="carousel-caption qmgy_carousel-caption">2015年度上海市社会主义精神文明好人好
											</span>
											</a>
										</div>

										<div class="item">
											<a href="#" id="zuotu4"> <img id="zuoimg4"
												src="/yungongyi/statics/main/images/welfare/welfare-06.jpg">
												<span id="zuospan4" class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
											</a>
										</div> 
									</div>
									<ol class="carousel-indicators">
										<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
										<li data-target="#myCarousel" data-slide-to="1"></li>
										<li data-target="#myCarousel" data-slide-to="2"></li>
										<li data-target="#myCarousel" data-slide-to="3"></li>

									</ol>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xs-12 txt">
						<div class="media-body nav qmgy_media_body"
							style="padding-left: 5rem;" id="youtext">
							
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-6 col-xs-12  ">
						<div class="media-body text-right nav qmgy_media_body"
							style="padding-right: 8rem;" id="zuotext">
						
						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="media qmgy_media text-center">
							<div class="media-right qmgy-img" style="float: right;">
								<div id="myCarousel1" class="carousel slide"
									data-ride="carousel">
									<div class="carousel-inner" id = "youtuaaa">
										<div class="item active">
											<a href="#" id="youtu1"> <img id="youimg1"
												src="/yungongyi/statics/main/images/welfare/welfare-10.png">
												<span id="youspan1" class="carousel-caption qmgy_carousel-caption">关于举办第六届“上海好心人节”通知</span>
											</a>
										</div>
										<div class="item">
											<a href="#" id="youtu2"> <img id="youimg2"
												src="/yungongyi/statics/main/images/welfare/welfare-12.jpg">
												<span id="youspan2" class="carousel-caption qmgy_carousel-caption">河北唐山：卑家店镇开展党的十九大精神
											</span>
											</a>
										</div>
										<div class="item">
											<a href="#" id="youtu3"> <img id="youimg3"
												src="/yungongyi/statics/main/images/welfare/welfare-15.jpg">
												<span id="youspan3" class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
											</a>
										</div>

										<div class="item">
											<a href="#" id="youtu4"> <img id="youimg4"
												src="/yungongyi/statics/main/images/welfare/welfare-17.jpg">
												<span id="youspan4" class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
											</a>
										</div>
									</div>
									<ol class="carousel-indicators">
										<li data-target="#myCarousel1" data-slide-to="0"
											class="active"></li>
										<li data-target="#myCarousel1" data-slide-to="1"></li>
										<li data-target="#myCarousel1" data-slide-to="2"></li>
										<li data-target="#myCarousel1" data-slide-to="3"></li>

									</ol>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
			<!--底部-->
			<jsp:include page="common/footer2.jsp"></jsp:include>
		</div>
	</div>
</body>

<script type="text/javascript"
	src="/yungongyi/statics/welfare/commonweal.js"></script>
</html>