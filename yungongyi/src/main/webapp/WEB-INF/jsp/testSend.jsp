<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
	<script type="text/javascript">
	
	var websocket;
	var str=""

	$(function(){
		if ('WebSocket' in window) {
			  websocket = new WebSocket("ws://localhost:8080/yungongyi/websocket/socketServer.do");
		} else if ('MozWebSocket' in window) {
		        websocket = new MozWebSocket("ws://localhost:8080/yuingongyi/websocket/socketServer.do");
		    } 
		    else {
		        websocket = new SockJS("http://localhost:8080/yuingongyi/sockjs/socketServer.do");
		      
		    }
		    
		    websocket.onopen= onOpen;
		    websocket.onmessage = onMessage;
		    websocket.onerror = onError;
		  
		
	});

	function onOpen(openEvt) {
	    alert(openEvt.Data);
	}

	function onMessage(event) {
	     alert("收到消息"+event.data); 
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
	/* var host = window.location.host;
	var websocket;
	if ('WebSocket' in window) {
		  websocket = new WebSocket("ws://"
	        + host + "/yungongyi/websocket/socketServer.do");
	} else if ('MozWebSocket' in window) {
	    websocket = new MozWebSocket("ws://" + host
	        + "/websocket/socketServer.do");
	} else {
	    websocket = new SockJS("http://" + host
	            + "/sockjs/socketServer.do");
	}
	websocket.onopen = function(evnt) {
		alert(evnt.Data);
	    console.log("websocket连接上");
	};
	websocket.onmessage = function(evnt) {
	   /*  messageHandler(evnt.data); */
	/* };
	websocket.onerror = function(evnt) {
	    console.log("websocket错误");
	};
	websocket.onclose = function(evnt) {
	    console.log("websocket关闭");
	}  */
</script>
	<label id="mmm"></label> <br>
	请输入消息内容：
	<textarea rows="10" cols="20" id="inputMsg" name="inputMsg"></textarea>
	请输入发送给谁
	<input type=text id="phoneNum" value="" />
	<button onclick=" doSend();">发送</button>
</body>
</html>