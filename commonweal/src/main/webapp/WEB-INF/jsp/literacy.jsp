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
    <link href="<%=basePath%>/static/css/bootstrap.css" rel="stylesheet">
    <script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
    <script src="<%=basePath%>/static/js/bootstrap.js"></script>
    <link href="<%=basePath%>/static/css/literacy.css" rel="stylesheet">
    <script src="<%=basePath%>/static/js/literacy.js"></script>
    <title>云公益防丢失知识普及</title>
</head>
<body>
	<div id="literacypage">
		
	
<header class="container">
    <a href="#"><img src="<%=basePath%>/static/image/header.jpg" class="img-responsive" alt=""></a>
</header>
<!--当前位置-->
<div class="container" id="firstdiv">
    <p>
        <span class="glyphicon glyphicon-map-marker"></span>
                您的当前位置 ><a href="main.html">
        <span class="glyphicon glyphicon-home"></span>
        首页</a> >
        <span class="glyphicon glyphicon-question-sign"></span>
        知识普及
    </p>
</div>
<div class="container" id="seconddiv">
    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12" id="thirddiv">
            <h3 class="text-center">如果银行卡丢失怎么办？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 要马上挂失,带好自己的身份证件,最好记得你的卡号</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 银行卡掉了不是还有存折吗?(这里不包括可透支的卡),用存折和你的证件可以补办一张。</p>
            <h3 class="text-center">如果信用卡丢失怎么办？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 口头挂失：如持卡人来不及到银行卡部办理，可打电话办理口头挂失，但必须在72小时内到建设银行营业网点办理正式挂失，否则24小时后挂失自动解挂。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 网点挂失：持卡人如银行卡遗失，可以到附近建设银行营业网点提出挂失申请。任何一个建行网点均可进行挂失申请，不必去发卡网点进行挂失。网点申请挂失属于正式挂失，办理正式挂失的手续是，持卡人要填写挂失申请书，交验本人身份证件，交纳挂失费和挂失补卡费。挂失前及挂失后24小时内该卡发生的全部经济责任由持卡人承担。 持卡人办理挂失后又找到银行卡，可办理撤消挂失。填写撤消挂失申请书，撤消挂失后不退原挂失手续费和挂失补卡费。</p>
            <h3 class="text-center">其他注意事项：</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 到期换卡：龙卡（双币种）银行卡卡片使用有效期为3年，过期即失效。建设银行将在您的卡片到期前1个月主动为您寄发新卡，方便您使用。如您在卡片到期后不愿继续用卡，请在卡片到期前1个月致电建设银行24小时服务热线。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 提前换卡：若您的卡片在3个月内即将到期，并且您因出国等特殊原因需提前换卡，请致电24小时服务热线提出申请并自行销毁原有卡片。建行将为您办理提前换卡，并为您寄发新卡。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 损毁换卡：当您的卡片因毁损、断裂、磁条消磁或签名有误等原因无法继续使用时，可申请补发新卡；申请补发请致电建行24小时服务热线，补发新卡需支付每卡20元的补发手续费；请您务必自行销毁旧卡，以免带来不必要的损失。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. 境外紧急补卡指南：国外旅途中，如遇到卡片丢失或被窃，请您拨打我行客服热线进行卡片挂失。我们将即刻为您办理挂失手续，挂失即时生效。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. 若您在国外发生卡片遗失、被窃，且在国外期间仍需继续使用龙（双币种）银行卡时，请致电建行境外24小时服务热线进行挂失并申办紧急替代卡。建行将立即联络国外发卡机构为您办理紧急替代卡，同时为您补发新卡。申请紧急补发卡时，请您确认能够在同一地点停留48小时以上，以便国外发卡机构及时联络到您并寄送卡片。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. 紧急补发卡仅限于持卡人本人领取，签收卡片时需要出示有效的身份证件。紧急补发卡的有效期一般为三个月，到期后自动失效，为保证您持卡安全，失效卡请您自行销毁。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7. 境外紧急补发卡按照国际组织规定收取一定的手续费，成功补卡VISA卡收取每卡75美元（现行标准）；成功补卡万事达卡收取每卡148美元（现行标准）。</p>
         </div>

        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12" id="fourdiv">
            <h3 class="text-center">丢失身份证后你将面临哪些风险？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在很多人的印象中，身份证丢了，挂失一下就万事大吉，因此倒卖丢失的身份证似乎并没有什么意义。其实，挂失后的身份证依然可以使用。其实这还是个技术难题，我国现行二代身份证即使挂失，其中的电子芯片仍然可以识别，信息依然可用。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证不像银行卡有密码功能，不能通过修改密码的方式停止卡片使用，不能注销只能补办。无论是公民不慎遗失身份证，还是身份证被盗等原因，一旦身份证落入不法分子之手，不法分子就可以利用他人的身份证从事各种违法行为。例如，办理电话卡并恶意拖欠话费、办理银行信用卡并恶意透支，进行虚假设立、变更法定代表人的工商登记，开通多家银行账户进行洗钱等。</p>
            <h3 class="text-center">身份证丢失需不需要登报声明？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证丢了，小伙伴们一定很着急，一直有一种说法是丢失后需要登报发遗失声明，这样才能避免日后麻烦缠身，那么登报声明真的有必要吗？公安部发现了大家的疑虑，并发布了《关于对居民身份证丢失补领有关问题综合答复意见》，《意见》中说道，公民办理丢失补领证件的行为也就告知了公安机关证件丢失的事实，不需要再办理“挂失”和登报声明，也没有相关法律规定公民丢失居民身份证后需办理“挂失”和登报声明。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公民在使用居民身份证证明身份时，各相关证件使用部门负有核对人、证一致性的义务，确认无误后方可为持证人办理相关业务。如果居民身份证丢失被他人冒用，冒用者及相关部门应承担相应的法律责任，丢失证件者无须对自己未实施的行为承担责任。</p>
            <h3 class="text-center">身份证复印件如何备注也有学问。</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为防止不法分子冒用，给身份证复印件做上标注是行之有效的办法。使用复印件办理事项时，最好使用蓝色和黑色的笔进行标注。标注时要注明“本复印件仅用于办理XXXX使用”、“仅可使用一次”，“再复印无效”等语句。标注最好分三行，每行最后画一条横线，防止别人加上其他的内容。书写的标注最好和身份证的实际内容有接触，但不要压住关键信息，做到这些就能很大程度上防止身份证复印件被他人利用。</p>
            <h3 class="text-center">身份证丢失该如何申领新证?</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请人只需携带本人居民户口簿便可以到常住户口所在地的公安机关办理补领。工作人员审核无误后，经过采集人像信息、指纹信息，填写《居民身份证申领登记表》并交纳40元每本的证件工本费，就可以等待领取自己的新身份证了。一般来说，提交《居民身份证申领登记表》后60日内便可以拿到居民身份证。另外，不少地区已经支持身份证异地申领，如有需要，可以前往居住地公安机关居民身份证异地受理点办理。</p>
        </div>

        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12" id="fivediv">
            <h3 class="text-center">手机在身上的放置位置其实是最关键得。</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;外衣口袋、背包外袋、屁兜等等这种口袋是绝对不要去放手机的。很多女孩背包手机是放在包里的夹层中，这样做其实是最为安全的，只要包不丢，手机基本也很难被偷走，而如果非要放在身上的话，也尽量放在左右两侧的兜中，一般裤子左右两侧的兜还是比较紧，并且不会太浅，是不太容易被偷走的。</p>
            <h3 class="text-center">智能应用工具防丢失。</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iWatch是一直以来被大家所关注的产品，也是苹果说要秘密研发的一款穿戴式智能设备，不过iWatch现在还是没有什么靠谱的消息，所以我们也没法猜测什么，不过就目前为止，也已经有很多智能手表和大家见面了，三星GALAXY Gear就是目前最为火热的一款智能手表了。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其实这款手表并没有什么特别好用的防盗功能和应用，不过能够给予我们提示的是：手表与手机的连接是通过蓝牙来进行的，而当手表和手机距离过远的时候，手表将会产生非常容易感受到的震动并且提示手机与手表的连接已经断开。通过震动，那就很容易就知道手机已经离开自己身边的范围了，如果是遗忘了可以一下就发现，如果是被偷了，也可以迅速察觉一下周围可疑的人和正在远离自己的人，也有可能会当场把手机找回来。有些人说手表并不方便，而且智能手表现在也没几个人用，带着感觉比较另类，那OPPO N1推出的小挂件一定会满足他们的需要，这款叫做O-Click的小挂件其实就是一个钥匙链，而它不仅可以远程遥控拍照，如果手机遗忘了或者找不到了，按下O-Click，OPPO N1就可以自动响铃，是不是非常方便？拥有了这些可穿戴设备，再也不用担心自己的手机找不到或者是遗忘了，可以非常有效的找回来自己的手机。</p>
            <h3 class="text-center"> 无法避免的时候，就应该让损失降到最低。</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机丢了大家最烦躁的无非不过就是联系人都没了，手机内存储的资料没有了，那么对于这些资料的保护就尤为重要，现在很多厂商例如黑莓、酷派等等都在安全性上有着不错的设计，并且这些厂商也是以商务功能为主打的，功能更加好用。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在很早的手机中酷派就是加入了这种商务安全保护功能，并且这些功能都是由酷派自己开发的，而无需安装360手机卫士等等这样的第三方工具，防盗、防偷窥、数据保护等等功能都可以将手机的资料保护起来，并且还有着云端备份功能，这些挽救措施在酷管家中都可以找到，不要嫌设置麻烦，还是有必要的。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;而除去在应用层级的保护之外，还有手机直接采用硬件芯片来保护手机的安全，VEB就是这样一款手机。VEB密室拥有两层密码保护，第一层是访客密码，用该密码登录VEB密室时只能看到预先设定好的访客虚拟界面，无法看到私密内容；第二层是属于用户个人的私密空间密码，通过该密码进入VEB密室，可创建机密资料，添加私密联系人，发起私密通话，发送私密短信。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;虽然这些功能平时大家可能不怎么关注，但是真等到手机丢失的时候又会头疼不已，所以如果是秘密比较多的人，在手机中安装安全应用或者直接选购安防级别很高的几款手机在以后的意外中也可以保证自己手机中资料的安全。</p>
        </div>

        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12" id="sixdiv">
            <h3 class="text-center">亲人走失怎么办？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 求助于警方。在无其他良策的情况下应该这样做。警方可以将你家人的情况输入全国失踪人口信息库，一旦经过比对，就有可能立即联系你们。（向户口所在地警方求助）</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 在《人民公安报》上发布配照片的寻人启事。全国的人口管理由公安部门承担，《人民公安报》全国各地公安机关均有订阅，影响面很广，作用很大，不妨试试。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 最后也只能"守株待兔"了。并不是所有的事情都能有一个满意的结果。如果你的家人一直处于流动状态是很难找的。问题的关键正如我开始推荐的依赖于公安机关。5、最后一招。法律规定：失踪两年后，依照法定程序可以宣告死亡。你们家可以到时向法院申请宣告死亡，这样可以到公安机关注销走失家人的户口，这样你家人的身份证就无效了，你的家人走到哪都是“不合法”的，只要流动，无论住宿、上飞机等等，公安机关就很快能找到你的家人。</p>
            <h3 class="text-center">当你外出时手机银行卡信用卡一起丢失怎么办？</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 致电手机运营商挂失手机号；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 致电银行挂失银行卡；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 手机绑定支付宝的，拨打95188挂失；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. 微信用户登录110.qq.com冻结账号；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. 向常住户口所在地派出所申报丢失补领身份证；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. 到手机运营商处补手机卡；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.身份证电子备份：平时把身份证扫描到电脑，并上传手机或邮箱，电子备份能够在所有纸质证件丢失时发挥作用；</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8.随身带张标准照：不是每个派出所都有摄像头，有的派出所会要求出示一寸照片才能办理临时证，所以出行时可随身携带标准照。</p>
            <h3 class="text-center">身份证使用安全防护措施：</h3>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 勿将身份证和手机等物品装在一起。手机工作时发出的高频电磁波所产生的强磁场会把身份证内的磁性芯片磁化，造成身份证消磁，身份信息无法读取。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 在火车站、商场等公共场合，切勿将身份证装在大衣侧兜，极易遭窃。尽量将证件放在贴身内兜，切勿出示给陌生人。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 勿将身份证借给他人使用，或抵押给他人。</p>
            <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. 身份证丢失后，应及时到公安机关办理补领手续。</p>
        </div>

        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12" id="sevendiv">
            <ul class="list-group" id="firstul">
                <li class="list-group-item text-center" id="firstli">
                    <h4>知识普及</h4>
                </li>
                <li class="list-group-item text-left" id="secondli">
                    <a>银行信用卡防丢失知识普及</a></li>
                <li class="list-group-item text-left" id="thirdli">
                    <a>身份证防丢失知识普及</a></li>
                <li class="list-group-item text-left" id="fourli">
                    <a>手机防丢失知识普及</a></li>
                <li class="list-group-item text-left" id="fiveli">
                    <a>基本知识普及</a></li>
            </ul>
        </div>
    </div>
</div>
</div>
</body>

</html>