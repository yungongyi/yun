
/**
 * 2018-1-12 孙家伟
 */
//1.将ajax获取的时间戳(获取过来它自动转换为时间戳)转换成时间(年:月:日 时:分:秒)
function getMyDate(str) {
	var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
	.getMonth() + 1, oDay = oDate.getDate(), oHour = oDate.getHours(), oMin = oDate
	.getMinutes(), oSen = oDate.getSeconds(), oTime = oYear + '-'
	+ getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':'
	+ getzf(oMin) + ':' + getzf(oSen);
	return oTime;
}
//2.补0操作
function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}

//根据发送人id获取发送人电话
function getTelById(personId) {
	var phone = "";
	$.ajax({
		url : "/commonweal/personCenter/getTelById",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "JSON",
		success : function(data) {
			phone = data;
		}
	});
	return phone;
};

//根据发送人id获取发送人
function getSendNameById(personId) {
	var sendName = "";
	$.ajax({
		url : "/commonweal/personCenter/getPersionName",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "text",
		success : function(data) {
			sendName = data;
		}
	});
	return sendName;
};
//根据收信人id获取收信人
function getReceiveNameById(personId) {
	var recName = "";
	$.ajax({
		url : "/commonweal/personCenter/getPersionName",
		data : "personId=" + personId,
		type : "GET",
		async : false,
		dataType : "text",
		success : function(data) {
			recName = data;
		}
	});
	return recName;
}

