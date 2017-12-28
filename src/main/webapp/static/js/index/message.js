/**
 * 
 */
$(document).ready(
	function() {
// 将ajax获取的时间戳(获取过来它自动转换为时间戳)转换成时间(年:月:日 时:分:秒)
	function getMyDate(str) {
		var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
			.getMonth() + 1, oDay = oDate.getDate(), oHour = oDate
			.getHours(), oMin = oDate.getMinutes(), oSen = oDate
			.getSeconds(), oTime = oYear + '-'
		    + getzf(oMonth) + '-' + getzf(oDay) + ' '
		    + getzf(oHour) + ':' + getzf(oMin) + ':'
			+ getzf(oSen);
			return oTime;
			};
	// 补0操作
	function getzf(num) {
		if (parseInt(num) < 10) {
			num = '0' + num;
		}
			return num;}
					/**
					 * get all message
					 */
					// 初始化获取message通知表数据
					function initMessage() {
						$.ajax({
									url : "/commonweal/message/getMessage",
									type : "GET",
									dataType : "JSON",
									success : function(data) {
										$("#seconddiv tr:not(:first)").empty("");
										$.each(data,function(index) {
											$("#seconddiv").append(
												"<tr><th><span>"+data[index].messageId+"</span></th>"
												+"<th><span>"+data[index].messageContent+"</span></th>"
												+"<th><span id='sendId'>"+getSendTelById(data[index].personId)+"</span></th>"
												+"<th><span>"+data[index].state.stateName+"</span></th>"
												+"<th><span>"+getMyDate(data[index].sendDate)+"</span></th>"
												+"<th><span id='receiveId'>"+getReceiveTelById(data[index].receiveId)+"</span></th><th><span class='col-xs-6' style='width: 50%;'> " 
												+"<a class='manage delMessage' value='"+data[index].messageId+"'>删除</a></span></th></tr>");
							 	                                 });
										
									}
								});
					}
					// 执行通知表初始化工作
					initMessage();
					// 根据消息id查询消息信息
					$("button[name='searchMessage']").click(
						function() {
						$("#seconddiv tr:not(:first)").empty("");
							var messageId = $("input[name='messageId']").val();
								$.ajax({
									url : "/commonweal/message/getMessageById",
									type : "GET",
									data : "personId=" + messageId,
									dataType : "JSON",
									success : function(result) {
										$.each(result,function(index) {
											$("#seconddiv").append(
													"<tr><th><span>"+result[index].messageId+"</span></th>"
													+"<th><span>"+result[index].messageContent+"</span></th>"
													+"<th><span id='sendId'>"+getSendTelById(result[index].personId)+"</span></th>"
													+"<th><span>"+result[index].state.stateName+"</span></th>"
													+"<th><span>"+getMyDate(result[index].sendDate)+"</span></th>"
													+"<th><span id='receiveId'>"+getReceiveTelById(result[index].receiveId)+"</span></th><th><span class='col-xs-6' style='width: 50%;'> " 
													+"<a class='manage delMessage' value='"+data[index].messageId+"'>删除</a></span></th></tr>");
									});
													}
												});
									});
					// 点击删除按钮删除一条消息信息
					$(".delMessage").live("click", function() {
						var messageId = $(this).attr("value");
						alert(messageId);
						$.ajax({
							url : "/commonweal/message/delMessage/?messageId=" + messageId,
							type : "GET",
							dataType : "json",
							success : function() {
								initMessage();
							}
						});
					});
					//根据发送人id获取发送人电话
					function getSendTelById(personId){
						var phone = "";
						$.ajax({
							url : "/commonweal/person/getTelphone",
							data: "personId="+personId,
							type : "GET",
							async :false,
							dataType : "JSON",
							success : function(data) {
								phone = data;
							}
						});
						return phone;
					};
					//根据收信人id获取收信人电话
					function getReceiveTelById(personId){
						var tel = "";
						$.ajax({
							url : "/commonweal/person/getTelphone",
							data: "personId="+personId,
							type : "GET",
							async :false,
							dataType : "JSON",
							success : function(data) {
								tel = data;
							}
						});
						return tel;
					};
				});