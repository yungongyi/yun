$(function() {
	/* 1.0 */
	// 初始化
	initResourceqian();
});

function initResourceqian() {
	$.ajax({
		url : "/commonweal/resource/getResource",
		type : "GET",
		dataType : "json",
		success : function(data) {
			//alert(data.diushi);
			//alert(data.zhapian);
			//alert(data.shiyaosu);			 
			 $("#diushi").append(data.diushi);		
			 $("#zhapian").append(data.zhapian);
			 $("#shiyaosu").append(data.shiyaosu);
		}
	});
}