$(function(){
	
	var partnerwaring=$("#partnertishi");
	//点击企业合作选项卡
	$("#partnerManage").click(function() {
		// 初始化企业合作消息
		initPartner();
	});
	/**
	 * get all partner
	 */
	//初始化获取partner合作表数据
	function initPartner() {
		$("#partnertables tr:not(:first)").empty(
		"");
		$.ajax({
			url : "/commonweal/partner/getPartner",
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				$
				.each(
						data,
						function(index) {
							$("#partnertables")
							.append(						
									"<tr class='partnertr'><th><span>"
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
				gopage(".partnertr",1,4);
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
				$.each(
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
									+"<li><span>路径：</span>" 
									+ "<img style='border-radius:50%;width:5em;height:5em;' src='"
									+ "/commonweal/static/upload/image/"
									+ result[index].resource.resourcePath
									+ "'></li>"
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

	/*var id ;
	//新增资源
	function getAllPartner() {
		$.post("/commonweal/findResource/addResource", "JSON",function(data) {
			//id= data.resourceId;		
		});
	}*/
	//返回
	$(".partnerreturn").live("click",function() {
		$(".partnertable").show();
		$(".getpartnerul").hide();
		$("#formPartner").show();
	});
	//点击提交按钮增加一条合作信息
	$("button[name='partneradd']").click(function() {
		var name = $("#addname").val();
		var file0 = document.getElementById("partnerfile").files[0];
		var state = $("#addstateid").val();
		var mark = $("#addmark").val();
		var date = $("#adddate").val();
		//用于比较日期
		var dates = new Date(($("#adddate").val().replace(/-/g,"/")));            
		var d = new Date();   
		if(name==''||mark==''){
			partnerwaring.html('请检查合作信息是否合法');
			partnerwaring.css('color','red');
		}else if(dates<d){
			partnerwaring.html('结束日期不能早于今天');
			partnerwaring.css('color','red');
		}else if(file0==null){
			partnerwaring.html('请上传一张合作商的图片');
			partnerwaring.css('color','red');
		}else{
			var formData = new FormData();
			formData.append("name",name);
			formData.append("file0",file0);
			formData.append("state",state);
			formData.append("mark",mark);
			formData.append("date",date);			
			$.ajax({
				url : "/commonweal/partner/addPartner", 
				type : "POST",
				contentType: false, //禁止设置请求类型
				processData: false,
				data : formData,
				dataType : "JSON",
				success : function(data) {
					if(data>0){
						partnerwaring.html('添加成功！');
						partnerwaring.css('color','green');
						initPartner();
					}else{
						partnerwaring.html('添加失败！');
						partnerwaring.css('color','red'); 
					}
				},error: function(data){
					partnerwaring.html('系统出错！');
					partnerwaring.css('color','red'); 
				}
			});
		}


	});

});