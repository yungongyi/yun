$(function() {
	/* 1.0 */
	// 初始化
	initCommonweal();
	//左图
	initZuoTu();
	//右Text
	initYouText();	
	//左Text
	initZuoText();	
	//右图
	initYouTu();
});

//初始化
function initCommonweal() {
	$.ajax({
		url : "/commonweal/common/getByNameCommonweal",
		type : "GET",
		dataType : "json",
		success : function(data) {
			$("#yiyi").append(data.yiyi);		
			$("#yungongyi").append(data.yungongyi);
		}
	});
}


//右Text
function initYouText() {

	$.ajax({
		url : "/commonweal/common/getBysrcCommonweal",
		type : "GET",
		dataType : "json",
		success : function(result) {		
			for (var int = 0; int < result.length; int++) {
				$("#youtext")
				.append(	
						"<li><a href='" 
						+result[int].commonwealsrc
						+"'>" 
						+result[int].commonwealText
						+"</a></li>");					
				if(int==5)
					break;
			}		
		}
	});
}


//左Text
function initZuoText() {

	$.ajax({
		url : "/commonweal/common/getBysrcCommonweal",
		type : "GET",
		dataType : "json",
		success : function(result) {		
			for (var int = 0; int < result.length; int++) {
				$("#zuotext")
				.append(	
						"<li><a href='" 
						+result[int].commonwealsrc
						+"'>" 
						+result[int].commonwealText
						+"</a></li>");					
				if(int==10)
					break;
			}		
		}
	});
}


//左图
function initZuoTu() {
	$.ajax({
		url : "/commonweal/common/getBysrcCommonweal",
		type : "GET",
		dataType : "json",
		success : function(result) {	
			$("#zuotuaaa tr:not(:first)").empty("");
			// 遍历
			eachZuoTu(result);		
		}
	});
}


function eachZuoTu(result) {

	//for (var int = 0; int < result.length; int++) {


	$('#zuotu1').attr('href',result[0].commonwealsrc); 
	$('#zuoimg1').attr('src','/commonweal/static/upload/image/'+result[0].resource.resourcePath);
	$('#zuospan1').html(result[0].commonwealText);
	$('#zuotu2').attr('href',result[1].commonwealsrc);  
	$('#zuoimg2').attr('src','/commonweal/static/upload/image/'+result[1].resource.resourcePath);
	$('#zuospan2').html(result[1].commonwealText);

	//$('#zuotu3').attr('href',result[2].commonwealsrc);  
	//$('#zuotu4').attr('href',result[3].commonwealsrc);  
	/*$("#zuotuaaa")
		.append(
				"<div class='item active'>"
				+"<a href='"+result[int].commonwealsrc+"'> " 
				+"<img src='/commonweal/static/upload/image/"+result[int].resource.resourcePath+"'>" +
						"<span class='carousel-caption qmgy_carousel-caption'>'"+ result[int].commonwealText+"'</span>"
				+"</a> " 
				+"</div>");
		if(int==4)
			break;*/
	//}	

}
//右图
function initYouTu() {
	$.ajax({
		url : "/commonweal/common/getBysrcCommonweal",
		type : "GET",
		dataType : "json",
		success : function(result) {	
			$("#youtuaaa tr:not(:first)").empty("");
			// 遍历
			eachYouTu(result);		
		}
	});
}

function eachYouTu(result) {


	$('#youtu1').attr('href',result[0].commonwealsrc); 
	$('#youimg1').attr('src','/commonweal/static/upload/image/'+result[0].resource.resourcePath);
	$('#youspan1').html(result[0].commonwealText);
	$('#youtu1').attr('href',result[1].commonwealsrc);  
	$('#youimg2').attr('src','/commonweal/static/upload/image/'+result[1].resource.resourcePath);
	$('#youspan2').html(result[1].commonwealText);

}

$("#getPartner")
.click(
		function() {
			$("#Partner").html("");
			$
			.ajax({
				url : "/commonweal/common/getPartner",
				type : "GET",
				dataType : "JSON",
				success : function(result) {
					for (var int = 0; int < result.length; int++) {
						$("#Partner")
						.append(
								"<img src='"
								+ "/commonweal/static/upload/image/"
								+ result[int].resource.resourcePath
								+"		'class='img-circle qmgy-imggx col-md-2 col-xs-6'> ");
						if(int==6)
							break;
					}				
				}
			});
		});












/*<div class="item">
<a href="#"> <img
src="/yungongyi/statics/main/images/welfare/welfare-09.jpg">

<span class="carousel-caption qmgy_carousel-caption">上海市文明城区名单和2014-2015年度上
</span>
</a>
</div>
<div class="item">
<a href="#"> <img
src="/yungongyi/statics/main/images/welfare/welfare-05.jpg">
<span class="carousel-caption qmgy_carousel-caption">2015年度上海市社会主义精神文明好人好
</span>
</a>
</div>

<div class="item">
<a href="#"> <img
src="/yungongyi/statics/main/images/welfare/welfare-06.jpg">
<span class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
</a>
</div>*/