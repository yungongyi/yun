$(function(){
	
	$("#showAddRegion").click(function(){
		$("#addRegionPanle").slideToggle();
	});
	/* 新增地区 */
	function checkSubmit() {
		/* 获取值 */
		var $regionName = $('input[name="regionName"]');
		var $simpleEN =$('input[name="simpleEN"]');
		var $regionCode = $('input[name="regionCode"]');
		/* 非空验证 */
		if($regionName.val()==""||$regionName.val()==null){
			alert("地区名字不能为空");
			return false;
		}
		if($simpleEN.val()=="" ||$simpleEN.val()==null){
			alert("地区简拼不能为空");
			return false;
		}
		if($regionCode.val()=="" ||$regionCode.val()==null){				
			alert("地区邮编不能为空");
			return false;
		}
		/* 赋值  */
		var parentId=1;
		var level=1;
		alert($("#citys").val());
		if($("#citys").val()>-1&&$("#citys").val()!=null){
			parentId=$("#citys").val();
			level=3;
		}else if($("#provinces").val()>-1){
			parentId=$("#provinces").val();
			level=2;
		}else{
			parentId=1;
			level=1;
		}
		alert(parentId);
		/* 新增  */
		addRegion(parentId,$regionName.val(), level, $simpleEN.val(),$regionCode.val());
		initRegion(1, "provinces");
		$("#addRegionPanle").hide();
	}
		$(function() {
			$("#territorymanage").click(function(){
				$('#paging').html('');
				initRegion(1, "provinces");
			});
		});
		/* 选择省 */
		$("#provinces").change(function() {
			var id = $(this).val();
			getRegionByRegionId(id, "parentId");
			if (id == -1) {
				initRegion(1, "provinces");
			} else {
				initRegion(id, "citys");
			}
		});
		/* 选择城市 */
		$("#citys").change(function() {
			var id = $(this).val();
			initRegion(id, "areas");
			getRegionByRegionId(id, "parentId");
		});
		/* 选择区域 */
		$("#areas").change(function() {
			var id = $(this).val();
			getRegionByRegionId(id, "parentId");
		});
		/* 弹出新增窗口  */
		$("#addRegion").click(function() {
			$("#addRegionFrom").fadeIn();
		});
		/* 初始化只加载省份  */
		function initRegion(id, eleId) {
			var tittle;
			if (eleId == "provinces") {
				tittle = "请选择省份"
			} else if (eleId == "citys") {
				tittle = "请选择城市"
			} else if (eleId == "areas") {
				tittle = "请选择区县";
			}
			var str = '<option value="-1" selected="selected">' + tittle
					+ '</option>';
			var str1 = '<tr style="background: #cccccc;"><th>地区ID</th><th>邮编</th><th>地区级别</th><th>地区名</th><th>简拼</th><th>操作</th></tr>';
			$.get("/commonweal/region/getRegionByParentId?id=" + id
					+ "&pageNo=1", "JSON", function(data) {
				$.each(JSON.parse(data), function(idx, obj) {
					str = str + '<option value="'+obj.regionId+'">'
							+ obj.regionName + '</option>';
					str1 = str1 + '<tr class="regiontr"><th><span>' + obj.regionId
							+ '</span></th>' + '<th><span>' + obj.regionCode
							+ '</span></th>' + '<th><span class="typeId">'
							+ obj.regionLevel + '</span></th>' + '<th><span>'
							+ obj.regionName + '</span></th>' + '<th><span>'
							+ obj.regionShortnameEn + '</span></th>'
							+ '<th><span ><a class="delThisRegion">删除</a></span></th></tr>'
				});
				
				$("#" + eleId).html(str);
				$("#regionList").html(str1);
				/* 单击删除  */
				jQuery('.delThisRegion').click(function(){
					var regionId=$(this).parent().parent().prev().prev().prev().prev().prev().text();
					alert(regionId);
				
					delRegionById(regionId);
					$(this).parent().parent().parent().remove();
				});
			});
		}
		/* 根据id获取地区 */
		function getRegionByRegionId(regionId, ele) {
			if (regionId == -1) {
				$('input[name="' + ele + '"]').val("可以新增");
				return;
			}
			$.get('/commonweal/region/getRegionByRegionId/' + regionId, "JSON",
					function(data) {
						data = JSON.parse(data);
						$('input[name="' + ele + '"]').val(data.regionName);
						$('input[name="' + ele + '"]').next().val(
								data.regionShortnameEn);
					});
		}
		/*新增地区 */
		function addRegion(parentId, regionName, level,simpleEN, regionCode) {
			alert(parentId+"新增");
			if(parentId==""){
				parentId=0;
			}
			$.post("/commonweal/region/addRegion", {
				parentId : parentId,
				regionName : regionName,
				level : level,
				simpleEN : simpleEN,
				regionCode : regionCode
			}, "JSON", function(data) {
				alert('xin');
			});
		}
		/* 删除地区  */
		function delRegionById(id){
			$.get("/commonweal/region/delRegionById",{id:id},"JSON",function(data){
				alert("删除成功 ");
			})
		}
});