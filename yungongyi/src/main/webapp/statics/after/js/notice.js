/**
 * get all notice
 */
$(function(){
	//点击启事选项卡
	$("#noticManage").click(function() {
		// 初始化启事
		initNotice();
	});
//	初始化获取notice启事表数据
	function initNotice() {
		$("#noticetable tr:not(:first)").empty("");
		var stateId = $("input[name='noticeTittle']").val();
		var date = $("input[name='noticeDate']").val();
		$.ajax({
			url : "/commonweal/notice/getAllNotice",
			type : "GET",
			data : {
				"stateId" : stateId,
				"date" : date
			},
			dataType : "JSON",
			success : function(data) { 
				$.each(data,	function(index) {
					$("#noticetable").append(
							"<tr class='noticetr'><th><span>"
							+ data[index].noticeId
							+ "</span></th><th><span>"
							+ data[index].noticeTittle
							+ "</span></th><th><span>"
							+ data[index].region.regionName
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
				gopage(".noticetr",1,4);
			}
		});
	}
	/**
	 * get notice by iphone
	 */
//	根据启事标题查询启事信息
	$("button[name='serachnotice']").click(
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
									.append("<tr class='noticetr'><th><span>"
											+ result[index].noticeId
											+ "</span></th><th><span>"
											+ result[index].noticeTittle
											+ "</span></th><th><span>"
											+ result[index].region.regionName
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
						gopage(".noticetr",1,4);
					}
				});
			});

//	点击查看按钮查看一条启事信息
	$(".getNotice")
	.live("click",	function() {
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
										+ result[index].region.regionName
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
//	返回
	$(".noticereturn").live("click", function() {
		$('.noticetable').show();
		$('.noticeul').hide();
		$("#fromnotice").show();
	});
//	删除启事
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
});