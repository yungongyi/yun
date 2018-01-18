<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="message">
		<form style="padding-top: 5px">
			<p>
				<span class="form-group"><input type="text"
					placeholder="消息ID" class="input-sm" name="messageId" /> </span> <span
					class="form-group"><button type="button"
						name="searchMessage" class="btn btn-default"
						style="margin-top: -10px">查询</button></span>
			</p>
		</form>

		<div style="padding: 5px;">
			<table width="100%" id="seconddiv">
				<p style="color: red" id="messagetishi"></p>
				<tr style="background: #cccccc;">
					<th>消息ID</th>
					<th>消息内容</th>
					<th>发送人</th>
					<th>发送人电话</th>
					<th>消息状态</th>
					<th>发送时间</th>
					<th>接收人</th>
					<th>接收人电话</th>
					<th>操作</th>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>