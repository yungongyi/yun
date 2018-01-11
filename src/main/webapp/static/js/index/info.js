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
			 * get all info
			 */
			// 初始化获取info通知表数据
			function initInfo() {
				$
				.ajax({
					url : "/commonweal/info/getInfo",
					type : "GET",
					dataType : "JSON",
					success : function(data) {
						$("#firsttable tr:not(:first)").empty(
						"");
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
			// 执行通知表初始化工作
			initInfo();
			/**
			 * get info by infoId
			 */
			// 根据通知id查询通知信息
			$("button[name='serach']")
			.click(
					function() {
						$("#firsttable tr:not(:first)").empty(
						"");
						var infoId = $("input[name='infoId']")
						.val();
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
										function(
												index) {
											$(
											"#firsttable")
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

			// 点击提交按钮增加一条通知信息
			$(".infoadd")
			.click(
					function() {
						var infoCon = $("#firstinput").val();
						if (infoCon == null || infoCon == "") {
							alert("通知内容不能为空!!!")
						} else {
							$
							.ajax({
								url : "/commonweal/info/addInfo/?content="
									+ infoCon,
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
			// 点击删除按钮删除一条通知信息
			$(".delInfo").live("click", function() {
				var id = $(this).attr("value");
				$.ajax({
					url : "/commonweal/info/delInfo/?id=" + id,
					type : "GET",
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							alert("删除成功!!!");
							initInfo();
						} else {
							alert("删除失败!!!");
						}

					}
				});
			});

		});