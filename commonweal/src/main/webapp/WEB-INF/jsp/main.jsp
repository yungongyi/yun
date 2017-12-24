<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>云公益首页</title>
    <link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=basePath%>/static/css/main.css" rel="stylesheet"/>
    <style>
    </style>
</head>
<body>
 
<!--首页-->

<div id="main" >
    <!--顶部轮播图-->
    <div  class="main_body_carou carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="item active">
                <img   src="<%=basePath%>/static/image/zhuye/main_06.jpg">
            </div>
            <div class="item">
                <img src="<%=basePath%>/static/image/zhuye/main_06.jpg">
            </div>
            <div class="item">
                <img src="<%=basePath%>/static/image/zhuye/main_06.jpg">
            </div>
        </div>
        <!--大喇叭-->
        <div class="main_horn" >
            <p id="petunia" ><span class="glyphicon glyphicon-volume-up"></span><span id="petunia_content"></span></p>
        </div>
    </div>
    <!--头部导航-->
    <div class="main_header">
        <ul class="nav nav-tabs">
            <li class=""><a onclick="jumpFrist();" >进入首页</a></li>
            <li class=""><a href="<%=basePath%>/jsp/noticehall.jsp" >启事大厅</a></li>
            <li class=""><a href="<%=basePath%>/jsp/welfare.jsp" >全民公益</a></li>
            <li class=""><a href="<%=basePath%>/jsp/literacy.jsp" >系统推送</a></li>
            <li class="" ><a href="<%=basePath%>/jsp/personcenter.jsp" >个人中心</a></li>
        </ul>
    </div>
</div>
<div id="main_frist" class="container" style="display: none">
    <!--轮播+快捷-->
    <div id="main_body" class="row">
        <!--第一行左侧-->
        <div   class="main_body_left col-md-7 col-xs-12">
            <!--临时喊话-->
            <div id="temp_advise">
                <p ><span class="h2">临时喊话</span><button  onclick="a();" class="col-md-6 btn btn-success">点击喊话</button></p>
                <textarea id="temp_text"></textarea>
            </div>
            <!--加入公益-->
            <div class="row">
                <div class="col-md-6 col-xs-6 text-center">
                    <img class="main_reg" src="<%=basePath%>/static/image/zhuye/main_07.jpg" />
                    <br />
                    <a class="h4 " href="<%=basePath%>/jsp/welfare.jsp">马上加入公益队伍</a>
                </div>
                <div class="col-md-6 col-xs-6 text-center">
                    <img class="main_log" src="<%=basePath%>/static/image/zhuye/main_01.jpg"style="height: 134px;" />
                    <br />
                    <a class="h4 " href="<%=basePath%>/jsp/loginpage.jsp">已有账号马上登录</a>
                </div>
            </div>
        </div>
        <!--历史通知-->
        <div  class=" col-md-5  col-xs-12 main_body_right" >
            <div>
                <h2 class="text-danger">历史通知</h2>
                <ul id="" class="list-unstyled list-group">
                    <li class="list-group-item">系统更新<span class="badge">2017-12-5 4:14</span></li>
                    <li class="list-group-item">账号封禁<span class="badge">2017-12-4 4:14</span></li>
                    <li class="list-group-item">重大事件<span class="badge">2017-12-2 4:14</span></li>
                    <li class="list-group-item">新增了发短消息功能<span class="badge">2017-12-4 4:14</span></li>
                    <li class="list-group-item">重大事件<span class="badge">2017-12-2 4:14</span></li>
                </ul>
            </div>
        </div>

    </div>
    <!--友情提示+紧急寻人-->
    <div  class="hotTop row">
        <!--友情提示-->
        <div class=" col-md-3 col-xs-12 hotTop_left">
            <div >
                <h2>友情提示</h2>
                <div  class="panel-info">
                    <p >春节来临。最近郑州小偷较多，请妥善保管自己的物品</p>
                </div>
            </div>
        </div>
        <!--紧急寻人-->
        <div class=" col-md-9 col-xs-12 hotTop_right">
            <div class="row" >
                <h2 class="text-info">紧急寻人</h2>
                <a class="col-md-3 col-xs-12 thumbnail">
                    <img src="<%=basePath%>/static/image/zhuye/person_01.jpg">
                </a>
                <a class="col-md-3 col-xs-12 thumbnail">
                    <img src="<%=basePath%>/static/image/zhuye/person_01.jpg">
                </a>
                <a class="col-md-3 col-xs-12 thumbnail">
                    <img src="<%=basePath%>/static/image/zhuye/person_01.jpg">
                </a>
            </div>
        </div>
    </div>
    <!--寻物体-->
    <div class="hint row">

        <div class="col-md-12 col-xs-12">
            <h2>急着找物品</h2>
            <div class="col-md-3 col-xs-6">
                <a class="thumbnail"><img src="<%=basePath%>/static/image/goods/工作证.jpg"/></a>
            </div>
            <div class="col-md-3 col-xs-6">
                <a class="thumbnail"><img src="<%=basePath%>/static/image/goods/挎包图片.jpg"/></a>
            </div>
            <div class="col-md-3 col-xs-6">
                <a class="thumbnail"><img src="<%=basePath%>/static/image/goods/钥匙.jpg"/></a>
            </div>
            <div class="col-md-3 col-xs-6">
                <a class="thumbnail"><img src="<%=basePath%>/static/image/goods/钱包.jpg"/></a>
            </div>
        </div>
    </div>
</div>
<!--尾部-->
<footer  style="margin-top: 2rem"></footer>
<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.js"></script>
<script src="<%=basePath%>/static/js/main.js" ></script>

</body>
</html>