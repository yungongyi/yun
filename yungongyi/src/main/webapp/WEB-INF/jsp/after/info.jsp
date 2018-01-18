<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
	<div class="tab-pane fade" id="info">
		<form class="input-group">
			<input type="text" class="form-control" placeholder="通知ID"
				style="width: 55%" name="infoId" />
			<button type="button" class="btn btn-default"
				style="margin-top: -10px;" name="serach">搜索</button>
			<button type="button" class="btn btn-default addinfo"
				style="margin-top: -10px;">新增</button>
		</form>

		<ul class="text-center infoul" style="list-style: none; display: none">
			<li><span>通知内容：</span> <span> <input type="text" value=""
					id="firstinput">
			</span></li>
			<li>
				<button class="infoadd">提交</button>
			</li>

		</ul>
		<div style="padding: 5px;">
			<table class="infotable" width="100%" id="firsttable">
				<p style="color: red" id="infotishi"></p>
				<tr style="background: #cccccc;">
					<th>通知ID</th>
					<th>通知内容</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>

			</table>
		
		</div>
	</div>
	
</body>
</html>