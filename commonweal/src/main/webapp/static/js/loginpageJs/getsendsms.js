$(function(){
	
	 $("#sendsms").click(function(){
		var fphone = $("input[name='fphone']").val();
		alert(fphone);
		$.ajax({
			url:"/commonweal/login/getiphone/"+fphone,
			dataType:"json",
			success:function(data){
				alert(data);
			},
			error:function(error){
				alert(error);
			}
		});
	});
});