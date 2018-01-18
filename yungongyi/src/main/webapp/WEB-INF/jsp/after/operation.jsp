<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="operation">
		<p>
			<span class="form-group"> 操作人：<input type="text"
				placeholder="请输入管理员姓名" class="input-sm" name="operationPersonName" />
			</span> <span class="form-group"><button type="submit"
					class="btn btn-default" style="margin-top: -10px;"
					id="operationsearch">查询</button></span>
		</p>
		<div>
			<table width="100%" id="operationlist">
				<tr style="background: #cccccc;">
					<th>操作编号</th>
					<th style='display:none'>操作ID</th>
				    <th>操作人</th>
					<th>操作时间</th> 
					<th>操作描述</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>