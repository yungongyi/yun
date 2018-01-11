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
			 * get all partner
			 */
			// 初始化获取partner合作表数据
			function initPartner() {
				$
				.ajax({
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
											+ data[index].resource.resourceId
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
			// 执行合作表初始化工作
			initPartner();
			/**
			 * get partner by partnerName
			 */
			// 根据合作名称查询合作信息
			$("button[name='serachpart']")
			.click(
					function() {
						$("#partnertables tr:not(:first)").empty(
						"");
						var partnerName = $("input[name='partnerName']")
						.val();
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
										function(
												index) {
											$(
											"#partnertables")
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
													+ result[index].resource.resourceId
													+ "</span></th><th><span>"
													+ result[index].state.stateName
													+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
													+"<a class='manage getPartner'  value='"+data[index].partnerId+"'>查看</a></span>" 
													+" <span class='col-xs-6' style='width: 50%;'> " 
													+"<a class='manage delPartner' value='"+data[index].partnerId+"'>删除</a>"
													+"</span></th>");
										});
							}
						});
					});
			
			
			
			//点击查看按钮查看一条合作信息
			$(".getPartner").live("click",function() {
				$(".getpartnerul").show();
				$(".partnertable").hide();
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
																																						
											+"<li><span>合作ID：</span> <span>"
											+result[index].partnerId
											+"</span></li>"
											+"<li><span>合作人：</span> <span>" 
											+result[index].partnerName
											+"</span></li>"
											+"<li><span>合作标志：</span> <span>" 
											+result[index].partnerMark
											+"</span></li>"
											+"<li><span>开始时间：</span> <span>"
											+ getMyDate(result[index].partnerStartDate)
											+ "</span></li>"
											+"<li><span>结束时间：</span> <span>"
											+ getMyDate(result[index].partnerEndDate)
											+"<li><span>资源ID：</span> <span>" 
											+result[index].resource.resourceId
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
			});
			
			
			
			
			// 点击提交按钮增加一条合作信息
			$("button[name='partneradd']").click(
					function() {	
						var name = $("#addname").val();
						var date = $("#adddate").val();
						var resouce = $("#addresourceid").val();
						var state = $("#addstateid").val();
					    var mark = $("#addmark").val();
										
						$.ajax({
							url : "/commonweal/partner/addPartner/" ,
							type : "POST",
							data : {"name":name,"date":date,"resource":resouce,"state":state},
							dataType : "JSON",
							success : function() {
								alert("添加成功！");
								initPartner();
								}
						});
					});

			// 点击删除按钮删除一条合作信息
			$(".delPartner").live("click",function() {
				var id = $(this).attr("value");
				$.ajax({
					url : "/commonweal/partner/delPartner/?id=" + id,
					type : "GET",
					dataType : "json",
					success : function() {
						initPartner();
					}
				});
			});
		});