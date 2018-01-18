$(function(){
	$("#resourceManage").click(function() {
		// 初始化资源表
		initResource();
		getresourceType();
	});
	//上传文件
	function uploadFileById(id,url,type) {	
		alert(url);
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
			}
		});
		return true;
	}
	
	//资源js
	function initResource() { 
		$("#resourceList tr:not(:first)").empty("");
		var id = $('input[name="searchBySourceId"]').val();
		$
		.ajax({
			url : "/commonweal/resource/findResource",
			data : "id=" + id,
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				$
				.each(
						data,
						function(index) {
							$("#resourceList")
							.append(
									//处理未知来源 				
									"<tr class='resourcetr'><th><span>"
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
				gopage(".resourcetr",1,4);
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
	//获取资源类型
	function getresourceType(){
		$.ajax({
			url : "/commonweal/type/getType/"+11,
				type : "GET",
				dataType : "json",
				success : function(data) {
					$("#searchBySourceType").append("<option value=0>资源类型</option>");
					$.each(data,function(index,object){
						$("#searchBySourceType").append("<option value="+object.typeId+">"+object.typeName+"</option>");
						
					});
				},
				error:function(data){
					
				}
		});
		
	}
});