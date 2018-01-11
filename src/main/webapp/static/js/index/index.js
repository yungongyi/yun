/**
 * 2017-12-29-16:03 cjw
 */
/* 0.文档加载完成 */
$(function() {
	/* 1.0 */
	// 初始化用户表
	initPerson();
});
//点击启事选项卡
$("#noticManage").click(function() {
	// 初始化启事
	initNotice();
});
//点击系统通知选项卡
$("#infoManage").click(function() {
	// 初始化系统通知
	initInfo();
});
//点击用户消息选项卡
$("#messageManage").click(function() {
	// 初始化用户消息
	initMessage();
});
//点击用户反馈选项卡
$("#ideaManage").click(function() {
	// 初始化用户反馈
	initIdea();
});
//点击企业合作选项卡
$("#partnerManage").click(function() {
	// 初始化企业合作消息
	initPartner();
});

$("#resourceManage").click(function() {
	// 初始化资源表
	initResource();;
});


//1.将ajax获取的时间戳(获取过来它自动转换为时间戳)转换成时间(年:月:日 时:分:秒)
function getMyDate(str) {
	var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
	.getMonth() + 1, oDay = oDate.getDate(), oHour = oDate.getHours(), oMin = oDate
	.getMinutes(), oSen = oDate.getSeconds(), oTime = oYear + '-'
	+ getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':'
	+ getzf(oMin) + ':' + getzf(oSen);
	return oTime;
}
//2.补0操作
function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}
/* 3.初始化意见表 */
function initIdea() {
	$
	.ajax({
		url : "/commonweal/idea/getIdea",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#thirddiv tr:not(:first)").empty("");
			$
			.each(
					data,
					function(index) {
						$("#thirddiv")
						.append(
								"<tr><th><span>"
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
//根据发送人id获取发送人电话
function getTelById(personId) {
	var phone = "";
	$.ajax({
		url : "/commonweal/personCenter/getTelById",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "JSON",
		success : function(data) {
			phone = data;
		}
	});
	return phone;
};
/* 初始化用户信息表 */
function initMessage() {
	$
	.ajax({
		url : "/commonweal/message/getMessage",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#seconddiv tr:not(:first)").empty("");
			$
			.each(
					data,
					function(index) {
						$("#seconddiv")
						.append(
								"<tr><th><span>"
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
//根据发送人id获取发送人
function getSendNameById(personId) {
	var sendName = "";
	$.ajax({
		url : "/commonweal/personCenter/getPersionName",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "text",
		success : function(data) {
			sendName = data;
		}
	});
	return sendName;
};
//根据收信人id获取收信人
function getReceiveNameById(personId) {
	var recName = "";
	$.ajax({
		url : "/commonweal/personCenter/getPersionName",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "text",
		success : function(data) {
			recName = data;
		}
	});
	return recName;
}
//根据用户手机号查询用户信息
$("button[name='serachuser']").click(function() {
	$("#usertable tr:not(:first)").empty("");
	var iphone = $("input[name='iphone']").val();
	$.ajax({
		url : "/commonweal/personCenter/getPersonByiphone",
		type : "GET",
		data : "iphone=" + iphone,
		dataType : "JSON",
		success : function(result) {
			eachPerson(result);
		}
	});
});

/**
 * get all person
 */
//初始化获取person用户表数据
function initPerson() {
	$.ajax({
		url : "/commonweal/personCenter/getPerson",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#usertable tr:not(:first)").empty("");
			// 遍历person
			eachPerson(data);
		}
	});
}
//生成Persontable
function eachPerson(data) {
	$
	.each(
			data,
			function(idx, obj) {
				var sex = null;
				if (obj.sex == 0) {
					sex = "男"
				}
				if (obj.sex == 1) {
					sex = "女"
				}
				$("#usertable")
				.append(
						"<tr><th><span>"
						+ obj.personid
						+ "</span></th><th><span>"
						+ obj.iphone
						+ "</span></th><th><span>"
						+ obj.name
						+ "</span></th><th><span>"
						+ getMyDate(obj.personCreateDate)
						+ "</span></th><th><span>"
						+ sex
						+ "</span></th><th><span>"
						+ obj.region.regionName
						+ "</span></th><th><span>"
						+ obj.state.stateName
						+ "</span></th><th><span>"
						+ obj.type.typeName
						+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>"
						+ "<a class='manage getUser'  value='"
						+ obj.personid
						+ "'>查看</a></span></th></tr>");
			});
}

//点击查看按钮查看一条用户信息
$(".getUser")
.live(
		"click",
		function() {
			$("#fromuser").hide();
			$(".userul").show();
			$("#usertable").hide();
			var id = $(this).attr("value");
			var stateId;
			$
			.ajax({
				url : "/commonweal/personCenter/getPersonBypersonid/?id="
					+ id,
					type : "GET",
					async : false,
					dataType : "json",
					success : function(result) {
						$(".userul").empty("");
						$
						.each(
								result,
								function(index) {
									var sex = null;
									if (result[index].sex == 0) {
										sex = "男"
									}
									if (result[index].sex == 1) {
										sex = "女"
									}
									stateId = result[index].state.stateId;
									$(".userul")
									.append(
											"<li><span>用户ID：</span> <span>"
											+ result[index].personid
											+ "</span></li>"
											+ "<li><span>手机号：</span> <span>"
											+ result[index].iphone
											+ "</span></li>"
											+ "<li><span>昵称：</span> <span>"
											+ result[index].name
											+ "</span></li>"
											+ "<li><span>密码：</span> <span>"
											+ result[index].password
											+ "</span></li>"
											+ "<li><span>创建时间：</span> <span>"
											+ getMyDate(result[index].personCreateDate)
											+ "</span></li>"
											+ "<li><span>性别：</span> <span>"
											+ sex
											+ "</span></li>"
											+ "<li><span>地址：</span> <span>"
											+ result[index].region.regionName
											+ "</span></li>"
											+ "<li><span>照片：</span> "
											+ "<img style='border-radius:50%;width:5em;height:5em;' src='"
											+ "/commonweal/static/upload/image/"
											+ result[index].resource.resourcePath
											+ "'></li>"
											+ "<li><span>用户类型：</span> <span>"
											+ result[index].type.typeName
											+ "</span></li>"
											+ "	<li><span>状态：</span> <select id='state_Id'>"
											+ "	<option value='16'>正常</option>"
											+ "	<option value='17'>封号2小时</option>"
											+ "	<option value='18'>封号1天</option>"
											+ "	<option value='19'>封号3天</option>"
											+ "	<option value='20'>封号1周</option>"
											+ "	<option value='21'>永久封号</option>"
											+ "	<option value='22'>长期未登录</option>"
											+ "</select></li>"
											+ "<li>"
											+ "<button class='userreturn' value='"
											+ result[index].personid
											+ "'>修改</button>"
											+ "<button class='returnUser'>返回</button>"
											+ "</li>");

								});
						$(
								"#state_Id option[value='"
								+ stateId + "']").attr(
										"selected", "selected");
					}

			});

		});

//点击返回返回至初始化页面
$(".returnUser").live("click", function() {
	$(".usertable").show();
	$(".userul").hide();
	$("#fromuser").show();
});

//修改用户状态
$(".userreturn").live("click", function() {
	var id = $(this).attr("value");
	var stateId = $("#state_Id").val();
	$.ajax({
		url : "/commonweal/personCenter/updatePersonBystate",
		data : {
			"id" : id,
			"stateId" : stateId
		},
		type : "GET",
		dataType : "json",
		success : function() {
			$("#usertishi").html("修改成功！");
			initPerson();
			$(".usertable").show();
			$(".userul").hide();
		}
	});
});
/**
 * get all notice
 */
//初始化获取notice启事表数据
function initNotice() {
	var stateId = $("input[name='noticeTittle']").val();
	var date = $("input[name='noticeDate']").val();
	$
	.ajax({
		url : "/commonweal/notice/getAllNotice",
		type : "GET",
		data : {
			"stateId" : stateId,
			"date" : date
		},
		dataType : "JSON",
		success : function(data) {

			$("#noticetable tr:not(:first)").empty("");
			$
			.each(
					data,
					function(index) {

						$("#noticetable")

						.append(

								"<tr><th><span>"
								+ data[index].noticeId
								+ "</span></th><th><span>"
								+ data[index].noticeTittle
								+ "</span></th><th><span>"
								+ data[index].areaId
								+ "</span></th><th><span>"
								+ data[index].personId
								+ "</span></th><th><span>"
								+ getMyDate(data[index].noticeCreateDate)
								+ "</span></th><th><span>"
								+ data[index].state.stateName
								+ "</span></th><th><span>"
								+ data[index].type.typeName
								+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>"
								+ "<a class='manage getNotice'  value='"
								+ data[index].noticeId
								+ "'>查看</a></span>"
								+ " <span class='col-xs-6' style='width: 50%;'> "
								+ "<a class='manage delNotice' value='"
								+ data[index].noticeId
								+ "'>删除</a>"
								+ "</span></th>");
					});
		}
	});
}
/**
 * get notice by iphone
 */
//根据启事标题查询启事信息
$("button[name='serachnotice']")
.click(
		function() {
			var stateId = $("input[name='noticeTittle']").val();
			var date = $("input[name='noticeDate']").val();
			$("#noticetable tr:not(:first)").empty("");
			$
			.ajax({
				url : "/commonweal/notice/getAllNotice",
				type : "GET",
				data : {
					"stateId" : stateId,
					"date" : date
				},
				dataType : "JSON",
				success : function(result) {
					$
					.each(
							result,
							function(index) {

								$("#noticetable")
								.append(
										"<tr><th><span>"
										+ result[index].noticeId
										+ "</span></th><th><span>"
										+ result[index].noticeTittle
										+ "</span></th><th><span>"
										+ result[index].areaId
										+ "</span></th><th><span>"
										+ result[index].personId
										+ "</span></th><th><span>"
										+ getMyDate(result[index].noticeCreateDate)
										+ "</span></th><th><span>"
										+ result[index].state.stateName
										+ "</span></th><th><span>"
										+ result[index].type.typeName
										+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>"
										+ "<a class='manage getNotice'  value='"
										+ result[index].noticeId
										+ "'>查看</a></span>"
										+ " <span class='col-xs-6' style='width: 50%;'> "
										+ "<a class='manage delNotice' value='"
										+ result[index].noticeId
										+ "'>删除</a>"
										+ "</span></th>");
							});
				}
			});
		});

//点击查看按钮查看一条启事信息
$(".getNotice")
.live(
		"click",
		function() {
			$("#fromnotice").hide();
			$('.noticetable').hide();
			$('.noticeul').show();
			var id = $(this).attr("value");
			$
			.ajax({
				url : "/commonweal/notice/getNoticeBypId/?id="
					+ id,
					type : "GET",
					dataType : "json",
					success : function(result) {

						$(".noticeul").empty("");
						$
						.each(
								result,
								function(index) {

									$(".noticeul")
									.append(

											"<li><span>启事ID：</span> <span>"
											+ result[index].noticeId
											+ "</span></li>"
											+ "<li><span>标题：</span> <span>"
											+ result[index].noticeTittle
											+ "</span></li>"
											+ "<li><span>详细描述：</span> <span>"
											+ result[index].noticeDetail
											+ "</span></li>"
											+ "<li><span>图片：</span> " 
											+ "<img style='border-radius:50%;width:5em;height:5em;' src='"
											+ "/commonweal/static/upload/image/"
											+ result[index].resource.resourcePath
											+ "'></li>"
											+ "<li><span>联系人：</span> <span>"
											+ result[index].personId
											+ "</span></li>"
											+ "<li><span>区域：</span> <span>"
											+ result[index].areaId
											+ "</span></li>"
											+ "<li><span>有效时长：</span> <span>"
											+ result[index].noticeAging
											+ "</span></li>"
											+ "<li><span>启事类型：</span> <span>"
											+ result[index].type.typeName
											+ "</span><li>"
											+ "<li><span>发布时间：</span> <span>"
											+ getMyDate(result[index].noticeCreateDate)
											+ "</span></li>"
											+ "	<li><span>启事状态：</span><span>"
											+ result[index].state.stateName
											+ "</span></li>"
											+ "<li>"
											+ "<button class='noticereturn'>返回</button>"
											+ "</li>");

								});
					}
			});

		});

//返回
$(".noticereturn").live("click", function() {
	$('.noticetable').show();
	$('.noticeul').hide();
	$("#fromnotice").show();
});

//删除启事
$(".delNotice ").live("click", function() {
	var id = $(this).attr("value");
	$.ajax({
		url : "/commonweal/notice/delNoticeById",
		data : "id=" + id,
		type : "GET",
		dataType : "json",
		success : function() {
			$("#noticetishi").html("删除成功！");	
			initNotice();
		}
	});
});
/**
 * get all info
 */
//初始化获取info通知表数据
function initInfo() {
	$
	.ajax({
		url : "/commonweal/info/getInfo",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#firsttable tr:not(:first)").empty("");
			$
			.each(
					data,
					function(index) {
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
/**
 * get all partner
 */
//初始化获取partner合作表数据
function initPartner() {
	$.ajax({
		url : "/commonweal/partner/getPartner",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#partnertables tr:not(:first)").empty(
			"");
			$
			.each(
					data,
					function(index) {
						$("#partnertables")
						.append(						
								"<tr><th><span>"
								+ data[index].partnerId
								+ "</span></th><th><span>"
								+ data[index].partnerName
								+ "</span></th><th><span>"
								+ getMyDate(data[index].partnerStartDate)
								+ "</span></th><th><span>"
								+ getMyDate(data[index].partnerEndDate)
								+ "</span></th><th><span>"
								+ data[index].resource.resourcePath
								+ "</span></th><th><span>"
								+ data[index].state.stateName
								+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
								+"<a class='manage getPartner'  value='"+data[index].partnerId+"'>查看</a></span>" 
								+" <span class='col-xs-6' style='width: 50%;'> " 
								+"<a class='manage delPartner' value='"+data[index].partnerId+"'>删除</a>"
								+"</span></th>");
					});
		}
	});
}

/**
 * get partner by partnerName
 */
//根据合作名称查询合作信息
$("button[name='serachpart']")
.click(
		function() {
			$("#partnertables tr:not(:first)").empty("");
			var partnerName = $("input[name='partnerName']").val();
			$
			.ajax({
				url : "/commonweal/partner/getPartnerByName",
				type : "GET",
				data : "name=" + partnerName,
				dataType : "JSON",
				success : function(result) {
					$
					.each(
							result,
							function(index) {
								$("#partnertables")
								.append(
										"<tr><th><span>"
										+ result[index].partnerId
										+ "</span></th><th><span>"
										+ result[index].partnerName
										+ "</span></th><th><span>"
										+ getMyDate(result[index].partnerStartDate)
										+ "</span></th><th><span>"
										+ getMyDate(result[index].partnerEndDate)
										+ "</span></th><th><span>"
										+ result[index].resource.resourcePath
										+ "</span></th><th><span>"
										+ result[index].state.stateName
										+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
										+"<a class='manage getPartner'  value='"+result[index].partnerId+"'>查看</a></span>" 
										+" <span class='col-xs-6' style='width: 50%;'> " 
										+"<a class='manage delPartner' value='"+result[index].partnerId+"'>删除</a>"
										+"</span></th>");
							});
				}
			});
		});

//点击查看按钮查看一条合作信息
$(".getPartner").live("click",function() {
	$(".getpartnerul").show();
	$(".partnertable").hide();
	$("#formPartner").hide();
	var id = $(this).attr("value");			
	$.ajax({
		url : "/commonweal/partner/getPartnerById/?id=" + id,
		type : "GET",
		dataType : "json",
		success : function(result) {

			$(".getpartnerul").empty("");
			$
			.each(
					result,
					function(
							index) {

						$(
								".getpartnerul")
								.append(

										"<li><span>合作ID：</span> <span>"
										+result[index].partnerId
										+"</span></li>"
										+"<li><span>合作人：</span> <span>" 
										+result[index].partnerName
										+"</span></li>"
										+"<li><span>合作标志：</span><span>"
										+ result[index].partnerMark
										+ "</span></li>"
										+"<li><span>开始时间：</span> <span>"
										+ getMyDate(result[index].partnerStartDate)
										+ "</span></li>"
										+"<li><span>结束时间：</span> <span>"
										+ getMyDate(result[index].partnerEndDate)
										+"<li><span>路径：</span> <span>" 
										+result[index].resource.resourcePath
										+"</span></li>"
										+"<li><span>合作状态：</span> <span>" 
										+result[index].state.stateName										
										+"</span></li>"
										+   "<li>"
										+	"<button class='partnerreturn'>返回</button>"
										+	"</li>" );

					});
		}
	});

});


//返回
$(".partnerreturn").live("click",function() {
	$(".partnertable").show();
	$(".getpartnerul").hide();
	$("#formPartner").show();
});



//点击提交按钮增加一条合作信息
$("button[name='partneradd']").click(function() {
	var name = $("#addname").val();
	var resouce = $("#file").val();
	var state = $("#addstateid").val();
	var mark = $("#addmark").val();
	if(name==null||name==''){
		alert("合作人不能为空！返回页面");
		return false;
	}
	if(mark==null||mark==''){
		alert("合作标志不能为空！返回页面");
		return false;
	}
	var date = new Date(($("#adddate").val().replace(/-/g,"/")));            
	var d = new Date();   

	if(date<d)  
	{  
		alert("不能小于当前时间！返回页面");
		return false;  
	}  

	if(resouce==null||resouce==''){
		alert("资源路径不能为空！返回页面");
		return false;
	}
	
	
	function getAllPartner() {
		$.get("/commonweal/partner/addPartner", "JSON", function(data) {
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
	
	
	
	$.ajax({
		url : "/commonweal/partner/addPartner/",
		type : "POST",
		data : {
			"name" : name,
			"date" : date,
			"resource" : resouce,
			"state" : state,
			"mark" : mark
		},
		dataType : "JSON",
		success : function() {
			alert("添加成功！");
			initPartner();
		}
	});
	return true;
});

//点击删除按钮删除一条合作信息
$(".delPartner").live("click", function() {
	var id = $(this).attr("value");
	$.ajax({
		url : "/commonweal/partner/delPartner/?id=" + id,
		type : "GET",
		dataType : "json",
		success : function() {
			initPartner();
			$("#partnertishi").html("删除成功！");
		}
	});
});


//资源js
function initResource() {
	var id = $('input[name="searchBySourceId"]').val();

	$
	.ajax({
		url : "/commonweal/resource/findResource",
		data : "id=" + id,
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#resourceList tr:not(:first)").empty("");
			$
			.each(
					data,
					function(index) {
						$("#resourceList")
						.append(
								//处理未知来源 				
								"<tr><th><span>"
								+ data[index].resourceId
								+ '</span></th>'
								+ '<th><span class="resourcePath">'
								+ data[index].resourcePath
								+ '</span></th>'
								+ '<th><span>'
								+ data[index].type.typeName
								+ '</span></th>'
								+ "<th value='1' class='preview'><span class='col-xs-6' style='width: 50%;'>"
								+ "<a class='manage getResource'  value='"+data[index].resourceId+"'>查看</a></span></th></tr>");
					});
		}
	});
}

//根据ID查询
$("button[name='serachresource']").click(function() {
	initResource();
});

//点击查看按钮查看一条资源信息
$(document)
.on(
		"click",
		".getResource",
		function() {

			$(".getresourceul").show();
			$("#resourceList").hide();
			$("#formResource").hide();
			var id = $(this).attr("value");
			$
			.ajax({
				url : "/commonweal/resource/findResource/?id="
					+ id,
					type : "GET",
					dataType : "json",
					success : function(result) {

						$(".getresourceul").empty("");
						$
						.each(
								result,
								function(index) {

									$(".getresourceul")
									.append(

											"<li><span>资源ID：</span> <span>"
											+ result[index].resourceId
											+ "</span></li>"
											+ "<li><span>资源路径：</span> <span>"
											+ result[index].resourcePath
											+ "</span></li>"
											+ "<li><span>合作标志：</span>	 "
											+ "<img style='border-radius:50%;width:5em;height:5em;' src='"
											+ "/commonweal/static/upload/image/"
											+ result[index].resourcePath
											+ "'></li>"
											+ "<li><span>资源类型：</span> <span>"
											+ result[index].type.typeName
											+ "</span></li>"
											+ "<li>"
											+ "<button class='resourcereturn'>返回</button>"
											+ "</li>");

								});
					}
			});

		});

//返回
$(document).on("click", ".resourcereturn", function() {
	$("#resourceList").show();
	$(".getresourceul").hide();
	$("#formResource").show();
});



//操作记录JS
$("#operationmanage").click(
		function() {
			$.ajax({
				url : "/commonweal/operation/getoperations",
				type : "GET",
				dataType : "json",
				success : function(data) {
					$.each(data, function(index) {
						$("#operationlist").append(
								"<tr>" + "<th><span>" + data[index].operationId
								+ "</span></th>" + "<th><span>"
								+ data[index].operationDate
								+ "</span></th>" + "<th><span>"
								+ data[index].tableId + "</span></th>"
								+ "<th><span>"
								+ data[index].type.typeName
								+ "</span></th>" + "<th><span>"
								+ data[index].personId + "</span></th>"
								+ "</tr>");
					});

				},
				error : function(data) {
					// 失败就返回这个
					alert(data);
				}
			});
		});
$("#operationsearch")
.click(
		function() {

			var operationPersonName = $(
			"input[name=operationPersonName]").val();
			if (operationPersonName == null
					|| operationPersonName == "") {
				operationPersonName = "all";
			}
			$
			.ajax({
				url : "/commonweal/operation/getoperationsByPersonName/"
					+ operationPersonName,
					type : "GET",
					dataType : "json",
					success : function(data) {
						$("#operationlist").html(
								"<tr style='background: #cccccc;'>"
								+ "<th>操作ID</th>"
								+ "<th>操作时间</th>"
								+ "<th>操作表</th>"
								+ "<th>操作类型</th>"
								+ "<th>操作人</th>" + "</tr>");
						if (data == "") {
							$("#operationlist")
							.append(
							"<p style='color:red;padding-top:20px' class='text-right'>该管理员暂未进行任何操作</p>");
						} else {
							$
							.each(
									data,
									function(index) {

										$("#operationlist")
										.append(
												"<tr>"
												+ "<th><span>"
												+ data[index].operationId
												+ "</span></th>"
												+ "<th><span>"
												+ data[index].operationDate
												+ "</span></th>"
												+ "<th><span>"
												+ data[index].tableId
												+ "</span></th>"
												+ "<th><span>"
												+ data[index].type.typeName
												+ "</span></th>"
												+ "<th><span>"
												+ data[index].personId
												+ "</span></th>"
												+ "</tr>");
									});
						}
					},
					error : function(data) {
						// 失败就返回这个
						alert(data);
					}
			});
		});
