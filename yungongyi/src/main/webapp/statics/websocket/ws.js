/**
 * websocket
 */
var websocket = null;
var str=""

$(function(){

	    if ('WebSocket' in window) {
	        websocket = new WebSocket("ws://localhost:8080/yungongyi/websocket/socketServer.do");
	    } 
	    else if ('MozWebSocket' in window) {
	        websocket = new MozWebSocket("ws://localhost:8080/yungongyi/websocket/socketServer.do");
	    } 
	    else {
	        websocket = new SockJS("http://localhost:8080/yungongyi/sockjs/socketServer.do");
	      
	    }
	    
	    websocket.onopen= onOpen;
	    websocket.onmessage = onMessage;
	    websocket.onerror = onError;
	    
	
});

function onOpen(openEvt) {
    alert(openEvt.Data);
}

function onMessage(evt) {
	alert(evt.Data);
}

function onError(evt) {
	console.log(evt.Data);
}
function onClose() {
	console.log(evt.Data);
}

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
