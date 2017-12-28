$(function() {
	//地域的全局提示信息
	var waring = $("#territoryWaring");

	//获取所有的省份
	function getProvince(provinces){
		$.ajax({
			url:"/commonweal/territory/getprovince.html",
			dataType:"json",
			success:function(data){
				$.each(data, function(index){  
					provinces.append("<option	value="+data[index].provinceId+">"+data[index].provinceName+"</option>");
				});
			}
		});
	}
	//获取所有的城市
	function getCity(provinceId,citys,areas){
		$.ajax({
			url:"/commonweal/territory/getcity/"+provinceId,
			dataType:"json",
			success:function(data){
				if(data==""){
					citys.append("<option value=-2>未找到对应城市</option>");
					areas.html('');
					areas.append("<option value=-2>未找到对应区县</option>");
					return;
				}
				citys.append("<option value=-1 >城市列表</option>");
				$.each(data, function(index){
					citys.append("<option	value="+data[index].cityId+">"+data[index].cityName+"</option>");
				});
			}
		});
	}
	//获取所有的区县
	function getArea(citysId,areas){
		$.ajax({
			url:"/commonweal/territory/getarea/"+citysId,
			dataType:"json",
			success:function(data){ 
				if(data==""){
					areas.append("<option value=-2>未找到对应区县</option>");
					return;
				}
				areas.append("<option value=-1 selected='selected'>区县列表</option>");
				$.each(data, function(index){ 
					areas.append("<option	value="+data[index].areaId+">"+data[index].areaName+"</option>");
				});
			}
		});
	}

	//获取所有的省份信息
	$("#territorymanage").click(function(){
		var provinces= $("#provinces");
		provinces.html('<option value=-1 >省份列表</option>');
		getProvince(provinces);
	});
	//获取所有的 城市信息
	$("#provinces").bind("change",function(){
		var provinceId = $(this).val(); 
		var citys = $("#citys"); 
		citys.html('');
		var areas = $("#areas"); 
		//如果选择了某个省份
		if(provinceId!=-1){
			//调用获取城市的方法
			getCity(provinceId,citys,areas); 
		}else{
			//如果没有选中则显示请选择城市
			citys.append("<option value=-1 >城市列表</option>");
			areas.html('');
			areas.append("<option value=-1 >区县列表</option>");
		}
	});

	//获取所有的 区域信息
	$("#citys").bind("change",function(){
		var citysId = $(this).val();
		var areas = $("#areas");
		areas.html('');
		//如果选择了某个城市
		if(citysId!=-1){
			//调用获取区域的方法
			getArea(citysId,areas);
		}else{
			//如果没有选中则显示请选择城市
			areas.html('');
			areas.append("<option value=-1>区县列表</option>");
		}
	});

	//---------------------------------------------------------------------------------------------
	//插入一条省份信息
	$('#saveProvince').click(function(){
		var provinceName= $("input[name='saveprovinceName']").val();
		alert(provinceName);
		if(provinceName!=null && provinceName!=""){
			$.ajax({
				url:"/commonweal/territory/saveprovince/"+provinceName,
				dataType:"json",
				success:function(data){
					if(data>=1){
						waring.html('省份： '+provinceName +' 添加成功');
						var provinces= $("#provinces");
						//先清空再查询
						provinces.html('<option value=-1>省份列表</option>');
						getProvince(provinces);
					}else{
						waring.html('省份： '+provinceName +' 添加失败'); 
					}
				}
			});
		}else{
			waring.html('省份名称不能为空');
		}

	});
//	---------------------------------------------------------------------------------------
	//插入一条城市信息
	$('#editCity').click(function(){ 
		//点击编辑城市信息时，查询所有省份
		var provinces=$("#savecitybyProvince");
		provinces.html('<option value=-1>请选择省份信息</option>');
		getProvince(provinces);
	});
	//点击提交
	$("#saveCity").click(function(){ 
		var provinceid=$("#savecitybyProvince").val();
		var cityName= $("input[name='savecityName']").val(); 
		if(provinceid!=-1){
			if(cityName!='' && cityName!=null ){
				$.ajax({
					url:"/commonweal/territory/savecity/"+provinceid+"/"+cityName,
					dataType:"json",
					success:function(data){
						if(data>=1){
							waring.html( '城市： '+cityName +' 添加成功');
							var provinces= $("#provinces");
							//先清空再查询
							provinces.html('<option value=-1>省份列表</option>');
							getProvince(provinces);
						}else{
							waring.html('城市： '+cityName +' 添加成功');
						}
					}
				});
			}else{
				waring.html('城市名称不能为空');
			}
		}else{
			waring.html('请选择一个省份');
		}
	});
//	-----------------------------------------------------------------------------------------------------
	//插入一条区域 信息
	$('#editArea').click(function(){ 
		//点击编辑城市信息时，查询所有省份
		var provinces=$("#saveareabyProvince");
		provinces.html('<option value=-1>请选择省份信息</option>');
		getProvince(provinces);
	});


	//获取所有的 城市信息
	$("#saveareabyProvince").bind("change",function(){
		var citys = $("#saveareabyCity"); 
		var areas = $("#saveareabyArea"); 
		citys.html('');
		//如果选择了某个城市
		if($("#saveareabyProvince").val()!=-1){
			//调用获取区域的方法
			getCity($("#saveareabyProvince").val(),citys,areas);
		}else{
			//如果没有选中则显示请选择城市
			citys.html('<option value=-1>请选择城市信息</option>'); 
		}
	});
	//点击添加按钮添加一个区域信息
	$("#saveArea").click(function(){
		//获取省份，城市，区县，的引用
		var provinceId = $("#saveareabyProvince").val();
		var citysId = $("#saveareabyCity").val();
		var areaName = $("input[name='saveareaName']").val();
		//如果不选择 省份
		if(provinceId != -1 ){
			//如果不选择城市
			if(citysId != -1){
				//如果不填区县
				if(areaName !=null && areaName !=''){
					$.ajax({
						url:"/commonweal/territory/savearea/"+citysId+"/"+areaName,
						dataType:"json",
						success:function(data){
							if(data>=1){
								waring.html('区县： '+areaName +' 添加成功');
								var provinces= $("#provinces");
								//先清空再查询
								provinces.html('<option value=-1>省份列表</option>');
								getProvince(provinces);
							}else{
								waring.html('区县： '+areaName +' 添加成功');
							}
						}
					});
				}else{
					waring.html('区县不能为空');
				}
				
			}else{
				waring.html('城市不能为空');
			}
		}else{
			waring.html('省份不能为空');
		}

	});
});

