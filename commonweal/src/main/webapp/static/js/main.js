/*����ͷβ*/
$.get("footer.html","HTML",function(data){
    $('footer').html(data);
});
/*����ͷβ*/
$.get("header.html","HTML",function(data){
    $('header').html(data);

});

/*��ת����ҳ*/
function jumpFrist(){
    var t = $('.main_header').offset().top-50;//  ��ȡ��Ҫ��ת����ǩ��topֵ
    $("html,body").animate({ scrollTop: t}, 700); // ��̬��ת��ָ��λ�ã���ֵԽ������ٶ�Խ����

    $("#main_frist").fadeIn();
}
/*������ʱ֪ͨ*/
function a(){
    var par=$("#temp_text");
    var text=par.val();
    create(text);
}
/*������������*/
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