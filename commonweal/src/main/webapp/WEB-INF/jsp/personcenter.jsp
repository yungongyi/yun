<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>个人中心</title>
    <link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet" />
    <link href="<%=basePath%>/static/css/personCenter.css" rel="stylesheet"  />
</head>
<body style='background-color: silver' >
 <div id="personcenterpage">
 	

<header ></header>
<div  class="container" style="background-color: white" >
    <div id="per_head" class="row">
       <div class="col-xs-12 col-md-12 ">
           <div class="media">
               <div class="media-left">
                   <img class="img-circle" src="<%=basePath%>/static/image/personcenter/personCenter02.jpg" />
               </div>
               <div class="media-body" >
                   <p><span class="h2">cjw</span>的个人中心</p>
                   <span class="h3">状态：正常</span>
                   <a href="#personPwd" data-toggle="collapse" class="h4 ">
                       <span class="glyphicon glyphicon-edit"></span>修改密码
                   </a>
               </div>
               <!--修改密码-->
               <div class="collapse"  id="personPwd" >
                      <div class="col-xs-8 col-md-4 ">
                          <input class="form-control" type="text" placeholder="请输入验证码" />
                      </div>
                       <div class="col-xs-4 col-md-2 ">
                           <button class="btn btn-info" type="button">发送验证码</button>
                       </div>
                       <div class="col-xs-8 col-md-4 ">
                           <input class="form-control" type="text" placeholder="请输入新密码" />
                       </div>
                       <div class="col-xs-4 col-md-2 ">
                           <button class="btn btn-success" type="button">提交</button>
                       </div>
               </div>
           </div>
       </div>
   </div>
    <div id="per_up" class="row" >
        <div class="col-md-3 col-sm-3 col-xs-12">
            <ul class="nav navbar-tabs">
                <li class="list-group-item">
                    <a href="#per_1" data-toggle="tab"><span class="glyphicon glyphicon-user"></span>个人信息</a>
                </li>
                <li class="list-group-item">
                    <a href="#per_2" data-toggle="tab">
                         <span class="glyphicon glyphicon-send"></span>发布启事
                    </a></li>
                <li class="list-group-item">
                    <a href="#per_3" data-toggle="tab"><span class="glyphicon glyphicon-bell"></span>消息通知</a></li>
                <li class="list-group-item">
                    <a href="#per_4" data-toggle="tab"><span class="glyphicon glyphicon-heart"></span>历史记录</a></li>
            </ul>
            <div class="sendMassage" >
                <p class="h3">发送短消息</p>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input type="text" class="form-control" placeholder="要发送的手机号">
                </div><br>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="不超过20个字" />
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">发送</button>
                    </span>
                </div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 col-xs-12 tab-content">
            <!--个人信息-->
            <div class="tab-pane fade in active" id="per_1">
                <h3 class="text-info text-right">个人信息</h3>
                <ul class="list-group">
                   <li class="list-group-item">
                       头像: <img src="<%=basePath%>/static/image/personcenter/personCenter02.jpg" class="img-circle" style="width: 3em;"/>
                       <a href="#personImg" data-toggle="collapse" class="glyphicon glyphicon-edit badge"><span>修改</span></a>
                       <div id="personImg" class="collapse">
                           <div class="input-group">
                               <input type="file" class="form-control">
                               <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">提交</button>
                               </span>
                           </div>
                       </div>

                   </li>
                    <li class="list-group-item">
                        昵称:
                        <span>大白</span>
                        <a  href="#personName" data-toggle="collapse" class="glyphicon glyphicon-edit badge"><span>修改</span></a>
                        <div id="personName" class="collapse">
                            <div class="input-group">
                                <input type="text" class="form-control">
                               <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">提交</button>
                               </span>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        性别:
                        <span>女</span>
                        <a  href="#personSex" data-toggle="collapse" class="glyphicon glyphicon-edit badge"><span>修改</span></a>
                        <div id="personSex" class="collapse">
                            <div class="input-group">
                               <select class="form-control">
                                   <option value="0">男</option>
                                   <option value="1">女</option>
                               </select>
                               <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">提交</button>
                               </span>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        手机号:
                        <span>17638108985</span>
                        <a  href="#personPhone" data-toggle="collapse" class="glyphicon glyphicon-edit badge"><span>修改</span></a>
                        <div id="personPhone" class="collapse">
                            <div class="input-group">
                                <input type="text" class="form-control" />
                               <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">提交</button>
                               </span>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        地址:
                        <span>郑州金水区</span>
                        <a  href="#personAddress" data-toggle="collapse" class="glyphicon glyphicon-edit badge"><span>修改</span></a>
                        <div id="personAddress" class="collapse">
                            <div class="input-group">
                                <select class="form-control">
                                    <option value="0">金水区</option>
                                    <option value="1">中原区</option>
                                    <option>惠济区</option>
                                    <option>管城区</option>
                                    <option>二七区</option>
                                </select>
                               <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">提交</button>
                               </span>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <!--发布启事-->
            <div class="tab-pane fade " id="per_2">
                <h3 class="text-danger">发布启事</h3>
                <div class="end_align" >
                    <span class="col-md-3 col-xs-4">请上传照片</span>
                    <div class="col-md-9 col-xs-8">
                        <input name="" type="file" class="form-control">
                    </div>
                </div>
                <div class="end_align">
                    <span class="col-md-3 col-xs-4" >请填写标题</span>
                    <div class="col-md-9 col-xs-8">
                        <input name="" type="text" placeholder="标题不要太长哦" class=" form-control">
                    </div>
                </div>
                <div class="end_align">
                    <span class="col-md-3 col-xs-4" >请选择启事类别</span>
                    <div class="col-md-9 col-xs-8">
                        <select name="" class="form-control">
                            <option>人走失了</option>
                            <option>物品丢了</option>
                            <option>捡到物品</option>
                            <option>捡到个人</option>
                        </select>
                    </div>
                </div>
                <div class="end_align">
                    <span class="col-md-3 col-xs-4" >请选择启事范围</span>
                    <div class="col-md-9 col-xs-8">
                        <select name="" class="form-control">
                            <option>金水区</option>
                            <option>中原区</option>
                            <option>惠济区</option>
                            <option>管城区</option>
                            <option>二七区</option>
                        </select>
                    </div>
                </div>
                <div class="end_align">
                    <span class="col-md-3 col-xs-4" >请填写详细描述</span>
                    <div class="col-md-9 col-xs-8">
                      <textarea name="" class="form-control" placeholder="请对启事涉及的人或物进行详细描述"></textarea>
                    </div>
                </div>
                <div class="end_align">
                    <span class="col-md-3 col-xs-4" >请填写启事有效时长</span>
                    <div class="col-md-9 col-xs-8">
                        <input name="" class="form-control" type="number" placeholder="单位是天哦" />
                    </div>
                </div>
                <div class="end_align">
                    <input class="col-md-12  form-control btn-success" type="button" value="马上发布"/>
                </div>
            </div>
            <!--消息通知-->
            <div class="tab-pane fade " id="per_3">
                <h3 class="text-right text-success">消息通知</h3>
                <ul class="list-group">
                    <li class="list-unstyled" >
                        <span>系统通知:</span>
                        <span>你最近发布告示重复，小心封号哦！</span>
                        <span>2017-12-17 22:36</span>
                        <a data-toggle="collapse" href="#collapseOne" class="badge">查看</a>
                        <a class="badge">删除</a>
                        <div id="collapseOne" class="collapse">
                           系统通知:经检测你最近频繁发布广告告示，如在发现进行封号出发
                        </div>
                    </li>
                    <li class="list-unstyled" >
                        <span>来自zmf:</span>
                        <span>哥哥，我喜欢你！</span>
                        <span>2017-12-17 22:35</span>
                        <a data-toggle="collapse" href="#collapseTwo" class="badge">查看</a>
                        <a class="badge">删除</a>
                        <div id="collapseTwo" class="collapse">
                            来自账号17638108985:我好想你啊，哥哥
                        </div>
                    </li>
                    <li class="list-unstyled" >
                        <span>来自爱神的箭阿基:</span>
                        <span>哥哥，人家喜欢你！</span>
                        <span>2017-12-17 22:34</span>
                        <a data-toggle="collapse" href="#collapseThr" class="badge">查看</a>
                        <a class="badge">删除</a>
                        <div id="collapseThr" class="collapse">
                            来自账号17638108985:我好想你啊，哥哥
                        </div>
                    </li>
                </ul>
                <ul class="pager">
                    <li><a href="#">上一页</a></li>
                    <li><a href="#">下一页</a></li>
                </ul>
            </div>
            <!--历史记录-->
            <div class="tab-pane fade " id="per_4">
                <h3 class="text-left text-danger">历史记录</h3>
                <ul>
                    <li class="list-unstyled">
                        <span>丢了黑发女孩</span>
                        <span>人走失了</span>
                        <span>金水区</span>
                        <span>2017-12-16 12:30</span>
                        <span>已找到</span>
                        <a class="badge "><span>查看</span></a>
                        <a class="badge"><span>删除</span></a>
                    </li>
                    <li class="list-unstyled">
                        <span>捡个老外</span>
                        <span>捡了个人</span>
                        <span>中原区</span>
                        <span>2017-12-16 12:29</span>
                        <span>已认领</span>
                        <a class="badge "><span>查看</span></a>
                        <a class="badge"><span>删除</span></a>
                    </li>
                    <li class="list-unstyled">
                        <span>黑色钱包</span>
                        <span>东西丢了</span>
                        <span>惠济区</span>
                        <span>2017-12-16 12:30</span>
                        <span>已失效</span>
                        <a class="badge "><span>查看</span></a>
                        <a class="badge"><span>删除</span></a>
                    </li>
                </ul>
                <ul class="pager">
                    <li><a href="#">上一页</a></li>
                    <li><a href="#">下一页</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
 </div>
<footer style="background-color: silver"></footer>
<script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.js"></script>
<script>
    $.get("footer.html","HTML",function(data){
        $('footer').html(data);
    });
    /*加载头尾*/
    $.get("header.html","HTML",function(data){
        $('header').html(data);

    });

</script>
</body>
