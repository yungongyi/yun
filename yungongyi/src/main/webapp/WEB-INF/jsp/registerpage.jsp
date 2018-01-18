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
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />


<title>注册</title>
</head>

<body>
	<jsp:include page="common/header2.jsp"></jsp:include>
	<link rel="stylesheet"
		href="/yungongyi/statics/registerpage/registerpage.css" />
	<!--雪花的js-->
	<script type="text/javascript"
		src="/yungongyi/statics/loginPage/loginpageJs/xuehua/winternetizer.js"></script>
	<!--手写的表单验证-->
	<script type="text/javascript"
		src="/yungongyi/statics/registerpage/js/registervalidation.js"></script>
<!-- 	<script type="text/javascript"
		src="/yungongyi/statics/loginPage/loginpageJs/getsendsms.js"></script> -->
	<div id="RegisterPage">
		<div class="container logincontainer">
			<div class="row" style="background-color: rgba(255, 255, 255, 0.7);">
				
				<div class="col-md-12 col-lg-12 col-xs-12 text-center">
					<h1 id="title">注册开启云公益</h1>
				</div>
				<div
					class="col-md-5 col-lg-4 col-xs-12  col-md-offset-4 col-lg-offset-4  text-center">
					<!--注册-->
					<div class="register">
						<form id="registerNo" class="form-horizontal">
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
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2 ">
									<div class="input-group">
										<input type="text" name="yanzhengma" id="writezhuceyanzhengma"
											class="form-control " placeholder="请输入验证码" /> 
											<span class="input-group-addon yanzheng" id="checkPhoneCode">发送验证码</span>
									</div>
									<span class="warning isyanzhengma"></span> <span
										class="waring "></span>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="col-md-12 col-xs-12 col-lg-8 col-lg-offset-2">
									<button type="button" class="btn btn-primary form-control"
										id="register">注册</button>
									<a class="gologin" target="_self"
										href="/yungongyi/loginpage.html">已经注册过？去登录..</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="common/footer2.jsp"></jsp:include>
</body>

</html>