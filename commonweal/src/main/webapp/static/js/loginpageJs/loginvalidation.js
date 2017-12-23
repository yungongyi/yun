$(function() {
	//普通登录
	var phone = $('input[name=phone]');
	var passwords = $('input[name=password]');
	var yanzhengma = $('input[name=yanzhengma]');
	//普通登录的提示信息
	var isphone = $('.isphone');
	var ispasswords = $('.ispassword');
	var isyanzhengma = $('.isyanzhengma');
	//快速登录
	var fphone = $('input[name=fphone]');
	var fyanzhengma = $('input[name=fyanzhengma]');
	//快速登录的提示信息
	var fisphone = $('.fisphone');
	var fisyanzhengma = $('.fisyanzhengma');
	//手机号的正则表达式
	var phoneReg = /^1[0-9]{10}$/;
	//普通登录非空验证方法
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

	function checkyanzhengmanull() {
		if(yanzhengma.val() == '') {
			isyanzhengma.show(500);
			isyanzhengma.html('验证码不能为空');
			return false;
		} else if(verifyCode.validate(yanzhengma.val()) == false) {
			isyanzhengma.show(500);
			isyanzhengma.html('验证码不正确');
			return false;
		} else {
			isyanzhengma.hide(500);
			return true;
		}
	}
	//快速登录的非空验证方法
	function checkfphonenull() {
		if(fphone.val() == '') {
			fisphone.show(500);
			fisphone.html('手机号不能为空');
			return false;
		} else if(!phoneReg.test(fphone.val()) && fphone.val() != '') {
			fisphone.show(500);
			fisphone.html('手机号格式不正确');
			return false;
		} else {
			fisphone.hide(500);
			return true;
		}
	}

	function checkfyanzhengmanull() {
		if(fyanzhengma.val() == '') {
			fisyanzhengma.show(500);
			fisyanzhengma.html('验证码不能为空');
			return false;
		} else if(fyanzhengma.val() != 1234) {
			fisyanzhengma.show(500);
			fisyanzhengma.html('验证码不正确');
			return false;
		} else {
			fisyanzhengma.hide(500);
			return true;
		}
	}
	checknull(yanzhengma);
	checknull(phone);
	checknull(passwords);
	checknull(fphone);
	checknull(fyanzhengma);

	function checknull(inputs) {
		inputs.on("focus", function() {}).on("blur", function() {
			if(inputs == phone) {
				checkphonenull();
			} else if(inputs == passwords) {
				checkpasswordnull();
			} else if(inputs == yanzhengma) {
				checkyanzhengmanull();
			} else if(inputs == fphone) {
				checkfphonenull();
			} else if(inputs == fyanzhengma) {
				checkfyanzhengmanull();
			}
		});
	}
	$("#submit").submit(function() {
		var flag = true;
		if(checkphonenull()==false){
			flag = false;
		}else if(checkpasswordnull()==false){
			flag = false;
		}else if(checkyanzhengmanull()==false){
			flag = false;
		} else{
			flag = true;
		}
		return flag;
		
	});
	$("#fastsubmit").submit(function() {
		var flag = true;
		if(checkfphonenull()==false){
			flag = false;
		}else if(checkfyanzhengmanull() == false){
			flag = false;
		}else{
			flag= true;
		}
		return flag;
	});
	var verifyCode = new GVerify('v_container');

});