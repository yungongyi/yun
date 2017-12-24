<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta charset="UTF-8">
    <title>云公益底部</title>
    <link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=basePath%>/static/css/footer.css" rel="stylesheet" />
</head>
<body>
<nav id="footer"  style="background-color: #999999" class="nav navbar-default">
    <hr>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <img src="<%=basePath%>/static/image/public/hezuo.png" class="nav navbar-brand" style="padding: 1px;">
                <p><a href="#">合作平台</a></p>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <a href="#"><img src="<%=basePath%>/static/image/public/anquanxuzhi.png" class="nav navbar-brand" style="padding: 6px;"></a>
                <p><a href="#">安全须知</a></p>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <a href="#"><img src="<%=basePath%>/static/image/public/jubao.png" class="nav navbar-brand" style="padding: 6px;"></a>
                <p><a href="#">举报中心</a></p>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <a href="#"><img src="<%=basePath%>/static/image/public/yijian.png" class="nav navbar-brand" style="padding: 0px;"></a>
                <p><a href="#">意见反馈</a></p>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <a href="#"><img src="<%=basePath%>/static/image/public/shengming.png" class="nav navbar-brand" style="padding: 6px;"></a>
                <p><a href="#">责任声明</a></p>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                <a href="#"><img src="<%=basePath%>/static/image/public/guanyuwomen.png" class="nav navbar-brand" style="padding: 3px;"></a>
                <p><a href="#">关于我们</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
                <p>云公益出版许可证 京ICP背13051882号 | 网络文化经营许可证 京网问 [2015] 0193-043号</p>
                <p>电子与信息服务业务经营许可证 京ICP证140151号 | 京公网安备11030102000471号 2017 途远科技有限公司版权所有</p>
            </div>
        </div>
    </div>
</nav>
</body>
</html>