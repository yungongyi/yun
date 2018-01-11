$(document)
.ready(
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
			}
			;
			// 补0操作
			function getzf(num) {
				if (parseInt(num) < 10) {
					num = '0' + num;
				}
				return num;
			}
			/**
			 * get all notice
			 */
			// 初始化获取notice启事表数据
			function initNotice() {
				var pageNo=1;		
				$
				.ajax({
					url : "/commonweal/notice/getAllNotice",
					type : "GET",
					data : "pageNo="+pageNo,
					dataType : "JSON",
					success : function(data) {

						$("#noticetable tr:not(:first)").empty(
						"");
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
											+data[index].areaId
											+ "</span></th><th><span>"
											+ data[index].personId
											+ "</span></th><th><span>"
											+ getMyDate(data[index].noticeCreateDate)
											+ "</span></th><th><span>"
											+ data[index].state.stateName
											+ "</span></th><th><span>"
											+ data[index].type.typeName
											+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
											+"<a class='manage getNotice'  value='"+data[index].noticeId+"'>查看</a></span>" 
											+" <span class='col-xs-6' style='width: 50%;'> " 
											+"<a class='manage delNotice' value='"+data[index].noticeId+"'>删除</a>"
											+"</span></th>");
								});
					}
				});
			}
			// 执行启事初始化工作
			initNotice();
			/**
			 * get notice by iphone
			 */
			// 根据启事标题查询启事信息
			$("button[name='serachnotice']")
			.click(
					function() {					
						$("#noticetable tr:not(:first)").empty(
						"");					
						var noticeTittle = $("input[name='noticeTittle']")
						.val();
						$
						.ajax({			
							url : "/commonweal/notice/getNoticeBynoticeTittle",
							type : "GET",
							data : "noticeTittle=" + noticeTittle,
							dataType : "JSON",
							success : function(result) {
								$
								.each(
										result,
										function(
												index) {

											$(
													"#noticetable")
													.append(
															"<tr><th><span>"
															+ result[index].noticeId
															+ "</span></th><th><span>"
															+ result[index].noticeTittle
															+ "</span></th><th><span>"
															+result[index].areaId
															+ "</span></th><th><span>"
															+ result[index].personId
															+ "</span></th><th><span>"
															+ getMyDate(result[index].noticeCreateDate)
															+ "</span></th><th><span>"
															+ result[index].state.stateName
															+ "</span></th><th><span>"
															+ result[index].type.typeName
															+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
															+"<a class='manage getNotice'  value='"+result[index].noticeId+"'>查看</a></span>" 
															+" <span class='col-xs-6' style='width: 50%;'> " 
															+"<a class='manage delNotice' value='"+result[index].noticeId+"'>删除</a>"
															+"</span></th>");
										});
							}
						});
					});

			//点击查看按钮查看一条启事信息
			$(".getNotice").live("click",function() {
				$('.noticetable').hide();
				$('.noticeul').show();
				var id = $(this).attr("value");			
				$.ajax({
					url : "/commonweal/notice/getNoticeBypId/?id=" + id,
					type : "GET",
					dataType : "json",
					success : function(result) {

						$(".noticeul").empty("");
						$
						.each(
								result,
								function(
										index) {
								
									$(
									".noticeul")
									.append(
											
											"<li><span>启事ID：</span> <span>"
											+result[index].noticeId
											+"</span></li>"
											+"<li><span>标题：</span> <span>" 
											+result[index].noticeTittle
											+"</span></li>"
											+"<li><span>详细描述：</span> <span>" 
											+result[index].noticeDetail
											+"</span></li>"
											+"<li><span>图片：</span> <<img"
											+"src='<%=basePath%>/static/image/avatar1_small.jpg'></li>"
											+"</span></li>"
											+"<li><span>联系人：</span> <span>" 
											+result[index].personId
											+"</span></li>"
											+"<li><span>区域：</span> <span>" 
											+result[index].areaId
											+"</span></li>"										
											+"<li><span>有效时长：</span> <span>" 
											+result[index].noticeAging
											+"</span></li>"
											+"<li><span>启事类型：</span> <span>" 
											+result[index].type.typeName
											+"</span><li>" 
											+"<li><span>发布时间：</span> <span>" 
											+getMyDate(result[index].noticeCreateDate)
											+"</span></li>"
											+"	<li><span>启事状态：</span><span>" 
											+result[index].state.stateName
											+"</span></li>"
											+   "<li>"
											+	"<button class='noticereturn'>返回</button>"
											+	"</li>" );

								});
					}
				});

			});

			
			//返回
			$(".noticereturn").live("click",function() {
				$('.noticetable').show();
				$('.noticeul').hide();
			});
			
			
			//删除启事
			$(".delNotice ").live("click",function() {
				var id = $(this).attr("value");		
				$.ajax({
					url : "/commonweal/notice/delNoticeById",
					data : "id="+id,
					type : "GET",
					dataType : "json",
					success : function() {
						alert("删除成功！");
						initNotice();
					}
				});
			});

		});
