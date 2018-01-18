$(function(){
	var personId= $("#personId").val(); //用户id
	alert(personId);
	var NoticetableId= 6;//启事模块id
	var cityId  = 4; //城市id
	//当前页码
	var currentPage = 0;
	//总页码
	var countPage = 0;
	//页面容量
	var psize = 4;
	var imgpath = "/commonweal/static/upload/image/"; //图片路径
	var requestPath = "/commonweal";//后台服务项目名称
	var clientPath = "/yungongyi"; //前台页面项目名称
	var updatepasswaring=$("#updatepasswaring");//修改密码的提示
	var personwaring =$("#personwaring");//个人信息提示
	var savenoticewaring = $("#savenoticewaring");//新增启事信息
	var messagewaring=$("#historymessagewaring");//消息提示
	var deletenoticewaring = $("#deletenoticewaring");//删除启事的提示
	var sendmessagewaring=$("#sendmessagewaring");//发送短消息的提示

	//-------------------------------------------------------修改密码-----------------------------------------------------------
	//修改密码
	updatepass();
	//-------------------------------------------------------初始化个人信息------------------------------------------------------------
	//页面加载的时候先初始化个人信息
	initPersonCenter();
	//---------------------------------------------------------修改个人信息------------------------------------------------------------------
	//修改用户头像
	$(".updateheadimg").click(function(){ 
		personwaring.html('');
		var headimg = document.getElementById("headimg").files[0];
		if(headimg==''||headimg==null){
			personwaring.html('请选择您要头像图片哟~');
			personwaring.css('color','red');
		}else{
			var formData = new FormData();
			formData.append("headimg",headimg);
			$.ajax({
				url:requestPath+"/personCenter/updateHeadImg",
				type:"POST",
				dataType:"json",
				contentType: false, //禁止设置请求类型
				processData: false, //禁止jquery对DAta数据的处理,默认会处理
				data:formData,
				success:function(data){ 
					//初始化个人信息
					initPersonCenter();
					personwaring.html(data["error"]);
					if(data["error"]!="上传成功"){
						personwaring.css('color','red');
					}else{
						personwaring.css('color','green');
					} 
				},
				error:function(data){
					personwaring.html(data["error"]);
					personwaring.css('color','red');
				}
			}); 
		}
	});	
	//修改昵称
	$(".updateperonname").click(function (){ 
		personwaring.html('');
		var personname=$("input[name='personname']").val();
		if(personname!=""){
			updatepersonMessage(personname,null,null,null); 
		}else{
			personwaring.html('请输入您的名称');
			personwaring.css('color','red');
		}
	});
	//修改性别
	$(".updatepersonsex").click(function (){ 
		personwaring.html('');
		var personsex=$(".selectpersonsex").val();
		updatepersonMessage(null,personsex,null,null); 
	});
	//修改手机
	$(".updatephone").click(function (){
		personwaring.html('');
		var personphone=$("input[name='peronphone']").val();
		if(personphone!=""){
			updatepersonMessage(null,null,personphone,null); 
		}else{
			personwaring.html('请输入您的手机号');
			personwaring.css('color','red');
		}
	});

	//点击修改的时候加载区域信息
	$("#updateaddressspan").click(function(){
		$(".selectpersonregion").html('');
		$.ajax({
			url:requestPath+"/region/getAllRegion/"+4,
			type:"get",
			dataType:"json",
			success:function(data){
				$.each(data,function(index,object){
					$(".selectpersonregion").append("<option value="+object.regionId+">"+object.regionName+"</option>");
				});
			},error:function(data){
			}
		});
	});
	//修改地址
	$(".updateregion").click(function (){
		personwaring.html('');
		var personregion=$(".selectpersonregion").val();
		updatepersonMessage(null,null,null,personregion);
	});
	//--------------------------------------初始化新增启事页面-------------------------------------------------------------------------
	$(".createnotice").click(function(){
		$("#paging").css('display','none');
		//初始化启事类型
		getnoticetype();
		//初始化区域
		getregion();
	});	
	//新增启事
	$(".saveNotice").click(function(){
		//获取所有的启事标签内容 
		var noticeimg = document.getElementById("noticeimg").files[0];
		var title=$("input[name='noticetitle']").val();
		var type =$("select[name='noticetype']").val();
		var region=$("select[name='noticeregion']").val();
		var detail=$("textarea[name='noticedetail']").val();
		var aging=$("input[name='noticeaging']").val();
		//由于数据库原因，这里暂时写死
		var state=11;
		if(type==1 | type==3){
			state=11;
		}else if(type == 2 | type==4){
			state=12;
		}		
		//如果有一个为空就提示错误信息
		if(noticeimg=='' | title=='' | detail=='' | aging==''){	
			savenoticewaring.text('发布信息不完整，无法发布，请检查过后再发布');
			savenoticewaring.css('color','red');
		}else{//否则就执行新增操作
			var formData = new FormData();
			formData.append("personId",personId);
			formData.append("noticeimg",noticeimg);
			formData.append("title",title);
			formData.append("type",type);
			formData.append("state",state);
			formData.append("region",region);
			formData.append("detail",detail);
			formData.append("aging",aging);
			$.ajax({
				url:requestPath+"/notice/saveNotice",
				contentType: false, //禁止设置请求类型
				processData: false, //禁止jquery对DAta数据的处理,默认会处理
				data:formData,
				type:"post",
				success:function(data){
					if(data>0){
						savenoticewaring.text('发布成功！祝您一切顺利~');
						savenoticewaring.css('color','green');
					}else{
						savenoticewaring.text('发布失败！系统出错');
						savenoticewaring.css('color','red');
					}
				},
				error:function(data){
					savenoticewaring.text('发布失败！系统出错');
					savenoticewaring.css('color','red');
				}			
			});  
			$("input[name='noticetitle']").val("");
			$("input[name='noticeaging']").val("");   
			$("textarea[name='noticedetail']").val("");   
		}
	});

	//--------------------------------------------------------消息记录-------------------------------------------------------------
	//单击消息信息获取历史消息
	$(".historymessage").click(function(){
		$("#paging").css('display','block');
		//获取历史信息列表方法
		gethistorymessage();
	});
	//单击删除消息信息 
	$(document).on('click','.deletemyselfmessage',function(){
		var messageId=$(this).siblings(".messageId").html();
		$.ajax({
			url:requestPath+"/personCenter/deleteMessage",
			data:{"messageId":messageId,"personId":personId},
			type:"get",
			success:function(data){
				if(data){
					if($(".list-unstyled").length==0){
						$(".historymessageul").append("<li class='list-unstyled text-center'><span style='color:green;'>您还没有发送一条消息~</span></li>");	                 						
					}
					//刷新消息列表
					gethistorymessage();
					messagewaring.html('删除成功！');
					messagewaring.css('color','green');
				}else{
					messagewaring.html('系统出错，删除失败！');
					messagewaring.css('color','red');
				}
			},error:function(data){
				messagewaring.html('系统出错，删除失败！');
				messagewaring.css('color','red');
			}
		});
	});

	//-----------------------------------------------------------------启事记录----------------------------------------------------------
	//单击启事记录根据登录者id获取启事记录
	$(".historynotice").click(function(){
		$("#paging").css('display','block');
		gethistroynotice();
	});
	//点击查看跳入启事详细信息页面
	$(document).on('click','.checkmyselfnotice',function(){
		var noticeid= $(this).parent().children(".myselfnoticeid").html();
		window.location.href= clientPath+"/noticeinfo/"+noticeid;
	});
	//点击删除按钮删除启事
	$(document).on('click','.deletemyselfnotice',function(){ 
		var c=confirm("确定要删除该启事信息吗?");
		if(c==true){//如果选择确定则执行删除操作
			//获取该元素的启事id
			var noticeid= $(this).parent().children(".myselfnoticeid").html(); 
			$.ajax({
				url:requestPath+"/personCenter/deleteNotice/"+personId+"/"+noticeid,
				type:"get",
				dataType:"json",
				success:function(data){
					//删除成功后提示信息
					deletenoticewaring.html('');
					deletenoticewaring.html('删除成功！');
					deletenoticewaring.css('color','green'); 
					//删除完成之后初始化历史记录
					gethistroynotice();
				},error:function(data){
					deletenoticewaring.html('系统出错，删除失败！');
					deletenoticewaring.css('color','red');
				}
			});
		} 
	});
	//修改启事状态
	$(document).on('click','.updatenoticestate',function(){
		var button = $(this);
		//获取启事状态
		var stateid=$(this).siblings(".myselfstateid").html();
		//如果状态为未认领 就改为已认领    
		//如果状态为未找到就改为已找到
		var sId=8;
		if(stateid==11){
			sId=9
		}
		//获取启事id
		var noticeid=$(this).siblings(".myselfnoticeid").html(); 
		$.ajax({
			url:requestPath+"/personCenter/updateNoticeBystate",
			data:{"noticeid":noticeid,"stateid":sId},
			type:"get",
			dataType:"json",
			success:function(data){
				alert(data);
				if(data>0){
					deletenoticewaring.html('恭喜您，找回属于自己东西！');
					deletenoticewaring.css('color','green');
					button.hide(500);
				}else{
					deletenoticewaring.html('系统出错！无法确认');
					deletenoticewaring.css('color','red');
				}

			},error:function(data){
				deletenoticewaring.html('系统出错！无法确认');
				deletenoticewaring.css('color','red');
			}
		});
	});
	//-------------------------------------------------------------发送短消息------------------------------------------------
	$(".sendmessage").click(function(){
		sendmessage();
	});
	//-------------------------------------------------------------------用到的所有方法------------------------------------------------------------------------
	//修改密码方法
	function  updatepass(){
		//获取该用户的手机号
		var personphone =$(".personphone"); 
		//系统返回的验证码
		var CPyanzhengma = null;
		//点击获取验证码
		$("#sendyzm").click(function(){
			$.ajax({
				url:requestPath+"/personCenter/getiphone/"+personphone,
				type:"get",
				dataType:"json",
				success:function(data){
					updatepasswaring.html(data);
					CPyanzhengma = data;
				},error:function(data){
					updatepasswaring.html('系统出错！无法获取验证码'); 
					updatepasswaring.css('color','red');
				}
			});
		});
		//点击修改密码
		$("#updatepass").click(function(){
			//获取用户输入的新密码
			var newpassword=$("input[name='Unewpassword']").val();
			//获取用户输入的验证码
			var Uyanzhengma = $("input[name='Uyanzhengma']").val();
			//如果验证码输入正确
			if(Uyanzhengma==CPyanzhengma ){
				if(newpassword!=''){ 
					$.ajax({
						url:requestPath+"/personCenter/updatePassword",
						data:{"newPassword":newpassword,"personId":personId},
						type:"post",
						dataType:"json",
						success:function(data){
							updatepasswaring.html('修改成功！'); 
							updatepasswaring.css('color','green');
							CPyanzhengma=null;
							$("input[name='Uyanzhengma']").val("");
							$("input[name='Unewpassword']").val("");
						},
						error:function(data){
							updatepasswaring.html('系统出错无法修改密码！'); 
							updatepasswaring.css('color','red');
						}
					});
				}else{
					updatepasswaring.html('新密码不能为空！'); 
					updatepasswaring.css('color','red');
				}
			}else if(Uyanzhengma==''){
				updatepasswaring.html('验证码不能为空'); 
				updatepasswaring.css('color','red');
			}else if(Uyanzhengma!=CPyanzhengma){
				updatepasswaring.html('验证码不正确！请重新输入'); 
				updatepasswaring.css('color','red');
			}else{
				updatepasswaring.html(''); 
			}
		});
	}
	//初始化信息
	function initPersonCenter(){
		var headimg = $(".headimg");
		var personname=$(".personname");
		var personstate =$(".personstate");
		var personsex =$(".personsex");
		var personphone =$(".personphone");    
		var personaddress =$(".personaddress");
		$.ajax({
			url:requestPath+"/personCenter/getPersonById/"+personId,
			type:"post",
			dataType:"json",
			success:function(data){
				headimg.attr('src',imgpath+data.resource.resourcePath);
				personname.html(data.name); 
				personstate.html(data.state.stateName);
				if(data.sex==0){
					personsex.text("男");
				}else{
					personsex.text("女");
				}
				personphone.html(data.iphone);
				personaddress.html(data.region.regionName);
			},
			error:function(data){
			}
		});
	}
	//修改个人信息
	function updatepersonMessage(name,sex,phone,addressID){
		$.ajax({
			url:requestPath+"/personCenter/updatePersonInfo",
			data:{"name":name,"sex":sex,"iphone":phone,"addressID":addressID},
			dataType:"json",
			type:"post",
			success:function(data){ 
				if(data){
					personwaring.html('修改成功');
					personwaring.css('color','green');
					//初始化个人信息
					initPersonCenter();
				}else{
					personwaring.html('修改失败');
					personwaring.css('color','red');
				}
			},
			error:function(data){
				personwaring.html('系统出错');
				personwaring.css('color','red');
			}
		})
	}
	//获取所有的区域列表
	function getregion(){ 
		$("select[name='noticeregion']").html('');
		$.ajax({
			url:requestPath+"/personCenter/getRegionByParentId/"+cityId,
			type:"post",
			dataType:"json",
			success:function(data){
				$.each(data,function(index,object){
					$("select[name='noticeregion']").append("<option value='"+object.regionId+"'>"+object.regionName+"</option>");
				});
			},
			error:function(data){			
			}
		});
	}
	//获取所有的启事类型
	function getnoticetype(){
		$("select[name='noticetype']").html('');
		$.ajax({
			url:requestPath+"/personCenter/gettypebytableid/"+NoticetableId,
			type:"post",
			dataType:"json",
			success:function(data){
				$.each(data,function(index,object){
					$("select[name='noticetype']").append("<option value='"+object.typeId+"'>"+object.typeName+"</option>");
				});
			},
			error:function(data){		
			}
		});
	}
	//获取信息记录
	function gethistorymessage(){
		$(".historymessageul").html(''); 
		$.ajax({
			url:requestPath+"/personCenter/getAllMessageById/"+personId,
			type:"post",
			dataType:"json",
			success:function(data){
				var message=data["messages"];
				var sender=data["receivers"];
				if(message.length==0 ||sender.length==0){
					messagewaring.html('你还没有发送一条消息哟~');//删除的提示消失
					messagewaring.css({'color':'green'});
				}
				for (var i = 0; i < message.length; i++) {
					for (var j = 0; j < sender.length; j++) {
						$(".historymessageul").append("<li class='list-unstyled historymessages'><span class='messageId' style='display:none'>"+message[i].messageId+"</span><span> 来自  "+sender[j].name+" : </span> <span>"+message[i].messageContent+"</span>"+
								"<span>"+message[i].sendDate+"</span> <a data-toggle='collapse'"+
								"href='#check"+message[i].messageId+"' class='badge'>查看</a> <a class='badge deletemyselfmessage '>删除</a>"+
								"<div id='check"+message[i].messageId+"' class='collapse'>"+
								"来自账号  "+sender[j].iphone+" : "+message[i].messageContent+"</div></li>");
						break;
					}
				}
				gopage(".historymessages",1,psize);
			},
			error:function(data){
			}
		});		
	}
	//获取历史记录
	function gethistroynotice(){ 
		$(".historynoticeul").html('');
		$.ajax({
			url:requestPath+"/personCenter/getAllNoticeById/"+personId,
			type:"post",
			dataType:"json",
			success:function(data){ 
				if(data.length==0){
					deletenoticewaring.html('');//删除的提示消失
					$(".historynoticeul").append("<li class='list-unstyled text-center'><span style='color:green;'>您还没有在我们平台上发布启事哟~</span></li>");	                 
				}
				$.each(data,function(index,object){
					var stateId= object.state.stateId;
					if(stateId==11|stateId==12){
						$(".historynoticeul").append("<li class='list-unstyled historynotices'><span style='display:none' class='myselfnoticeid'>"+object.noticeId+"</span><span>"+object.noticeTittle+"</span>"+
								" <span>"+object.noticeCreateDate+"</span>"+
								"<span style='display:none' class='myselfstateid'>"+object.state.stateId+"</span>"+
								" <span>"+object.type.typeName+"</span>"+	
								" <a class='badge checkmyselfnotice'><span>查看</span></a> " +
								" <a class='badge deletemyselfnotice'><span>移除</span></a> " +			 
								" <a class='badge updatenoticestate' style='background-color:green;opacity: 0.7; '><span>认领</span></a> "+	
						"</li>");
					}else{
						$(".historynoticeul").append("<li class='list-unstyled historynotices'><span style='display:none' class='myselfnoticeid'>"+object.noticeId+"</span><span>"+object.noticeTittle+"</span>"+
								" <span>"+object.noticeCreateDate+"</span> <span>"+object.type.typeName+"</span>"+	
								" <a class='badge checkmyselfnotice'><span>查看</span></a> " +
								" <a class='badge deletemyselfnotice'><span>移除</span></a> " +			 
						"</li>");
					}

				}); 
				gopage(".historynotices",1,psize); 
			},
			error:function(data){
			}
		}); 
	}
	//发送短消息
	function sendmessage(){
		sendmessagewaring.html('');
		var  shortmessage=$("input[name='shortmessage']").val();
		var receivephone=$("input[name='receivephone']").val();
		//获取该用户的手机号
		var personphone =$(".personphone").val(); 
		if(shortmessage==''||shortmessage==null ){
			sendmessagewaring.html('请输入您要发送的消息');
			sendmessagewaring.css('color','red');
		}else if(receivephone==null||receivephone==''){
			sendmessagewaring.html(' 请输入对方的联系方式哟~');
			sendmessagewaring.css('color','red');
		}else if(receivephone==personphone){
			sendmessagewaring.html('不可以给自己发送消息哟~');
			sendmessagewaring.css('color','red');
		}else if(receivephone!=personphone){
			$.ajax({
				url:requestPath+"/personCenter/sendMessage",
				dataType:"text",
				data:{"personId":personId,"receicePhone":receivephone,"message":shortmessage},
				type:"get",
				success:function(data){ 
					if(data=="true"){
						sendmessagewaring.html('发送成功！');
						sendmessagewaring.css('color','green'); 
						$("input[name='shortmessage']").val("");
						$("input[name='receivephone']").val(""); 
					}else{
						sendmessagewaring.html('系统出错！无法发送');
						sendmessagewaring.css('color','red'); 
						$("input[name='shortmessage']").val("");
						$("input[name='receivephone']").val(""); 
					}
				},error:function(data){
					sendmessagewaring.html('系统出错！无法发送');
					sendmessagewaring.css('color','red'); 
					$("input[name='shortmessage']").val("");
					$("input[name='receivephone']").val(""); 
				}
			});
		}
	}
	//-----------------------------------------分页---------------------------------------------------

	//页面加载的时候首先调用一次（初始化）
	function gopage(lists,currentpage,pagesize){
		//获取总数据量
		var countTotal = $(lists).length; 
		//分页显示的数据量
		var pageSize = pagesize;
		//总页数
		//如果总量除以页面容量的余数大于1
		if(countTotal/pageSize > parseInt(countTotal/pageSize)){
			countPage = parseInt(countTotal/pageSize)+1; 
		}else{
			countPage = parseInt(countTotal/pageSize); 
		}
		//当前分页
		currentPage = currentpage;
		//开始显示的行
		var startRow = (currentpage-1)*pageSize+1;
		//结束行
		var endRow = currentpage*pagesize;
		//如果结束行大于总记录数 则结束行为总记录数
		endRow = (endRow > countTotal) ? countTotal : endRow;  
		//遍历显示数据实现分页
		for(var i=1;i<(countTotal+1);i++){
			//循环获取某个控件
			var irow =$(lists+":eq("+(i-1)+")");
			//如果开始行之内并且不大于最后一行 就显示
			if(i>=startRow && i<=endRow){
				irow.show(500);
				//否则隐藏
			}else{
				irow.hide(500);
			}
		}
		//页码信息"<span style='float:left'>共"+countTotal+"条启示        共"+countPage+"页  当前第"+currentPage+"页</span>"
		var tempStr = "";
		//换页链接显示控制
		if(currentPage>1){ 
			tempStr += "<span><a id=\"firstpage\" href=\"javascript:void(0)\">首页</a>";
			tempStr += "<a id=\"prevpage\"  href=\"javascript:void(0)\"><上一页</a>"
		}else{
			tempStr += "<span>首页";
			tempStr += "<上一页";    
		}
		if(currentPage<countPage ){
			tempStr += "<a id=\"nextpage\" href=\"javascript:void(0)\">下一页></a>";
			tempStr += "<a id=\"lastpage\"  href=\"javascript:void(0)\">尾页</a></span>";
		}else{
			tempStr += "下一页>";
			tempStr += "尾页</span>";    
		}
		//赋值给jsp
		$("#paging").html(tempStr);
		//启动换页功能
		pageJump(lists);
	} 
	function pageJump(lists){
		$("#firstpage").click(function(){
			gopage(lists,1,psize);
		});
		$("#prevpage").click( function(){
			gopage(lists,(currentPage-1),psize);
		});
		$("#nextpage").click(function(){
			gopage(lists,(currentPage+1),psize);
		});
		$("#lastpage").click(function(){
			gopage(lists,countPage,psize);
		});
	}
});