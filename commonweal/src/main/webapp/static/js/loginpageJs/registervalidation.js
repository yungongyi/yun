$(function() {
	var nickname = $('input[name=nickname]');
	var phone = $('input[name=phone]');
	var passwords = $('input[name=password]');
	var yanzhengma = $('input[name=yanzhengma]');
	var isphone = $('.isphone');
	var ispasswords = $('.ispassword');
	var isyanzhengma = $('.isyanzhengma');
	var isnickname = $('.isnickname');
	//手机号的正则表达式
	var phoneReg = /^1[0-9]{10}$/;
	//验证手机号
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
		} else if(yanzhengma.val() != 1234) {
			isyanzhengma.show(500);
			isyanzhengma.html('验证码不正确');
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
		} else
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
});