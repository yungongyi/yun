$(function(){
	//点击用户反馈选项卡
	$("#ideaManage").click(function() {
		// 初始化用户反馈
		initIdea();
	});
	/* 3.初始化意见表 */
	function initIdea() {
		$("#thirddiv tr:not(:first)").empty("");
		$.ajax({
			url : "/commonweal/idea/getIdea",
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				$.each(	data,function(index) {
					$("#thirddiv").append(
									"<tr class='ideatr'><th><span>"
									+ data[index].ideaId
									+ "</span></th>"
									+ "<th><span>"
									+ data[index].ideaContent
									+ "</span></th>"
									+ "<th><span>"
									+ getTelById(data[index].personId)
									+ "</span></th>"
									+ "<th><span>"
									+ data[index].personEmail
									+ "</span></th>"
									+ "<th><span>"
									+ getMyDate(data[index].ideaCreateDate)
									+ "</span></th>"
									+ "<th><span>"
									+ data[index].state.stateName
									+ "</span></th>"
									+ "<th><span class='col-xs-6' style='width: 50%'> "
									+ "<a class='ideaInfo' value='"
									+ data[index].ideaId
									+ "'>查看</a></span>"
									+ "<span class='col-xs-6' style='width: 50%;'> "
									+ "<a class='manage delIdea' value='"
									+ data[index].ideaId
									+ "'>删除</a></span></th></tr>");
						});				
				gopage(".ideatr",1,4);
			}
		});

	}
	//根据意见id查询意见信息
	$("button[name='searchIdea']").click(
			function() {
				$("#thirddiv tr:not(:first)").empty("");
				var iedaId = $("input[name='iedaId']").val();
				$
				.ajax({
					url : "/commonweal/idea/getIdeaById",
					type : "GET",
					data : "ideaId=" + iedaId,
					dataType : "JSON",
					success : function(result) {
						$("#thirddiv tr:not(:first)").empty("");
						$
						.each(
								result,
								function(index) {
									$("#thirddiv")
									.append(
											"<tr><th><span>"
											+ result[index].ideaId
											+ "</span></th>"
											+ "<th><span>"
											+ result[index].ideaContent
											+ "</span></th>"
											+ "<th><span>"
											+ getTelById(result[index].personId)
											+ "</span></th>"
											+ "<th><span>"
											+ result[index].personEmail
											+ "</span></th>"
											+ "<th><span>"
											+ getMyDate(result[index].ideaCreateDate)
											+ "</span></th>"
											+ "<th><span>"
											+ result[index].state.stateName
											+ "</span></th>"
											+ "<th><span class='col-xs-6' style='width: 50%'>"
											+ "<a class='ideaInfo' value='"
											+ result[index].ideaId
											+ "'>查看</a>"
											+ "</span><span class='col-xs-6' style='width: 50%;'> "
											+ "<a class='manage delIdea' value='"
											+ result[index].ideaId
											+ "'>删除</a></span></th></tr>");
								});
					}
				});
			});
	//点击查看显示意见详细信息做修改
	$(".ideaInfo")
	.live(
			"click",
			function() {
				$("#formIdea").hide();
				$(".ideaul").show();
				$("#thirddiv").hide();
				var ideaId = $(this).attr("value");
				var stateId = "";
				$
				.ajax({
					url : "/commonweal/idea/getIdeaById",
					type : "GET",
					data : "ideaId=" + ideaId,
					dataType : "JSON",
					async : false,// 哪天那个 让ajax同步的属性
					success : function(result) {
						$(".ideaul").empty("");
						$
						.each(
								result,
								function(index) {
									stateId = result[index].state.stateId;
									// 把数据库查询的状态ID赋值给这个变量
									$(".ideaul")
									.append(
											"<li><span>意见ID：</span> <span id='ideaSubmit'>"
											+ result[index].ideaId
											+ "</span></li>"
											+ "<li><span>意见内容：</span> <span>"
											+ result[index].ideaContent
											+ "</span></li>"
											+ "<li><span>意见人联系方式：</span> <span>"
											+ getTelById(result[index].personId)
											+ "</span></li>"
											+ "<li><span>意见人邮箱：</span> <span>"
											+ result[index].personEmail
											+ "</span></li>"
											+ "<li><span>创建时间：</span> <span>"
											+ getMyDate(result[index].ideaCreateDate)
											+ "</span></li>"
											+ "<li><span>处理状态：</span> <select id='idea_Id'>"
											+	"	<option value='5'>已查看</option>"
											+	"	<option value='6'>未查看</option>"		
											+	"</select></li>"
											+ "<li>"
											+ "<li>"
											+ "<button class='ideaUpdate' value='"+result[index].ideaId+"'>提交</button>"
											+ "<button class='ideareturn'>返回</button>"
											+ "</li>");
								});
						// 传过去
						//$("#idea_Id").html(stateList(stateId));
						$("#idea_Id option[value='"+stateId+"']").attr("selected","selected");
					}
				});
			});


	//点击返回按钮
	$(".ideareturn").live("click", function() {
		$("#thirddiv").show();
		$(".ideaul").hide();
		$("#formIdea").show();
	});
	//读取意见的状态
	/*function stateList(stateId) {
		var name='意见表';
		$.ajax({
			url : "/commonweal/state/getStateByTableId",
			data : "name"+name,
			type : "GET",
			async : false,
			dataType : "json",
			success : function(data) {
				$.each(data, function(index, obj) {
					// 如果传过来的ID和你这里的ID相同 给他一个属性
					if (obj.stateId == stateId) {
						option = option + '<option value="' + obj.stateId
						+ '" selected >' + obj.stateName + '</option>';
					} else {
						option = option + '<option value="' + obj.stateId + '" >'
						+ obj.stateName + '</option>';
					}
				});
			}
		});
		return option;
	}*/
	//意见修改（提交按钮的单击事件）
	$(".ideaUpdate").live(
			"click",
			function() {
				var ideaSubmit1 = $(this).attr("value");
				var stateId=$("#idea_Id").val();
				$.ajax({
					url : "/commonweal/idea/updateIdeaById?ideaId=" + ideaSubmit1
					+ "&stateId=" + stateId,
					type : "GET",
					async : false,
					success : function() {
						// 写回调函数吧 有初始化函数
						$("#ideaishi").html("修改成功！");	
						initIdea();
						$("#thirddiv").show();
						$(".ideaul").hide();
					}
				});
			});

	//点击删除按钮删除一条意见信息
	$(".delIdea").live("click", function() {
		var ideaId = $(this).attr("value");
		$.ajax({
			url : "/commonweal/idea/delIdea",
			data : "ideaId=" + ideaId,
			type : "GET",
			dataType : "text",
			success : function(data) {
				if (data == "true") {
					$("#ideaishi").html("删除成功！");	
					initIdea();
				} else {
					$("#ideaishi").html("删除成功！");	
					initIdea();
				}

			}
		});
	});
});