<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="area">
		<p id="territoryWaring" style="color: red; font-size: 12px;"></p>
		<div class="text-center quyutable">
			<select class="combobox" id="provinces">
			</select> <select class="combobox" id="citys">
				<!-- </select> <select class="combobox" id="areas"> -->
			</select>
			<button id="showAddRegion">新增地区</button>
			<table id="regionList" class="resourcetable" width="100%">

			</table>
		</div>
		<div id="addRegionPanle" class="row"
			style="display: none; text-align: center;">
			<h1 class=" text-center">请在上方选择所属区域(不选择默认新增省)</h1>
			<div class="col-md-6">
				<lable>所属地区</lable>
				<input name="parentId" type=text readonly="readonly" value="" />
			</div>
			<div class="col-md-6">
				<lable>地区名字</lable>
				<input name="regionName" type=text value="" /><br>
			</div>
			<div class="col-md-6">
				<lable>简拼</lable>
				<input name="simpleEN" type=text value="" />
			</div>
			<div class="col-md-6">
				<lable>邮编</lable>
				<input name="regionCode" type="number" value="" /><br>
			</div>
			<div class="col-md-12">
				<button class="btn text-center" onclick="checkSubmit();">新增</button>
			</div>
		</div>
	</div>
</body>
</html>