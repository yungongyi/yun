<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="table">
		<p id="tablewaring"></p>
		<div class="text-center tables">
			<select class="combobox2 tableName" id="tableManagesList">

			</select> <select class="combobox0" id="stateList">
			</select> <select class="combobox1" id="typeList">
			</select>

			<div class="text-center">
				<a class="findtable">编辑模块表..</a> <br /> <a class="addstates">编辑状态..</a><br />
				<a class="addtypes">编辑类型..</a><br />
			</div>
		</div>
		<div class="tablediv text-center" style="display: none;">
			<input type="text" name="tableNameZH" placeholder="请输入表的中文名字" /><br />
			<input type="text" name="tableNameUK" placeholder="请输入表的英文名字" /><br />
			<button type="submit" class="btn btn-default tablefind">提交</button>
		</div>
		<div class="statediv text-center" style="display: none;">
			<select class="tableName" id="selectState">

			</select><br /> <input type="text" name="stateName" placeholder="请输入要添加的状态" /><br />
			<button type="submit" class="btn btn-default statesadd"
				id="stateSubmit">提交</button>
		</div>
		<div class="typediv text-center" style="display: none;">
			<select class="tableName" id="selectType">

			</select><br /> <input type="text" name="typeName" placeholder="请输入要添加的类型" /><br />
			<button type="button" class="btn btn-default typesadd"
				id="typeSubmit">提交</button>
		</div>
	</div>


</body>
</html>