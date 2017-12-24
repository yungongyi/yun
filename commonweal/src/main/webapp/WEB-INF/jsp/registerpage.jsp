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
<link rel="stylesheet" href="<%=basePath%>/static/css/registerpage.css" />
<title>注册</title>
<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.js"></script>
<!--雪花的js-->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/xuehua/winternetizer.js"></script>
<!--手写的表单验证-->
<script type="text/javascript"
	src="<%=basePath%>/static/js/loginpageJs/registervalidation.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/loginpageJs/getsendsms.js"></script>
<style>
</style>
</head>

<body>
	<div id="RegisterPage">
		<div class="container logincontainer">
			<div class="row">
				<div class="col-md-12 col-lg-12 col-xs-12 text-center">
					<h1 id="title">注册开启云公益</h1>
				</div>
				<div
					class="col-md-5 col-lg-4 col-xs-12  col-md-offset-4 col-lg-offset-4  text-center">
					<!--注册-->
					<div class="register">
						<form action="/commonweal/login/register.html" id="registerNo" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<input name="name" class="form-control" type="text"
										placeholder="昵称" /> <span class="warning isnickname"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<input name="phone" class="form-control" type="text"
										placeholder="请输入手机号码" /> <span class="warning isphone"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<input name="password" class="form-control" type="password"
										placeholder="密码" /> <span class="warning ispassword"></span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<div class="input-group">
										<input type="text" name="yanzhengma" class="form-control"
											placeholder="请输入验证码" /> <span
											class="input-group-addon yanzheng " style=""
											id="getzhuceyanzhengma">验证码</span>
									</div><span class="warning isyanzhengma"></span>
									<sppan class="waring ">${error}</sppan>
								</div>

							</div>
							<br>
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<button type="submit" class="btn btn-primary form-control"
										id="register">注册</button>
									<a class="gologin" target="_self" href="loginpage.html">已经注册过？去登录..</a>
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