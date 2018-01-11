$(function(){
	var tablewaring = $("#tablewaring");//获取修改提示框
	//获取所有模块数据
	function gettablelist(tablecombox){
		tablecombox.html('');
		$.ajax({
			url:"/commonweal/table/alltable.html",
			type:"get",
			dataType:"json",
			success:function (data){
				tablecombox.append("<option value='0' selected = 'selected'>请选择</option>");
				$.each(data,function(index){
					tablecombox.append("<option value="+data[index].tableId+">"+data[index].tableNameZh+"</option>");
				});
			},error:function(data){ 
				tablewaring.css('color','red');
				tablewaring.html("查询出错！请联系开发者！");
			}
		}); 
	}
	//单击模块管理时
	$("#tablemanage").click(function(){
		//获取模块下拉框
		var tablemanage=$("#tableManagesList"); 
		//点击时先清空一下
		tablemanage.html('');
		var stateList=$("#stateList"); 
		var typeList=$("#typeList");
		stateList.html("<option value='0' selected = 'selected'>所有状态</option>");
		typeList.html("<option value='0' selected = 'selected'>所有类型</option>");
		gettablelist(tablemanage);
	});

	
	//模块下拉框选项改变时
	$("#tableManagesList").bind('change',function(){  
		var tableId=$("#tableManagesList").val(); 
		//获取模块id
		var stateList=$("#stateList"); 
		var typeList=$("#typeList"); 
		//刷新列表
		stateList.html('');
		typeList.html('');
		
		if(tableId!=0){

			$.ajax({
				url:"/commonweal/table/alltypebytable/"+tableId,
				type:"get",
				dataType:"json",
				success:function (data){ 
					//循环data
					for ( var key in data) {
						var lists = data[key];
						//获取type集合
						if(key=="types"){
							if(lists.length==0)
								typeList.append("<option value='0' selected = 'selected' >该模块的没有类型</option>");
							else
								typeList.append("<option value='0' selected = 'selected' >该模块的所有类型</option>");
							for(var entity in lists){
								//alert(entity); // 输出为该集合的对象下标
								typeList.append("<option value="+lists[entity].typeId+">"+lists[entity].typeName+"</option>");
							}
							//获取state集合
						}else if(key=="states"){
							if(lists.length==0)
								stateList.append("<option value='0' selected = 'selected' >该模块的没有状态</option>");
							else
								stateList.append("<option value='0' selected = 'selected'>该模块的所有状态</option>");
							for(var entity in lists){
								//alert(entity); // 输出为该集合的对象下标
								stateList.append("<option value="+lists[entity].stateId+">"+lists[entity].stateName+"</option>");
							}
						}
					}
				}      
			,error:function(data){ 
				alert('出错了：'+data);
			}
			}); 
		}else{
			stateList.append("<option value='0' selected = 'selected' >所有状态</option>");
			typeList.append("<option value='0' selected = 'selected' >所有类型</option>");
		}
	});

	//新增模块
	$(".tablefind").click(function(){
		var tablewaring = $("#tablewaring");//获取修改提示框
		tablewaring.html('');
		var tablewaring = $("#tablewaring");//获取修改提示框
		var tableNameZH=$("input[name='tableNameZH']").val();//中文名
		var tableNameUK =$("input[name='tableNameUK']").val();//英文名
		if(tableNameZH==""||tableNameUK==""){
			tablewaring.css('color','red');
			tablewaring.html("模块信息不能为空！");
		}else{
			$.ajax({
				url:"/commonweal/table/addTable/"+tableNameZH+"/"+tableNameUK ,
				type:"get",
				dataType:"json",
				success:function(data){
					if(data!=1){
						tablewaring.css('color','red');
						tablewaring.html("添加失败！");
					}else{
						tablewaring.css('color','green');
						tablewaring.html("添加成功！");
						//刷新
						gettablelist($("#tableManagesList"));
					}
				},
				error:function(data){
					tablewaring.css('color','red');
					tablewaring.html("添加失败！");
				}
			});
		}
	});


	//点击编辑状态
	$(".addstates").click(function(){ 
		tablewaring.html("");
		var statelist=$("#selectState");
		gettablelist(statelist); //获取模块下拉框  
	});
	//点击保存编辑状态
	$("#stateSubmit").click(function(){
		
		var tableId=$("#selectState").val();
		var stateName = $("input[name='stateName']").val();
		if(tableId==0||stateName==""){
			tablewaring.css('color','red');
			tablewaring.html("状态信息不能为空！");
		}else{
			$.ajax({
				url:"/commonweal/state/insertstate/"+stateName+"/"+tableId,
				type:"get",
				dataType:"json",
				success:function (data){
					tablewaring.css('color','green');
					tablewaring.html("添加成功！");
					gettablelist($("#tableManagesList"));
				},error:function(data){ 
					tablewaring.css('color','red');
					tablewaring.html("添加失败！");
				}
			}); 
		}
	});
	
	//点击编辑状态
	$(".addtypes").click(function(){ 
		tablewaring.html("");
		var typelist=$("#selectType");
		gettablelist(typelist); //获取模块下拉框  
	});
	//点击保存编辑状态
	$("#typeSubmit").click(function(){
		var tableId=$("#selectType").val();
		var typeName = $("input[name='typeName']").val();
		if(tableId==0||typeName==""){
			tablewaring.css('color','red');
			tablewaring.html("类型信息不能为空！");
		}else{
			$.ajax({
				url:"/commonweal/type/addType/"+typeName+"/"+tableId,
				type:"get",
				dataType:"json",
				success:function (data){
					tablewaring.css('color','green');
					tablewaring.html("添加成功！");
					gettablelist($("#tableManagesList"));
				},error:function(data){ 
					tablewaring.css('color','red');
					tablewaring.html("添加失败！");
				}
			}); 
		}
	});
});