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
    <title>云公益信息</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/static/css/footerDatil.css">
    <script src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
    <script src="<%=basePath%>/static/js/bootstrap.js"></script>
</head>
<style>

</style>
<body>
	<div id="footerdatailpage">
		
	
<header class="nav" style="width: 100%;height: 5rem;background-color: black">

</header>
 <div class="container" >
     <div class="row">
         <!--选项卡-->
         <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 zou">
             <!--选项卡-->
             <ul class="nav nav-pills" id="firstul">
                 <li class="active col-xs-12">

                     <a href="#n1" data-toggle="pill">关于我们</a>
                 </li>
                 <li class="col-xs-12">

                     <a href="#n2" data-toggle="pill">安全须知</a>
                 </li>
                 <li class="col-xs-12">

                     <a href="#n3" data-toggle="pill">监督举报</a>
                 </li>
                 <li class="col-xs-12">

                     <a href="#n4" data-toggle="pill">合作平台</a>
                 </li>
                 <li class="col-xs-12">

                     <a href="#n5" data-toggle="pill">意见反馈</a>
                 </li>
                 <li class="col-xs-12">

                     <a href="#n6" data-toggle="pill">版权声明</a>
                 </li>
             </ul>
         </div>
         <!--选项卡面板-->
         <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12 tab-content">
             <!--关于我们-->
             <div class="tab-pane fade in active" id="n1">
                 <hr style="width: 80%"/>

                 <p style="width: 80%;padding-left: 10%">云公益-失物招领平台， 自创办以来，我们一直坚持致力于提供方便、快捷的寻物启事发布、失物招领服务，
                 打造国内最大最全的失物招领网站。一个公益、免费快速的寻物启事与失物招领发布平台！或许拾到物品的好心人，正在此寻找失主。
                 或许失主正在此等待好心人的出现。
                 本站不欢迎利用本站发布的信息来诱骗失主，请给自己留一点自尊，也请给这个社会多一份爱心。
                 </p>
                </div>
             <!--安全须知选项-->
             <div class="tab-pane fade" id="n2" style="padding-left: 5%">
                 <h2 class="text-center">云公益不良信息举报</h2>
                 <p class="text-left">&nbsp;&nbsp;云公益协同
                     <a href="http://www.12377.cn/" target="_blank" id="firsta">互联网违法和不良信息举报中心</a>
                     ，提供不良信息举报入口，接受公众举报，严厉打击互联网不良及虚假信息，积极主动地维护广大网民的合法权益，保障社会的和谐安宁，维护公众利益，共建和谐网络环境。
                 </p>
                 <h3 class="text-left">请您在正式提交举报之前确认以下内容：</h3>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;1. 该举报将提交到中国互联网协会违法与不良信息举报中心。</p>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;2. 您应当保证所举报内容与事实一致。若您故意捏造和歪曲事实，所造成的一切后果，将由您自行承担。</p>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;3. 您应当允许工作委员会根据工作需要在保护您的个人权益的前提下，使用您的任何叙述。</p>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;4. 请您尽可能填写详实内容，以利于您举报问题的解决。</p>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;5. 工作委员会将及时处理您举报的有效内容。</p>
                 <p>&nbsp;&nbsp;&nbsp;&nbsp;6. 每个用户每小时只能举报三次。</p>
                 <h4 class="text-left">填写说明请参见下图</h4>
                 <img src="<%=basePath%>/static/image/untitled.png" style="padding-left: 15%" class="img-responsive"/>
                 <p class="text-center">确认举报，则请点击此处前往互联网违法和不良信息举报中心填写举报信息<a href="http://www.12377.cn/" target="_blank" id="seconda">点击举报</a></p>
             </div>
             <!--监督举报-->
             <div class="tab-pane fade" id="n3">
                  <h2 class="text-center">监督举报</h2>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正直是云公益对员工最基本的要求，我们决不姑息任何违法、违规或不正当的行为。如您知悉任何云公益员工
                     在活动中存在有违法、违规或不正当的行为，可通过以下渠道向我们反映：</p>
                  <P class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;举报专线和举报邮箱是云公益为调查云公益员工在活动中存在的违法、违规或不正当行为而设立，如您反映与上述无关的内容，将导致您的问题无法得到处理。</P>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;举报专线: +86-152-26808-5253 (留言电话)</p>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;举报邮箱: jubao@yungonngyi.com</p>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国河南省郑州市金水区文化路80号
                  <h3 class="text-center">云公益 内审部</h3>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您可以自由选择举报途径以及决定是否实名举报等权利，我们建议您提供完整信息，在云公益，您举报的信息和您的相关信息属于绝密级资料，
                     我们建立了相应的措施来确保此类信息的保密。</p>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们将根据您提供的信息，在法律及公司制度规定许可的范围内，进行调查及取证。如果您留下有效联系方式，
                     我们将于收到举报信息即日起10个工作日内，与您联系反馈。</p>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们不希望任何人杜撰、捏造事实，或恶意攻击、诽谤腾讯员工，如发现上述行为腾讯集团将保留追究其责任的权利；
                     我们严厉禁止以任何形式的报复举报人、证人及调查人员，如存在，腾讯集团将严厉查处。</p>
                  <hr/>
                  <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="firstspan">温馨提示：</span>如果您想对云公益相关业务进行咨询及投诉，或者是反映互联网违法和不良信息，建议您通过云公益公司客服渠道进行反映，
                     您的问题或咨询将得到更快的帮助。</p>
             </div>
             <!--合作平台-->
             <div class="tab-pane fade container" id="n4" >
                <hr>
                 <div class="col-xs-12 col-md-6 phone"  >
                  合作请联系：17638108985
                 </div>

             </div>
             <!--意见反馈-->
             <div class="tab-pane fade" id="n5" style="padding-left: 20%">
                 <p class="text-left">您的参与将帮助我们改进产品及服务。</p>
                 <P class="text-left">请详细描述您的建议、意见、问题等：</P>
                 <form action="#" id="firstform" class="col-xs-12 col-md-6">
                     <textarea name="message" style="width: 100%" rows="10" cols="100"></textarea>
                     <p class="form-group">
                         <span>电子邮箱：</span>
                         <input class="form-group" type="text" name="email" value="必填"/><br>

                         <button type="submit" class="btn btn-primary">提交</button>
                     </p>

                 </form>
             </div>
             <!--版权声明-->
             <div class="tab-pane fade " id="n6">
                 <h2 class="text-center">免责声明</h2>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;任何使用云公益信息的用户均应仔细阅读本声明，用户可选择不使用云公益，用户使用云公益的行为将被视为对本声明全部内容的认可（除特别申明外，云公益)-失物招领平台以下均简称为云公益）。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. 除云公益注明之服务条款外，其他一切因使用云公益信息而引致之任何意外、疏忽、合约毁坏、诽谤、版权或知识产权侵犯及其所造成的损失（包括因下载而感染电脑病毒），云公益概不负责，亦不承担任何法律责任。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 任何通过过云公益而链接及得到之信息及服务均系用户自行发布，云公益对其合法性概不负责，亦不承担任何法律责任。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 云公益所有内容并不反映任何云公益之意见。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. 用户对使用云公益信息自行承担风险，云公益不做任何形式的保证，对信息的安全性、正确性、及时性、合法性均不做担保。因网络状况、通讯线路等任何技术原因而导致用户不能正常使用云公益，云公益不承担任何法律责任。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. 云公益尊重并保护所有使用云公益用户的个人隐私权，用户的姓名、电话、电子邮件地址等个人资料，非经用户亲自许可或根据相关法律的强制性规定，云公益不会主动地泄露给第三方。用户在使用云公益时输入的关键字将不被认为是用户的个人隐私资料。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. 任何单位或个人认为通过云公益的内容可能涉嫌侵犯其合法权益，应该及时向云公益或服务网站书面反馈，并提供身份证明、权属证明及详细侵权情况证明，云公益在收到上述法律文件后，将会尽快移除被控侵权内容。</p>　
                 <h2 class="text-center">版权声明</h2>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;云公益包含之所有内容归属丢哪了知识产权，受中国及国际版权法的保护。对本网站上所有内容之复制（意指收集、组合和重新组合），本网站享有排他权并受中国及国际版权法的保护。本网站使用的所有的所有权归属于云公益并受中国及国际版权法的保护。未经云公益许可，任何企业或个人不得擅自（包括但不限于：以非法的方式复制、传播、展示、镜像、上载、下载）使用。若使用者有侵权行为，云公益将依法追究其法律责任。</p>
                 <p class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;云公益及其任何组成部分不得被再造、复制、抄袭、交易，或为任何未经丢哪了允许的商业目的所使用。如果云公益确定用户行为违法或有损其网站的利益，则云公益将保留，包括但不限于拒绝提供服务的权利。</p>
             </div>

         </div>
     </div>

 </div>
</div>
</body>
</html>