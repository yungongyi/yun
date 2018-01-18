/**
 * 
 */
//后端服务器路径
SERVERPATH="http://127.0.0.1:8080/commonweal/";
//后端图片资源路径
SERVERIMGPATH=SERVERPATH+"static/upload/image/"
HOST=window.location.host;
var websocket;
var str=""
$(function(){
	if ('WebSocket' in window) {
		  websocket = new WebSocket("ws://"+HOST+"/commonweal/websocket/socketServer.do");
	} else if ('MozWebSocket' in window) {
	        websocket = new MozWebSocket("ws://"+HOST+"/commonweal/websocket/socketServer.do");
	    } 
	    else {
	        websocket = new SockJS("http://"+HOST+"/commonweal/sockjs/socketServer.do");
	      
	    }
	    
	    websocket.onopen= onOpen;
	    websocket.onmessage = onMessage;
	    websocket.onerror = onError;
	    
	
});

function onOpen(openEvt) {
    
}
function onMessage(event) {
	setTimeout(function(){
		horn(event.data);
	}, 1000);

}
function onError(evt) {
	
	console.log(evt.Data);
}
function onClose() {
	console.log(evt.Data);
}
//给某个人发送消息
function sendToUser(msg,rId){
	if (websocket.readyState == websocket.OPEN) { 
		var newMsg=new Object();
		newMsg.message=msg;
		newMsg.receiveId=rId;
		websocket.send(JSON.stringify(newMsg));
	}  
}
//给所有人发送消息
function sendAll(ip,str){
	 if (websocket.readyState == websocket.OPEN) {   
		 var obj = new Object(); 
		 obj.ip = "dog"; 
		 obj.msg = "Male"; 
		 websocket.send(JSON.stringify(obj));
	 }      
}
//发送消息
function doSend() {
    if (websocket.readyState == websocket.OPEN) {          
        var msg = document.getElementById("inputMsg").value;  
        let obj = {};
        obj.from = 1;
        obj.to = 2;
        obj.msg=msg
        websocket.send(JSON.stringify(obj));  //调用后台handleTextMessage方法       
        alert("发送成功!");  
    } else {  
        alert("连接失败!");  
    }  
}
//播放声音
function voice(str){
	var ss=encodeURI(str);
	var myvoi='https://tsn.baidu.com/text2audio?per=3&tex='+ss+'&lan=zh&cuid=1235542&ctp=1&tok=24.13b72b8effce43c186f4c2fd107aba87.2592000.1517318283.282335-10609142';
	$("#voiceAudio").attr("src",myvoi);
}