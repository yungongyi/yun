<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
	<head lang="en">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/bootstrap.css" />
		<title>启事大厅</title>
		<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
		<script src="<%=basePath%>/static/js/bootstrap.js"></script>
		<link rel="stylesheet" href="<%=basePath%>/static/css/NoticeHall.css">
	</head>
	<style>
		body {
			background-color: #f2efe6;
		}
	</style>

	<body>
		 
		<header id="theheader" style="margin:0px; padding: 0px;line-height: 0px;" class=" ">
			<object style="border:0px" type="text/x-scriptlet" data="<%=basePath%>/jsp/common/header.jsp" width=100% height=55px></object>
		</header>
		<div id="NoticeHall" class="container">
			<div style="background: rgba(0,0,0,0.7);border: 1px silver solid;border-radius: 5px;">
				<div id="halloption" class="container ">
					<!--选择区-->
					<div class="row">
						<div class="col-md-2 col-lg-2 col-xs-3 text-center">
							<span>地区：</span>
						</div>
						<div class="col-md-10 col-lg-10 col-xs-9 ">
							<ul class="area">
								<li class="areas actives " value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</li>
								<li class="areas" value="1">中原区</li>
								<li class="areas" value="2">二七区</li>
								<li class="areas" value="3">金水区</li>
								<li class="areas" value="4">管城区</li>
								<li class="areas" value="5">惠济区</li>
								<li class="areas" value="6">上街区</li>
							</ul>
							<select class="phonearea" onchange="selectOnchang(this)">
								<option value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</option>
								<option value="1">中原区</option>
								<option value="2">二七区</option>
								<option value="3">金水区</option>
								<option value="4">管城区</option>
								<option value="5">惠济区</option>
								<option value="6">上街区</option>
							</select>
						</div>
					</div>
					<hr />
					<!--用户类型-->
					<div class="row">
						<div class="col-md-2 col-lg-2 col-xs-3 text-center">
							<span>搜索：</span>
						</div>
						<div class="col-md-8 col-lg-8 col-xs-9 ">
							<ul class="persontype">
								<li class="persontypes actives" value="0">全部</li>
								<li class="persontypes" value="1">失主</li>
								<li class="persontypes" value="2">得主</li>
							</ul>
							<select class="phonepersontype" onchange="selectOnchang(this)">
								<option value="0">全部</option>
								<option value="1">失主</option>
								<option value="2">得主</option>
							</select>
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
								<input type="text" class="form-control" placeholder="请输入启事关键词" />
								<span class="input-group-addon">
							<span class="search glyphicon glyphicon-search"></span>
								</span>
							</div>
						</div>
					</div>
					<br />
				</div>
			</div>
			<div style="background-color: rgba(0,0,0,0.2);margin-top: 10px;border: 1px silver solid;border-radius: 5px;">
				<div id="noticehall" class="container">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-xs-12 ">
							<ul class="nav nav-tabs" style="margin:0px 30px;">
								<li class="active tabs">
									<a id="findperson" href="#persons" data-toggle="tab">找人</a>
								</li>
								<li class="tabs">
									<a id="findgood" href="#goods" data-toggle="tab">找物</a>
								</li>
								<li class="tabs">
									<a id="findpast" href="#past" data-toggle="tab">历史记录</a>
								</li>
							</ul>
							<div class="tab-content">
								<!--框1-->
								<div class="tab-pane fade in active" id="persons">
									<!--寻人启事-->
									<div class="col-lg-9 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-12 col-xs-12" id="firstdiv">
											<span class="droptitle" style="margin-left: -10px;">寻人启事</span>
										</div>
										<div class="row">
											<!--找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div   class="thumbnail ">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">黄日跳&nbsp;&nbsp;女&nbsp;&nbsp;21岁</p>
														<p class="text-center"></p>
														<p>花衬衣，牛仔裤，黑色书包，于昨天上午走失</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物2.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">陈好 &nbsp;&nbsp;女 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</p>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<!--第二行找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">黄日跳&nbsp;&nbsp;女&nbsp;&nbsp;21岁</p>
														<p class="text-center"></p>
														<p>花衬衣，牛仔裤，黑色书包，于昨天上午走失</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-4 col-md-4 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物2.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">陈好 &nbsp;&nbsp;女 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--寻人启事中的寻物启事-->
									<div class="col-lg-3 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-6 col-xs-12" id="firstdiv">
											<span class="droptitle">&nbsp;&nbsp;&nbsp;&nbsp;寻物启事</span>
										</div>
										<div class="col-md-12 col-lg-12 col-xs-12">
											<div class="col-md-6 col-lg-12 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/工作证.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在食堂丢了一个工作证，上面有姓名联系方式，捡到必有重谢</p>
													</div>
												</div>
											</div>
											<div class="col-md-6 col-lg-12 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/挎包图片.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在食堂丢了一个挎包，上面有身份证，钱包以及联系方式，捡到必有重谢</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--框2-->
								<div class="tab-pane fade" id="goods">
									<!--寻物启事-->
									<div class="col-lg-9 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-12 col-xs-12" id="seconddiv">
											<span class="droptitle">&nbsp;&nbsp;&nbsp;寻物启事</span>
										</div>
										<div class="col-lg-12 col-md-12 col-xs-12">
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本俱乐部收银台在今天上午拾到手提包一个，内装人民币若干元，以及手机等物，望失主前来认领。
														</p>
													</div>
												</div>
											</div>
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
													</div>
												</div>
											</div>
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/校园卡.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在食堂丢了一个校园卡，颜色是绿色，内有50块钱的洗衣费</p>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-xs-12">
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/钥匙.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在人民路捡到一串钥匙，请失主看见与我联系</p>
													</div>
												</div>
											</div>
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本俱乐部收银台在今天上午拾到手提包一个，内装人民币若干元，以及手机等物，望失主前来认领。
														</p>
													</div>
												</div>
											</div>
											<!--找物-->
											<div class="col-lg-4 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
													</div>
												</div>
											</div>
										</div>

									</div>
									<!--寻物启事中的寻人启事-->
									<div class="col-lg-3 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-6 col-xs-12" id="seconddiv">
											<span class="droptitle">&nbsp;&nbsp;&nbsp;寻人启事</span>
										</div>
										<div class="col-md-12 col-lg-12 col-xs-12">
											<div class="col-md-6 col-lg-12 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">黄日跳&nbsp;&nbsp;女&nbsp;&nbsp;21岁</p>
														<p class="text-center"></p>
														<p>花衬衣，牛仔裤，黑色书包，于昨天上午走失</p>
													</div>
												</div>
											</div>
											<div class="col-md-6 col-lg-12 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物.jpg" class="img-responsive img-rounded" />
													<div class="caption ">
														<p class="text-center">黄日跳&nbsp;&nbsp;女&nbsp;&nbsp;21岁</p>
														<p class="text-center"></p>
														<p>花衬衣，牛仔裤，黑色书包，于昨天上午走失</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--框3 历史记录-->
								<div class="tab-pane fade" id="past">
									<!--历史记录中的寻物启事-->
									<!--寻物启事-->
									<div class="col-lg-7 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-12 col-xs-12" id="seconddiv">
											<span class="droptitle" style="margin-left: -10px;">&nbsp;&nbsp;&nbsp;寻物启事</span>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-xs-12">
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-12 col-md-12 col-xs-12">
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
												<!--找物-->
												<div class="col-lg-4 col-md-4 col-xs-12">
													<div class="thumbnail">
														<img src="<%=basePath%>/static/image/NoticeHallArticles/钱包1.jpg" class="img-responsive img-rounded" />
														<div class="caption ">
															<p>本人于昨天下午在教师丢了一个钱包，内有身份证，人民币等捡到必有重谢</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--历史记录中的寻人启事-->
									<div class="col-lg-5 col-md-12 col-xs-12">
										<div class="col-lg-12 col-md-12 col-xs-12" id="thirddiv">
											<span class="droptitle" style="margin-left: -10px;">寻人启事</span>
										</div>
										<div class="row">
											<!--第一行找人-->
											<div class="col-lg-6 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-6 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<!--第二行找人-->
											<div class="col-lg-6 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
											<!--找人-->
											<div class="col-lg-6 col-md-6 col-xs-12">
												<div class="thumbnail">
													<img src="<%=basePath%>/static/image/NoticeHallPerson/人物1.jpg" class="img-responsive img-rounded" />
													<div class="caption">
														<p class="text-center">金正国 &nbsp;&nbsp;男 &nbsp;&nbsp;30岁</p>
														<p class="text-center"></p>
														<p>深色戴帽卫衣，棕色裤子，棕色拖鞋</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<footer></footer>	 
		<script>
			$.get("footer.html", "HTML", function(data) {
				$('footer').html(data);
			});
			/*加载头尾*/
			$.get("header.html", "HTML", function(data) {
				$('header').html(data);

			});
			$(function() {
				//大于320px点击选项条件的jq
				$('.areas').click(function() {
					$(this).addClass('actives');
					$(this).siblings().removeClass('actives');
					alert($(this).html() + ' 的值为 ' + $(this).val());
				});

				$('.persontypes').click(function() {
					$(this).addClass('actives');
					$(this).siblings().removeClass('actives');
					alert($(this).html() + ' 的值为 ' + $(this).val());
				});

			});
			//小于320px的下拉框jq
			function selectOnchang(obj) {
				alert(obj.selectedIndex);
			};

			$('.thumbnail').hover(function() {

				$(this).children('.caption').show(500);

			}, function() {
				$(this).children('.caption').hide(500);

			});
			
			//点击图片，页面跳转
			$('.thumbnail').click(function(){
			   window.location.href = "noticeinfo.html";
			});
		</script>
	</body>

</html> 