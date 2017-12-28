$(function() {
	var nickname = $('input[name=name]');
	var phone = $('input[name=phone]');
	var passwords = $('input[name=password]');
	var yanzhengma = $('input[name=yanzhengma]');
	var isphone = $('.isphone');
	var ispasswords = $('.ispassword');
	var isyanzhengma = $('.isyanzhengma');
	var isnickname = $('.isnickname');
	//手机号的正则表达式
	var phoneReg = /^1[0-9]{10}$/;




	//定义一个常亮是否存在
	var isexists ;
	function checkexists(){
		//测试该手机号是否存在
		$.ajax({
			url:"/commonweal/login/checkPerson/"+phone.val(),
			dataType:"json",
			success:function(data){ 
				isexists = data;
				return data;
			}
		});
	}
	//验证手机号是否为空
	function checkphonenull() {
		if(phone.val() == '') {
			isphone.show(500);
			isphone.html('手机号不能为空');
			return false;
		} else if(!phoneReg.test(phone.val()) && phone.val() != '') {
			isphone.show(500);
			isphone.html('手机号格式不正确');
			return false;
		} else {
			isphone.hide(500); 
			return true;
		}
	}
	//验证密码 
	function checkpasswordnull() {
		if(passwords.val() == '') {
			ispasswords.show(500);
			ispasswords.html('密码不能为空');
			return false;
		} else {
			ispasswords.hide(500);
			return true;
		}
	}
	//验证验证码
	function checkyanzhengmanull() {
		if(yanzhengma.val() == '') {
			isyanzhengma.show(500);
			isyanzhengma.html('验证码不能为空');
			return false;
		} else {
			isyanzhengma.hide(500);
			return true;
		}
	}
	//验证昵称
	function checknicknamenull() {
		if(nickname.val() == '') {
			isnickname.show(500);
			isnickname.html('昵称不能为空');
			return false;
		} else {
			isnickname.hide(500);
			return true;
		}
	}

	checknull(phone);
	checknull(passwords);
	checknull(yanzhengma);
	checknull(nickname);
	function checknull(inputs) {
		inputs.on("focus", function() {}).on("blur", function() {
			if(inputs == phone) {
				checkphonenull(); 
			} else if(inputs == passwords) {
				checkpasswordnull();
			} else if(inputs == yanzhengma) {
				checkyanzhengmanull();
			} else if(inputs == nickname) {
				checknicknamenull();
			}
		});
	}
	$('#registerNo').submit(function() {
		var flag = true;
		if(checkphonenull()  == false) {
			flag = false;
		} else if (isexists == false){
			flag = false;
		}else
			if(checkpasswordnull() == false) {
				flag = false;
			} else
				if(checkyanzhengmanull() == false) {
					flag = false;
				}else
					if(checknicknamenull() == false) {
						flag = false;
					}
		return flag;
	});


    var count=1;
    if(count==1){
    	//单击发送按钮
    	$('.yanzheng').click(function() {
    		checkexists();
    		count=2;
    		if(isexists==true){
    			//隐藏发送按钮
    			$(this).html('10');
    			//获取倒计时时间
    			var daojishi = $('.yanzheng').html();
    			
    			var fphone = $("input[name='phone']").val();
    			alert(fphone);
    			$.ajax({
    				url:"/commonweal/login/getiphone/"+fphone,
    				dataType:"json",
    				success:function(data){
    					alert(data);
    				},
    				error:function(error){
    					alert(error);
    				}
    			});
    			//开始倒计时
    			var dingshi = setInterval(function() { 
    				//每隔一秒倒计时减去1
    				daojishi = (daojishi - 1)
    				//重新赋值给倒计时控件以显示
    				$('.yanzheng').html(daojishi);
    				//当倒计时为0时候 结束倒计时
    				if(daojishi == 0) {
    					//更改发送按钮的文本并显示
    					$('.yanzheng').html('重新发送验证码');
    					//清除定时
    					clearInterval(dingshi);
    					count = 1;
    				}
    			}, 1000);
    		}else{
    			$('.yanzheng').html('手机号错误');
    			count = 1;
    		} 
    	});
    } 
});