<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath%>/static/css/loginpage.css" />
<title>登录</title>
<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.js"></script>
<!--雪花的js-->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/xuehua/winternetizer.js"></script>
<!--图片验证码js-->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/yanzhengma/gVerify.js"></script>
<!--手写表单验证-->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/loginvalidation.js"></script>
<!-- 获取验证码 -->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/getsendsms.js"></script>
<style>
</style>
</head>

<body>
	<div id="LoginPage">
		<div class="container logincontainer">
		 
			<div class="row">
				<div class="col-md-12 col-lg-12 col-xs-12 text-center">
					<h1 id="title">登录开启云公益</h1>
				</div>
				<div class="col-md-12 col-lg-12 col-xs-12">
					<div class="logintype col-md-12 col-lg-12 col-xs-12 text-center">
						<span class="loginkey active">普通登录</span> &nbsp;&nbsp; <span
							class="fastloginkey">快速登录</span>
					</div>
				</div>
				<div
					class="col-md-5 col-lg-4 col-xs-12   col-md-offset-4 col-lg-offset-4  text-center">
					<!--普通登录-->
					<div class="loginvalue">
						<form id="submit" action="login/doLogin.html" method="post"
							class="form-horizontal">
							<row>
							<div class="form-group ">
								<div class="col-md-12 col-xs-12 col-lg-8  col-lg-offset-2">
									<input name="phone" class="form-control" type="text"
										placeholder="请输入手机号码" /> <span class="warning isphone"></span>
								</div>

							</div>
							</row>
							<row class="text-center">
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<input name="password" class="form-control" type="password"
										placeholder="请输入密码" /> <span class="warning ispassword"></span>
									<span class="warning ">${error}</span>
								</div>
							</div>
							</row>
							<row class="text-center">
							<div class="form-group">
								<div
									class="col-md-12 col-xs-12 col-lg-6 col-sm-12 col-lg-offset-2">
									<div class="yanzhengmadiv">
										<input name="yanzhengma" class="form-control" type="text"
											placeholder="请输入验证码" /> <span class="warning isyanzhengma"></span>
										<div class="label input-group-btn " id="v_container"></div>
									</div>
								</div>

							</div>
							</row>
							<row class="text-center">
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<button type="submit" id="login"
										class=" btn btn-primary form-control">登录</button>
									<a class="goregister" target="_self" href="registerpage.html">还没有账号？去注册..</a>
								</div>
							</div>
							</row>

						</form>
					</div>
					<!--快速登录-->
					<div class="loginfast" style="display: none;">
						<form id="fastsubmit" action="login/fastLogin.html" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<input name="fphone" class="form-control" type="text"
										placeholder="请输入手机号码" /> <span class="warning fisphone"></span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<div class="input-group">
										<input type="text" class="form-control" name="fyanzhengma"
											placeholder="请输入验证码" /> <span id="sendsms"
											class="input-group-addon yanzheng">验证码</span>
									</div>
									<span class="warning fisyanzhengma"></span> <br /> <span
										class="warning">${error}</span>
								</div>
							</div>
							<br />
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2 ">
									<button id="flogin" type="submit"
										class="btn btn-primary form-control">登录</button>
									<a class="goregister" target="_self"
										href="<%=basePath%>/jsp/registerpage.jsp">还没有账号？去注册..</a>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
			$(function() {
				//点击登录 或者快速登录时 表单切换
				$('.loginkey').click(function() {
					$(this).addClass('active');
					$('.fastloginkey').removeClass('active');
					$(".loginfast").hide(500);
					$(".loginvalue").show(500);

				});
				$('.fastloginkey').click(function() {
					$(this).addClass('active');
					$('.loginkey').removeClass('active');
					$(".loginvalue").hide(500);
					$(".loginfast").show(500);
				});
				//单击发送按钮
				$('.yanzheng').click(function() {
					//隐藏发送按钮
					$(this).html('10');
					//获取倒计时时间
					var daojishi = $('.yanzheng').html();
					//开始倒计时
					var dingshi = setInterval(function() {
						//每隔一秒倒计时减去1
						daojishi = (daojishi - 1)
						//重新赋值给倒计时控件以显示
						$('.yanzheng').html(daojishi);
						//当倒计时为0时候 结束倒计时
						if(daojishi == 0) {
							//更改发送按钮的文本并显示
							$('.yanzheng').html('重新发送验证码');
							//清除定时
							clearInterval(dingshi);
						}
					}, 1000);
				});
			
				 
			});
		</script>
</body>

</html>
