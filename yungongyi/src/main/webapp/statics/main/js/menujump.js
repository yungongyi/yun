
$(function(){ 
	
	//进入启示大厅加载启示信息
	$.ajax({
		url:"/commonweal/main/getmainnotice",
		dataType:"JSON",
		success:function(data){ 
			$.each(data,function(index){
				if(index>7){
					return ;
				}
				$("#noticelist").append("<div class='mainnotice col-lg-3 col-md-6 col-sm-6 work'> " +
						"     <p style='display:none' class='mainnoticeid'>"+data[index].noticeId+" </p>"+
						"<a href='/yungongyi/noticeinfo/"+data[index].noticeId+"' class='work-box'>"+
						" <img src='"+SERVERIMGPATH+data[index].resource.resourcePath+"' alt=''>"+
						"<div class='overlay'>"+
						" <div class='overlay-caption'>"+
						"   <p>"+data[index].noticeTittle+" </p>"+
						"     <p>"+data[index].noticeCreateDate+" </p>"+					
						"    </div>"+
						"   </div> "+
						"<!-- overlay --> "+
				"  </a> </div>" );
			});
			
		},
		error:function(error){
			alert(error)
		}
	});
	//悬浮效果
	$(".mainnotice").click(function(){
		var id=$(this).children(".mainnoticeid").text();
		window.location.href="/yungongyi/noticeinfo/"+id;
	});
	//启示大厅菜单 
	$(".noticepage").click(function(){ 
		window.location.href="/commonweal/notice/allnoticeby/0/kong/0/0"; 
	});
	//点击启示菜单
	$(document).on("click",".mainnotice",function(){
		var noticeId=$(this).children().children().children().children(".mainnoticeid").html(); 
		window.location.href="/commonweal/notice/allnoticebyId/"+noticeId;  
	});
	
	$("#noticesearch").click(function(){
		var Content=$("input[name=Content]").val();
		alert(Content);
		window.location.href="/yungongyi/notice.html/"+Content; 
	});
	// Header Scroll
	$(window).on('scroll', function() {
		var scroll = $(window).scrollTop();

		if (scroll >= 50) {
			$('#header').addClass('fixed');
		} else {
			$('#header').removeClass('fixed');
		}
	});

	// Fancybox
	$('.work-box').fancybox();

	// Flexslider
	$('.flexslider').flexslider({
		animation: "fade",
		directionNav: false,
	});

	// Page Scroll
	var sections = $('section')
		nav = $('nav[role="navigation"]');

	$(window).on('scroll', function () {
	  	var cur_pos = $(this).scrollTop();
	  	sections.each(function() {
	    	var top = $(this).offset().top - 76
	        	bottom = top + $(this).outerHeight();
	    	if (cur_pos >= top && cur_pos <= bottom) {
	      		nav.find('a').removeClass('active');
	      		nav.find('a[href="#'+$(this).attr('id')+'"]').addClass('active');
	    	}
	  	});
	});
	nav.find('a').on('click', function () {
	  	var $el = $(this)
	    	id = $el.attr('href');
		$('html, body').animate({
			scrollTop: $(id).offset().top - 75
		}, 500);
	  return false;
	});

	// Mobile Navigation
	$('.nav-toggle').on('click', function() {
		$(this).toggleClass('close-nav');
		nav.toggleClass('open');
		return false;
	});	
	nav.find('a').on('click', function() {
		$('.nav-toggle').toggleClass('close-nav');
		nav.toggleClass('open');
	});
	

});


