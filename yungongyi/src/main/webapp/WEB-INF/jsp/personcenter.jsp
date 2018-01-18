<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<title>个人中心</title>
<body>
	<jsp:include page="common/header2.jsp"></jsp:include>
	<link href="/yungongyi/statics/personcenter/css/personCenter.css"
		rel="stylesheet" />
	<script type="text/javascript"
		src="/yungongyi/statics/personcenter/js/personcenter.js"></script>
	<img alt=""
		src="/yungongyi/statics/main/images/personcenter/percentCenter_bg01.png"
		style="width: 100%; height: 100%; position: fixed; background-size: cover; margin-top: 0px">
	<!-- "src/main/webapp/statics/image/personcenter/percentCenter_bg01.png" -->
	<input id="personId" value="${sessionScope.userId}" />
	<div id="personcenterpage">
		<div class="container">
			<div id="per_head" class="row" style="margin-top: 10em">
				<div class="col-xs-12 col-md-12 ">
					<div class="media">
						<div class="media-left">
							<img class="headimg img-circle" src="" />
						</div>
						<div class="media-body">
							<p>
								<span class="h2 personname" ></span>的个人中心
							</p>
							<span class="h3" class="personstate">状态：正常</span> <a
								id="updatePwd_btn" class="h4 "> <span
								class="glyphicon glyphicon-edit"></span>修改密码
							</a>
						</div>
						<!--修改密码-->
						<div id="personPwd" style="display: none;">

							<div class="col-xs-8 col-md-3 col-md-offset-1 ">
								<input class="form-control" type="text" placeholder="请输入验证码"
									name="Uyanzhengma" />
								<p id="updatepasswaring"></p>
							</div>
							<div class="col-xs-4 col-md-2 ">
								<button class="btn btn-info" type="button" id="sendyzm">发送验证码</button>
							</div>
							<div class="col-xs-8 col-md-4 ">
								<input class="form-control" type="text" placeholder="请输入新密码"
									name="Unewpassword" />
							</div>
							<div class="col-xs-4 col-md-2 ">
								<button class="btn btn-success" type="button" id="updatepass">提交</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="per_up" class="row">
				<div class="col-md-3 col-sm-3 col-xs-12">
					<ul class="nav navbar-tabs"
						style="background-color: rgba(255, 255, 255, 0.5)">
						<li class="list-group-item active"><a href="#per_1"
							data-toggle="tab"><span class="glyphicon glyphicon-user"></span>个人信息</a>
						</li>
						<li class="list-group-item createnotice"><a href="#per_2"
							data-toggle="tab"> <span class="glyphicon glyphicon-send"></span>发布启事
						</a></li>
						<li class="list-group-item historymessage"><a href="#per_3"
							data-toggle="tab"><span class="glyphicon glyphicon-bell"></span>消息通知</a></li>
						<li class="list-group-item historynotice"><a href="#per_4"
							data-toggle="tab"><span class="glyphicon glyphicon-time "></span>历史记录</a></li>
					</ul>
					<div class="sendMassage"
						style="background-color: rgba(255, 255, 255, 0.5)">
						<p class="h3 text-success">发送短消息</p>
						<p id="sendmessagewaring"></p>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-phone"></span></span> <input type="text"
								class="form-control " name="receivephone" placeholder="要发送的手机号">
						</div>
						<br>
						<div class="input-group">
							<input type="text" class="form-control" name="shortmessage"
								placeholder="不超过20个字" /> <span class="input-group-btn">
								<button class="btn btn-default sendmessage" type="button">发送</button>
							</span>
						</div>
					</div>
				</div>
				<div class="col-md-9 col-sm-9 col-xs-12 tab-content"
					style="background-color: rgba(255, 255, 255, 0.5)">
					<!--个人信息-->
					<div class="tab-pane fade in active" id="per_1">
						<h3 class="text-info text-right">个人信息</h3>
						<p id="personwaring"></p>
						<ul class="list-group">
							<li class="list-group-item">头像: <img src=""
								class=" headimg img-circle" style="width: 3em;" /> <a
								href="#personImg" data-toggle="collapse"
								class="glyphicon glyphicon-edit badge"><span>修改</span></a>
								<div id="personImg" class="collapse">
									<div class="input-group">
										<input type="file" name="headimg" id="headimg"
											class="form-control"> <span class="input-group-btn">
											<button class="btn btn-default updateheadimg " type="button">提交</button>
										</span>
									</div>
								</div>

							</li>
							<li class="list-group-item">昵称: <span class="personname"></span>
								<a href="#personName" data-toggle="collapse"
								class="glyphicon glyphicon-edit badge"><span>修改</span></a>
								<div id="personName" class="collapse">
									<div class="input-group">
										<input type="text" name="personname" class="form-control">
										<span class="input-group-btn">
											<button class="btn btn-default updateperonname" type="button">提交</button>
										</span>
									</div>
								</div>
							</li>
							<li class="list-group-item">性别: <span class="personsex"></span>
								<a href="#personSex" data-toggle="collapse"
								class="glyphicon glyphicon-edit badge"><span>修改</span></a>
								<div id="personSex" class="collapse">
									<div class="input-group">
										<select class="form-control selectpersonsex">
											<option value="0">男</option>
											<option value="1">女</option>
										</select> <span class="input-group-btn">
											<button class="btn btn-default updatepersonsex" type="button">提交</button>
										</span>
									</div>
								</div>
							</li>
							<li class="list-group-item">手机号: <span class="personphone"></span>
								<a href="#personPhone" data-toggle="collapse"
								class="glyphicon glyphicon-edit badge"><span>修改</span></a>
								<div id="personPhone" class="collapse">
									<div class="input-group">
										<input type="text" class="form-control" name="peronphone" />
										<span class="input-group-btn">
											<button class="btn btn-default updatephone" type="button">提交</button>
										</span>
									</div>
								</div>
							</li>
							<li class="list-group-item">地址: <span class="personaddress"></span>
								<a href="#personAddress" data-toggle="collapse"
								class="glyphicon glyphicon-edit badge"><span
									id="updateaddressspan">修改</span></a>
								<div id="personAddress" class="collapse">
									<div class="input-group">
										<select class="form-control selectpersonregion">
										</select> <span class="input-group-btn">
											<button class="btn btn-default updateregion" type="button">提交</button>
										</span>
									</div>
								</div>
							</li>
						</ul>
					</div>
					<!--发布启事-->
					<div class="tab-pane fade " id="per_2">
						<h3 class="text-danger">发布启事</h3>
						<div class="end_align">
							<span class="col-md-12 col-xs-12 text-right"
								id="savenoticewaring"></span>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请上传照片</span>
							<div class="col-md-9 col-xs-8">
								<input id="noticeimg" type="file" class="form-control">
							</div>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请填写标题</span>
							<div class="col-md-9 col-xs-8">
								<input name="noticetitle" type="text" placeholder="标题不要太长哦"
									class=" form-control">
							</div>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请选择启事类别</span>
							<div class="col-md-9 col-xs-8">
								<select name="noticetype" class="form-control">
								</select>
							</div>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请选择启事范围</span>
							<div class="col-md-9 col-xs-8">
								<select name="noticeregion" class="form-control">
								</select>
							</div>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请填写详细描述</span>
							<div class="col-md-9 col-xs-8">
								<textarea name="noticedetail" class="form-control"
									placeholder="请对启事涉及的人或物进行详细描述"></textarea>
							</div>
						</div>
						<div class="end_align">
							<span class="col-md-3 col-xs-4">请填写启事有效时长</span>
							<div class="col-md-9 col-xs-8">
								<input name="noticeaging" class="form-control" type="number"
									placeholder="单位是天哦" />
							</div>
						</div>
						<div class="end_align">
							<input class="col-md-12  form-control btn-success saveNotice"
								type="button" value="马上发布" />
						</div>
					</div>
					<!--消息通知-->
					<div class="tab-pane fade " id="per_3">
						<h3 class="text-right text-success">消息通知</h3>
						<p id="historymessagewaring"></p>
						<ul class="list-group historymessageul">
						</ul>

					</div>
					<!--历史记录-->
					<div class="tab-pane fade " id="per_4">
						<h3 class="text-danger">历史记录</h3>
						<p id="deletenoticewaring"></p>
						<ul class="historynoticeul">
						</ul>

					</div>
					<div id="paging" style='text-align: center'></div>
				</div>
			</div>
		</div>
	</div>
</head>
<script>
	/* 显示修改密码 */
	$("#updatePwd_btn").click(function() {
		$("#personPwd").fadeToggle();
	});
	/* 文档加载完成  */
	$(function() {
		var personId = $("#personId");
		if (personId.val() != null && personId.val() != "") {
			/* 获取个人信息  */
			$.post("/commonweal/personCenter/getPersonById", {
				"personId" : personId
			}, function(data) {
				alert(data);
			});
		} else {
			/*返回上一页 */
			/* setTimeout(function(){
				window.history.back(); 
			},1500);
			 */
		}

	});
</script>

</body>