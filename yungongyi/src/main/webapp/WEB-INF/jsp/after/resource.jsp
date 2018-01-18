<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="resource">
		<form class="input-group" id="formResource">
			<input name="searchBySourceId" type="text" class="form-control"
				placeholder="资源名称" style="width: 55%" /> <select
				id="searchBySourceType">
			</select>
			<button id="reourceById" type="button" class="btn btn-default"
				style="margin-top: -10px;" name="serachresource">搜索</button>
		</form>
		<div style="padding: 5px;">
			<table id="resourceList" class="resourcetable" width="100%">
				<tr style="background: #cccccc;">
					<th>资源ID</th>
					<th>资源路径</th>
					<th>资源类型</th>
					<th>操作</th>
				</tr>
			</table>
			
			<!--查看-->
			<ul class="text-center getresourceul"
				style="list-style: none; display: none">

			</ul>


		</div>
	</div>
</body>
</html>