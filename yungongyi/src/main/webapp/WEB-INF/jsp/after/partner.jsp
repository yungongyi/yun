<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="partner">

		<form class="input-group" id="formPartner">
			<input type="text" class="form-control" placeholder="合作名称"
				style="width: 55%" name="partnerName" />
			<button type="button" class="btn btn-default"
				style="margin-top: -10px;" name="serachpart">搜索</button>
			<button type="button" class="btn btn-default addpartner"
				style="margin-top: -10px;">新增</button>
		</form>
		<!--新增-->
		<ul class="text-center partnerul"
			style="list-style: none; display: none">
			<li><span>合作人：</span> <span> <input type="text" value=""
					id="addname">
			</span> <span id="name1"></span></li>
			<li><span>合作标志：</span> <span> <input type="text" value=""
					id="addmark">
			</span></li>
			<li><span>结束时间：</span> <span> <input type="date" value=""
					id="adddate">
			</span> <span id="date1"></span></li>
			<li><span>资源路径：</span> <input type="file" id="partnerfile">
				<!-- <input type="file" value="" id="addresourceid"></li> -->
			<li><span>合作状态：</span> <select id="addstateid">
					<option value="12">待合作</option>
					<option value="14">合作中</option>
					<option value="15">已解约</option>
			</select></li>
			<li>
				<!-- onclick='uploadFileById();' -->
				<button class="partneradd" name="partneradd" >提交</button>
			</li>
		</ul>
		<div style="padding: 5px;">
			<table class="partnertable" width="100%" id="partnertables">
				<p style="color: red" id="partnertishi"></p>
				<tr style="background: #cccccc;">
					<th>合作ID</th>
					<th>合作人</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>资源路径</th>
					<th>合作状态</th>
					<th>操作</th>
				</tr>
			</table>
			<!--查看-->
			<ul class="text-center getpartnerul"
				style="list-style: none; display: none">
			</ul>
		</div>
	</div>
</body>
</html>