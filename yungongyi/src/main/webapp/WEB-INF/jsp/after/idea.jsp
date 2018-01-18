<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 
</head>
<body>
	<div class="tab-pane fade" id="idea">
		<form style="padding-top: 5px" id="formIdea">
			<p>
				<span class="form-group"><input type="text"
					placeholder="意见ID" name="iedaId" class="input-sm" /> </span> <span
					class="form-group"><button type="button" name="searchIdea"
						class="btn btn-default" style="margin-top: -10px;">查询</button></span>
			</p>
		</form>
		<div style="padding: 5px;">
			<table width="100%" id="thirddiv">
				<p style="color: red" id="ideaishi"></p>
				<tr style="background: #cccccc;">
					<th>意见ID</th>
					<th>意见内容</th>
					<th>意见人联系方式</th>
					<th>意见人邮箱</th>
					<th>创建时间</th>
					<th>处理状态</th>
					<th>操作</th>
				</tr>
			</table>
			<ul class="text-center ideaul"
				style="list-style: none; display: none">
			</ul>
		</div>
	</div>
</body>
</html>