<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"">
<title>Insert title here</title>
</head>
<body>
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
				<p style="color: red" id="usertishi"></p>
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
		</div>
	</div>
</body>
</html>