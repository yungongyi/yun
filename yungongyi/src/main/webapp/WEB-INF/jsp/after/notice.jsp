<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="notice">
		<form class="input-group" id="fromnotice">
			<input type="text" placeholder="请输入启事状态" name="noticeTittle" /> <input
				type="date" name="noticeDate">
			<button type="button" class="btn btn-default"
				style="margin-top: -10px;" name="serachnotice">搜索</button>
		</form>
		<div>

			<table class="noticetable" width="100%" id="noticetable">
				<p style="color: red" id="noticetishi"></p>
				<tr style="background: #cccccc;">
					<th>ID</th>
					<th>标题</th>
					<th>区县</th>
					<th>联系方式</th>
					<th>发布时间</th>
					<th>启事状态</th>
					<th>启事类型</th>
					<th>操作</th>
				</tr>
			</table>
		
			<ul class="text-center noticeul"
				style="list-style: none; display: none;">
			</ul>
		</div>
	</div>
</body>
</html>