$(function(){
	//点击系统通知选项卡
	$("#infoManage").click(function() {
		// 初始化系统通知
		initInfo();
	});
	/**
	 * get all info
	 */
	//初始化获取info通知表数据
	function initInfo() {
		$("#firsttable tr:not(:first)").empty("");
		$
		.ajax({
			url : "/commonweal/info/getInfo",
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				$.each(data,function(index) {
					$("#firsttable")
					.append(
							"<tr class='newtr'><th  class='firstspan'><span>"
							+ data[index].infoId
							+ "</span></th><th><span>"
							+ data[index].infoContent
							+ "</span></th><th><span>"
							+ getMyDate(data[index].infoCreateDate)
							+ "</span></th><th class='deleteInfo'><span class='col-xs-6' style='width: 50%;'>"
							+ " <a class='manage delInfo' value='"
							+ data[index].infoId
							+ "'>删除</a></span></th></tr>");
				});
				gopage(".newtr",1,4);
			}
		});
	}

	/**
	 * get info by infoId
	 */
	//根据通知id查询通知信息
	$("button[name='serach']")
	.click(
			function() {
				$("#firsttable tr:not(:first)").empty("");
				var infoId = $("input[name='infoId']").val();
				$
				.ajax({
					url : "/commonweal/info/getInfoById",
					type : "GET",
					data : "id=" + infoId,
					dataType : "JSON",
					success : function(result) {
						$
						.each(
								result,
								function(index) {
									$("#firsttable")
									.append(
											"<tr class='newtr'><th class='firstspan'><span>"
											+ result[index].infoId
											+ "</span></th><th><span>"
											+ result[index].infoContent
											+ "</span></th><th><span>"
											+ getMyDate(result[index].infoCreateDate)
											+ "</span></th>"
											+ "<th><span class='col-xs-6' style='width: 50%;'> "
											+ "<a class='manage delInfo'>删除</a>"
											+ "</span>"
											+ "</th></tr>");
								});
					}
				});
			});

	//点击提交按钮增加一条通知信息
	$(".infoadd").click(function() {
		var infoCon = $("#firstinput").val();
		if (infoCon == null || infoCon == "") {
			alert("通知内容不能为空!!!")
		} else {
			$.ajax({
				url : "/commonweal/info/addInfo/?content=" + infoCon,
				type : "GET",
				dataType : "text",
				success : function(data) {
					if (data == "success") {
						initInfo();
					} else if (data == "error") {
						alert("插入数据不能重复!!!");
					}
				}
			});
		}

	});
	//点击删除按钮删除一条通知信息
	$(".delInfo").live("click", function() {
		var id = $(this).attr("value");
		$.ajax({
			url : "/commonweal/info/delInfo/?id=" + id,
			type : "GET",
			dataType : "text",
			success : function(data) {
				if (data == "true") {
					$("#infotishi").html("删除成功！");	
					initInfo();
				} else {
					$("#infotishi").html("删除失败！");	
					initInfo();
				}

			}
		});
	});
});