
$(function(){
	
	var noticeId=window.location.href.substring(window.location.href.lastIndexOf("/")+1);
	//加载启事
	initNoticeInfo(noticeId);
});
// 获取启事详细信息
function initNoticeInfo(nId){
	$.get("/commonweal/notice/getNoticeBypId",{id:nId},function(data){
		/*alert(data);*/
		data=JSON.parse(data);
		/*类型*/
		$(".noticetype").text(data.type.typeName);
		$(".noticeInfoImage").attr("src",SERVERIMGPATH+data.resource.resourcePath);
		$(".noticestate").text(data.state.stateName);
		$(".noticecreatedate").text(data.noticeCreateDate);
		$(".noticedetail").text(data.noticeDetail);
		getPersonNameById(data.personId);	
	});
}
function getPersonNameById(id){
	
	$.get("/commonweal/personCenter/getPersonInfoById/"+id,function(data){
		data=JSON.parse(data);
		$(".personname").text(data.name);
		$(".personphone").text(data.iphone);
		alert(data);
	});
}