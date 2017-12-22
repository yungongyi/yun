$(function() {
	var phone = $('input[name=phone]');
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

	checknull(phone);
	 
	function checknull(inputs) {
		inputs.on("focus", function() {}).on("blur", function() {
			if(inputs == phone) {
				checkphonenull();
			}  
		});
	}
	
	$('#register').submit(function() {
		var flag = true;
		if(checkphonenull()  == false) {
			flag = false;
		}
		return  flag;
	});
});