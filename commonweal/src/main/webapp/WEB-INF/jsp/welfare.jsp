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
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/welfare.css"/>
    <script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
    <script src="<%=basePath%>/static/js/bootstrap.js"></script>

    <title>全民公益</title>
    <style>
    	 
    </style>
</head>
    
<body>

<div id="welfarepage">
<!--头部-->
<div class="qmgy_section carousel">

    <img src="<%=basePath%>/static/image/welfare/welfare-01.jpg" >
        <span class="carousel-caption qmgy_span">全民公益，是人人参与的公益，不管是个人还是集体， 人们通过各种公益活动、
            公益基金、公益网站等途径 ，通过直接参与、捐赠、公益广告、公益歌曲等方式 参与到公
            益中来。在中国古代，倡导日行一善，就 是每天做一些我们力所能及的事情，帮助更多的人，让社会更加美好和谐。</span>

</div>
<div>
<!--推送公告-->
    <!--中间体部-->
    <div class="container">
        <ul class="row nav  input-group-addon text-center qmgy_text">

            <li class="col-md-4 col-xs-12"><a href="#gyyy" data-toggle="tab">公益的意义</a></li>
            <li class="col-md-4 col-xs-12"><a href="#hzgs" data-toggle="tab">合作公司</a></li>
            <li class="col-md-4 col-xs-12"><a  href="#lxwm" data-toggle="tab"> 联系我们</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade in" id="gyyy">
                <div class="row text-center">

                    <div class="col-md-6 col-xs-12" >
                        <img src="<%=basePath%>/static/image/welfare/welfare-16.jpg" style="width: 70%;padding-top: 7%;">
                    </div>
                    <div class="col-md-6 col-xs-12" style="padding-top: 25px;">
                        <h4 class="media-heading" style="border-bottom: 2px #b0b0b0 solid">公益的意义</h4>
                        公益是 公共利益事业的 简称。这是为人民服务的一种通俗 讲法。指有关 社会公众的 福祉和 利益。
                        “公益”为后起词， 五四运动后方才出现，其意是“公共利益”。
                        社会公益组织，一般是指那些非政府的、不把利润最大化当作首要 目标，且以社会公益事业为主要追求目标的 社会组织。
                        早先的公益组织主要从事 人道主义救援和贫民救济活动，很多 公益组织起源于 慈善机构。

                        公益是 公共利益事业的 简称。这是为人民服务的一种通俗 讲法。指有关 社会公众的 福祉和 利益。
                        “公益”为后起词， 五四运动后方才出现，其意是“公共利益”。
                        社会公益组织，一般是指那些非政府的、不把利润最大化当作首要 目标，且以社会公益事业为主要追求目标的 社会组织。
                        早先的公益组织主要从事 人道主义救援和贫民救济活动，很多 公益组织起源于 慈善机构。
                        公益是 公共利益事业的 简称。这是为人民服务的一种通俗 讲法。指有关 社会公众的 福祉和 利益。
                        “公益”为后起词， 五四运动后方才出现，其意是“公共利益”。
                        社会公益组织，一般是指那些非政府的、不把利润最大化当作首要 目标，且以社会公益事业为主要追求目标的 社会组织。
                        早先的公益组织主要从事 人道主义救援和贫民救济活动，很多 公益组织起源于 慈善机构。
                    </div>
</div>
                </div>
            <div class="tab-pane fade in" id="hzgs">
                <div class="row">

                </div>
               <img src="<%=basePath%>/static/image/welfare/welfare-18.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
                <img src="<%=basePath%>/static/image/welfare/welfare-19.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
                <img src="<%=basePath%>/static/image/welfare/welfare-20.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
                <img src="<%=basePath%>/static/image/welfare/welfare-21.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
                <img src="<%=basePath%>/static/image/welfare/welfare-22.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
                <img src="<%=basePath%>/static/image/welfare/welfare-23.png"  class="img-circle qmgy-imggx col-md-2 col-xs-6">
            </div>
            <div class="tab-pane fade in" id="lxwm">
                <div class="row text-center">

                    <div class="col-md-6 col-xs-12" >
                         <img src="<%=basePath%>/static/image/welfare/welfare-14.jpg" class="img-responsive">
                            </div>
                    <div class="col-md-6 col-xs-12" style="padding-top: 25px;">
                 <h4 class="media-heading" style="border-bottom: 2px #b0b0b0 solid">云公益</h4>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;云公益是途远科技有限公司开发的一款公益性失物招领网络服务平台。我们的目标就是打造一个实用、便捷、高效、有足够知名度和影响力、全国性的媒体服务平台！让遗失物品的主人能有失而复得的惊喜，更为想要帮助他们的好心人提供一个信息平台，为社会多建立一个温暖的爱心空间 。</p>
                        <p><br />
                        </p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;伴随社会科技的飞速发展，人们生活在快节奏的环境里，更离不开诸多的卡、证之类的物品，不慎遗失以后，不但补办麻烦，更会让你寸步难行。</p>
                        <p><br />
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当看到人们生活必需的各种卡、证之类重要物品遗失以后，需四处奔波寻找的难题，而遗失物品招领处又被大量遗失物品不能及时找到失主在积压所困惑；我们创造条件举办遗失物品认领展示会和开展各种宣传活动，尽最大程度的让遗失物品归还原主,所做的一切,只为看到丢失物品后失而复得灿烂的笑脸,是我们最大的成就!</p>
                        <p><br />
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.shiwurenling.com/">云公益网</a>以免费发布信息、为百姓提供方便、快捷的服务宗旨。站内设有地区分站和寻物启事,寻人启事,招领启事三大窗口（结合各个行业:出租车运管处、飞机场、火车站、汽车站、地铁站、校园内等），在子栏目内还设有各个分类信息（钱包、证件卡类、衣物、手机和首饰、车牌、电脑包等），查询、注册方便快捷简单。</p>
                        <p><br />
                            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为了让爱心传递项目能够持久、有序的发展，站内设立有24小时在线客服和法律咨询,同时开展宣传广告位和通过与各个单位合作的招领窗口，呼吁社会把中华传统美德发扬光大,伸出您好的双手,奉献您的爱心,只要人人都献出一点爱,世界将变得更加美好!同时我们网站与相关的主管单位协调，在适当的机会举办“无人认领物品公开拍卖会”, 拍卖所得将捐赠与贫因山区失学儿童，同时也减轻招领窗口单位的大量遗失物品积压难题.</p>
                        <p>&nbsp;</p>
                    </div>
                        </div>
                    </div>

        </div>
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <div class="media qmgy_media text-center">
                    <div class="media-right qmgy-img" style="float: right;">
                        <div id="myCarousel" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner ">
                                <div class="item active">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-03.jpg">
                                   <span class="carousel-caption qmgy_carousel-caption">2017年度上海市公益广告宣传指南</span>
                                        </a>

                                </div>
                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-09.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">上海市文明城区名单和2014-2015年度上 </span>
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-05.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">2015年度上海市社会主义精神文明好人好 </span>
                                    </a>
                                </div>

                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-06.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
                                    </a>
                                </div>
                            </div>
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                                <li data-target="#myCarousel" data-slide-to="3"></li>

                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-xs-12 txt">
                <div class="media-body nav qmgy_media_body" style="padding-left: 5rem; ">
                    <li ><a href="#" >MINISO名创优品携手“益童书屋”公益项</a></li>
                    <li><a href="#">2017中国公益新媒体蓝V沙龙在京举行</a></li>
                    <li><a href="#">爱佑未来慈善基金会携手众星照亮困境儿</a></li>
                    <li><a href="#">社会创新国际论坛在京召开</a></li>
                    <li><a href="#">BHG Mall积极践行公益事业 树立企业社</a></li>
                    <li><a href="#">态度在行动：不可不知的性教育</a></li>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-6 col-xs-12  ">
                <div class="media-body text-right nav qmgy_media_body" style="padding-right: 8rem;">
                    <li><a href="#">集善扶贫健康行：帮扶残疾人脱贫致富，一个都不能少</a></li>
                    <li><a href="#">四川“悬崖村”现全国首个京东思源无人机流动诊所</a></li>
                    <li><a href="#">第十二届“爱心奖”颁奖：钢子独创三个“第一”</a></li>
                    <li><a href="#">新研究揭示消费者普遍支持象牙禁贸(2017-12-14 10:5</a></li>
                    <li><a href="#">上海普陀：中学生法治辩论观摩赛暨第二 </a></li>
                    <li><a href="#">倡导公益活动与推广精神文明建设</a></li>
                </div>
            </div>
            <div class="col-md-6 col-xs-12">
                <div class="media qmgy_media text-center">
                    <div class="media-right qmgy-img" style="float: right;">
                        <div id="myCarousel1" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-10.png">
                                    <span class="carousel-caption qmgy_carousel-caption">关于举办第六届“上海好心人节”通知</span>
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-12.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">河北唐山：卑家店镇开展党的十九大精神 </span>
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-15.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
                                    </a>
                                </div>

                                <div class="item">
                                    <a href="#">
                                    <img src="<%=basePath%>/static/image/welfare/welfare-17.jpg">
                                    <span class="carousel-caption qmgy_carousel-caption">帮助更多的人，让社会更加美好和谐。</span>
                                        </a>
                                </div>
                            </div>
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel1" data-slide-to="1"></li>
                                <li data-target="#myCarousel1" data-slide-to="2"></li>
                                <li data-target="#myCarousel1" data-slide-to="3"></li>

                            </ol>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
    <!--底部-->

</div>
</div>
</body>
</html>