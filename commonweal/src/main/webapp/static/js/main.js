/*加载头尾*/
$.get("footer.html","HTML",function(data){
    $('footer').html(data);
});
/*加载头尾*/
$.get("header.html","HTML",function(data){
    $('header').html(data);

});

/*跳转到首页*/
function jumpFrist(){
    var t = $('.main_header').offset().top-50;//  获取需要跳转到标签的top值
    $("html,body").animate({ scrollTop: t}, 700); // 动态跳转到指定位置（数值越大滚动速度越慢）

    $("#main_frist").fadeIn();
}
/*生成临时通知*/
function a(){
    var par=$("#temp_text");
    var text=par.val();
    create(text);
}
/*创建喇叭内容*/
var num=0;
function create(petunia){
    $(".glyphicon-volume-up").css("color","red");
    num=num+20;
    var font = $("#petunia_content");
    var num1=font.parent().width();
    font.text(petunia);
    font.animate({left:num+"px"},"100","linear",function(){
        $(".glyphicon-volume-up").css("color","white");
        if(num<num1){
            create();
        }else{
            font.text("");
            font.css("left","0px");
            num=0;
        }
    });
}