$(function(){
	//点击用户消息选项卡
	$("#messageManage").click(function() {
		// 初始化用户消息
		initMessage();
	});
	/* 初始化用户信息表 */
	function initMessage() {
		$("#seconddiv tr:not(:first)").empty("");
		$
		.ajax({
			url : "/commonweal/message/getMessage",
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				$
				.each(
						data,
						function(index) {
							$("#seconddiv")
							.append(
									"<tr class='messagetr'><th><span>"
									+ data[index].messageId
									+ "</span></th>"
									+ "<th><span>"
									+ data[index].messageContent
									+ "</span></th>"
									+ "<th><span id='sendId'>"
									+ getSendNameById(data[index].personId)
									+ "</span></th>"
									+ "<th><span>"
									+ getTelById(data[index].personId)
									+ "</span></th>"
									+ "<th><span>"
									+ data[index].state.stateName
									+ "</span></th>"
									+ "<th><span>"
									+ getMyDate(data[index].sendDate)
									+ "</span></th>"
									+ "<th><span id='receiveId'>"
									+ getReceiveNameById(data[index].receiveId)
									+ "</span></th>"
									+ "<th><span>"
									+ getTelById(data[index].receiveId)
									+ "</span></th>"
									+ "<th>"
									+ "<span class='col-xs-6' style='width: 50%;'> "
									+ "<a class='manage delMessage' value='"
									+ data[index].messageId
									+ "'>删除</a></span></th></tr>");
						});
				gopage(".messagetr",1,4);
			}
		});
	} /* end get *//* initMessage */
	//根据消息id查询消息信息
	$("button[name='searchMessage']")
	.click(
			function() {
				$("#seconddiv tr:not(:first)").empty("");
				var messageId = $("input[name='messageId']").val();
				$
				.ajax({
					url : "/commonweal/message/getMessageById",
					type : "GET",
					async : false,
					data : "personId=" + messageId,
					dataType : "JSON",
					success : function(result) {
						$
						.each(
								result,
								function(index) {
									$("#seconddiv")
									.append(
											"<tr><th><span>"
											+ result[index].messageId
											+ "</span></th>"
											+ "<th><span>"
											+ result[index].messageContent
											+ "</span></th>"
											+ "<th><span id='sendId'>"
											+ getSendNameById(result[index].personId)
											+ "</span></th>"
											+ "<th><span>"
											+ getTelById(result[index].personId)
											+ "</span></th>"
											+ "<th><span>"
											+ result[index].state.stateName
											+ "</span></th>"
											+ "<th><span>"
											+ getMyDate(result[index].sendDate)
											+ "</span></th>"
											+ "<th><span id='receiveId'>"
											+ getReceiveNameById(result[index].receiveId)
											+ "</span></th>"
											+ "<th><span>"
											+ getTelById(result[index].receiveId)
											+ "</span></th>"
											+ "<th>"
											+ "<span class='col-xs-6' style='width: 50%;'>"
											+ "<a class='manage delMessage' value='"
											+ result[index].messageId
											+ "'>删除</a></span></th></tr>");
								});
					}
				});
			});
	//点击删除按钮删除一条消息信息
	$(".delMessage").live("click", function() {
		var messageId = $(this).attr("value");
		$.ajax({
			url : "/commonweal/message/delMessage/?messageId=" + messageId,
			type : "GET",
			dataType : "text",
			success : function(data) {
				if (data == "true") {
					$("#messagetishi").html("删除成功！");	
					initMessage();
				} else {
					$("#messagetishi").html("删除失败！");	
					initMessage();
				}
			}
		});
	});
});