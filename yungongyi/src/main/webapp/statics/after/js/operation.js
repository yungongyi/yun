$(function(){
	$("#operationmanage").click(function(){
		$("#operationlist").html("<tr style='background: #cccccc;'>"+
				"<th>操作编号</th>"+
				"<th style='display:none'>操作ID</th>"+
				"<th>操作人</th>"+
				"<th>操作时间</th>"+
				"<th>操作描述</th>"+
		"</tr>");
		$("#operationlist tr:not(:first)").empty("");
		$.ajax({
			url:"/commonweal/operation/getoperations",
			type:"GET",
			dataType:"json",
			success:function(data){
				$.each(data,function(index){
					$("#operationlist").append("<tr class='operationtr'>"+
							"<th><span>"+(index+1)+"</span></th>"+
							"<th style='display:none'><span>"+data[index].operationId+"</span></th>"+
							"<th><span>"+data[index].personId+"</span></th>"+ 
							"<th><span>"+data[index].operationDate+"</span></th>"+ 
							"<th><span>"+data[index].operationNote+"</span></th>"+ 
					"</tr>");
				});
				gopage(".operationtr",1,4);
			}
		,
		error :function(data){
			//失败就返回这个
			alert(data);
		}
		});
	});
	$("#operationsearch").click(function(){
		$("#operationlist tr:not(:first)").empty("");
		var  operationPersonName = $("input[name=operationPersonName]").val();
		if(operationPersonName==null||operationPersonName==""){
			operationPersonName ="all";
		} 
		$.ajax({ 
			url:"/commonweal/operation/getoperationsByPersonName/"+operationPersonName,
			type:"GET",
			dataType:"json",
			success:function(data){ 
				$("#operationlist").html("<tr style='background: #cccccc;'>"+
						"<th>操作ID</th>"+
						"<th>操作时间</th>"+
						"<th>操作表</th>"+
						"<th>操作类型</th>"+
						"<th>操作人</th>"+
				"</tr>");
				$("#operationlist tr:not(:first)").empty("");
				if(data==""){
					$("#operationlist").append("<p style='color:red;padding-top:20px' class='text-right'>该管理员暂未进行任何操作</p>");	
				}else{  
					$.each(data,function(index){ 
						$("#operationlist").append("<tr >"+
								"<th><span>"+data[index].operationId+"</span></th>"+
								"<th><span>"+data[index].operationDate+"</span></th>"+
								"<th><span>"+data[index].tableId+"</span></th>"+
								"<th><span>"+data[index].type.typeName+"</span></th>"+
								"<th><span>"+data[index].personId+"</span></th>"+
						"</tr>");
					});
					gopage("#operationtr",1,4);
					}
			}
		,
		error :function(data){
			//失败就返回这个
			alert(data);
		}
		});
	});
});