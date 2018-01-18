
$(function() {
	
	/* 1.设置ajax同步 */
	$.ajaxSetup({
		async : false
	});
	var content=window.location.href.substring(window.location.href.lastIndexOf("/")+1);
	alert(content);
	if(content!="null"){
		$('input[name="describe"]').val(content);
		getAllNotice();
	}
	/* 2.初始化加载 */
	getRegionById(1, "porvince");	
	getRegionById(2, "city");	
	getRegionById(4, "area");	
	getState();
	getType();
	getAllNotice();

});
function selectPAndC(){
	/* 1.选中省获取市 */
	$("#porvince").change(function() {
		getRegionById($(this).val(), "city");
	});
	/* 2.选中市获取区  */
	$("#city").change(function() {
		getRegionById($(this).val(), "area");		
	});
}
//根据类型查询
$(".types").click(function(){
	$(this).siblings().removeClass("actives");
	$(this).addClass("actives");					
	getAllNotice();
});
//关键字查询
$(".describesearch").click(function(){
	getAllNotice();
});

//
/* 3.根据父id查询地区  父-id 标签id-eleId */
function getRegionById(id, eleId) {
	$.get("/commonweal/region/getAllRegion/"+id,"JSON",
			function(data) {
		var str = "";
		if (eleId == "area") {
			str += '<li class="areas actives " value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</li>';
		}
		$.each(JSON.parse(data),function(idx,obj) {
			/* 判断是否为区域 */
			if (eleId == "area") {
				str += '<li class="areas" value="'+obj.regionId+'">'
				+ obj.regionName
				+ '</li>';
			}else{
				if(obj.regionName == '河南'
					|| obj.regionName == '郑州') {
					str += '<option selected="selected" value="'+obj.regionId+'">'
					+ obj.regionName
					+ '</option>';
				}else{
					str += '<option value="'+obj.regionId+'">'
					+ obj.regionName
					+ '</option>';
				}
			}
		});// end of each									
		$("#" + eleId).html(str);
		selectPAndC();
		/* 选中区获取启事 */
		$(".areas").click(function() {
			$(this).siblings().removeClass("actives");
			$(this).addClass("actives");		
			getAllNotice();			
		});
	});
}
/* 4.查询所有启事 */
function getAllNotice() {
	var typeId=$(".types.actives").val();
	var regionId=$(".area .actives").val();
	var stateId=$(".states.actives").val()
	var word=$('input[name="describe"]').val();
	$.get('/commonweal/notice/getNoticeBySelect',
			{regionId:regionId,typeId:typeId,stateId:stateId,word : word},		
			function(data) {
				var str = "";
				$.each(JSON.parse(data),function(index,obj) {
					str += '<div class="col-lg-3 col-md-6 col-xs-12" ><div style="position: relative;" class="notice"><img  src="'
						+SERVERIMGPATH+obj.resource.resourcePath
						+'" class="img-responsive img-rounded" />'
						+'<p class="detail" style="text-align:center;padding-top:1.5em;display:none;background:rgba(0, 54, 54, 0.5);position:absolute;width:100%;height:50%;top:20%;color:white;">'+obj.noticeDetail+'</p>'
						+'<p class="text-center" style="padding: 10px;">'
						+ obj.noticeTittle
						+ '</p><p class="text-center noticeid" style="display: none;">'
						+ obj.noticeId
						+ '</p></div></div>';
				});
				$("#ajaxNotice").html(str);
				/*图片悬浮效果*/
				imgHover();
				/*查看启事详细信息*/
				imgClick();
			});
}
function imgHover(){
	//悬浮效果
	$(".notice").hover(function(){
		$(this).children().eq(1).fadeIn();
	},function(){
		$(this).children().eq(1).fadeOut();
	});
}
function imgClick(){
	//悬浮效果
	$(".notice").click(function(){
		var id=$(this).children(".noticeid").text();
		window.location.href="/yungongyi/noticeinfo/"+id;
	});
}
//5.查询所有状态
function getState(){
	$.get("/commonweal/state/getStateByTableId/"+6,function(data){
		var str='<li class="states actives " value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</li>';
		$.each(JSON.parse(data),function(index,obj) {
			str+='<li class="states" value="'+obj.stateId+'">'+obj.stateName+'</li>';
		});
		$(".state").html(str);
		$(".states").click(function(){
			$(this).siblings().removeClass("actives");
			$(this).addClass("actives");					
			getAllNotice();
		});
	});
}
//6.查询所有类型
function getType(){
	$.get("/commonweal/type/getType/"+6,function(data){
		var str='<li class="types actives " value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</li>';
		$.each(JSON.parse(data),function(index,obj) {
			str+='<li class="types" value="'+obj.typeId+'">'+obj.typeName+'</li>';
		});
		$(".type").html(str);
		$(".types").click(function(){
			$(this).siblings().removeClass("actives");
			$(this).addClass("actives");					
			getAllNotice();
		});
	});
}
//大于320px点击选项条件的jq