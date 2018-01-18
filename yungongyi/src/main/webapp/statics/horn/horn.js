/**
 * Created by Administrator on 2017\12\27 0027.
 */
/*调用实例*/
$(function(){
    loadHorn();
});

//加载喇叭
function loadHorn(){
    $("body").append('<img id="horn" src="/yungongyi/statics/horn/horn.png" style="width:5em;position: fixed;left: 2%;bottom: 3em;z-index: 9999"/>'
        +'<div style="overflow:hidden;z-index:999;border-radius: 8px;position:fixed;background-color: black;opacity: 0;width:70%;height: 3em;left: 15%;top:10%;">'
        +'<p id="horn_text" style="position:relative;border-radius: 8px;'
        +'background-color: black;color: white;opacity:1;position: absolute;top: 0.3em;left:0;bottom:80%;">'
        +'</p></div>');
}
/*输入内容*/
function horn(str){
	
    /*喇叭图标*/
    var horn= $("#horn");
    /*字体*/
    var horn_text=$("#horn_text");
    /*上去*/
    horn.animate({left:'15%',bottom:"87%",width:'10em'},1000,function(){
    	voice(str);
        horn_text.parent().animate({opacity:"0.8"},1000,function(){
            /*播放文字*/
            horn_text.text(str);
            horn_text.animate({opacity:"0.8",left:"100%"},5000,function(){
            	
                /*播放声音*/
            	horn_text.text("");
            	horn_text.css("left","0");
                horn.animate({width:'5em',left:'3em',bottom:"3em"},1000);
                horn_text.parent().animate({opacity:"0"},1000);
            });
        });

    });
}
