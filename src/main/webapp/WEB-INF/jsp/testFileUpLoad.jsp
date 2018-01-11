<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<input type="file" id="file">
	<button
		onclick='uploadFileById("file","/commonweal/partner/addPartner",12);'>提交</button>
	,
	<script src="/commonweal/static/js/jquery-1.12.4.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		function getAllPartner() {
			$.get("/commonweal/partner/getPartner", "JSON", function(data) {
				alert(data);
			});
		}
		function uploadFileById(id, url, type) {
			var file0 = document.getElementById(id).files[0];
			var fm = new FormData();
			fm.append("file0", file0);
			fm.append("type", type);
			$.ajax({
				url : url,
				type : 'POST',
				data : fm,
				contentType : false, //禁止设置请求类型
				processData : false, //禁止jquery对DAta数据的处理,默认会处理
				//禁止的原因是,FormData已经帮我们做了处理
				success : function(result) {
					//但需要你后端有返回值
					alert(result);
					getAllPartner();
				}
			});
		}
	</script>
</body>
</html>