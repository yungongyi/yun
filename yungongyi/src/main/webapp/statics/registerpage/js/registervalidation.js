
	$(function($) {
		/*设置ajax全局同步*/
		$.ajaxSetup({
			async:false
		});
		//0.发送验证码
	
		$("#checkPhoneCode").click(function(){
			if(checkInputNull($("input[name='phone']"))){
				if(checkPhone($("input[name='phone']"))){
					if(checkPerson()==true){
						sendPhoneCode();
					}
				}				
			}
			
		});
		//1.失去焦点
		$("input").blur(function(){
			//非空验证
			if(checkInputNull($(this))){
				if($(this).attr("name")=="phone"){
					if(checkPhone($(this))){
						checkPerson();
					}//密码长度验证
				}
				if($(this).attr("name")=="password"){
					checkPwdLen($(this));
				}
			}
			
		});
		//2.注册
		$("#register").click(function(){
			
			if(beforeRegister()){
				register();	
			}
		});
	

	});



//1.非空验证
function checkInputNull($this){
	var inputName=$this.attr("name");
		if($this.val()==null || $this.val()=="" ){
			var warnInfo="";
			if(inputName=='name'){warnInfo="昵称不能为空";}
			if(inputName=='phone'){warnInfo="手机号不能为空";}
			if(inputName=='password'){warnInfo="密码不能为空";}
			if(inputName=='yanzhengma'){
				warnInfo="验证码不能为空";$this.parent().next().text(warnInfo).show();
			}else{$this.next().text(warnInfo).show();}
			return false;
		}else{
			if(inputName=='yanzhengma'){
				$this.parent().next().hide();
			}else{
				$this.next().hide();
			}
			return true;
		}
}
//2.验证手机号是否已被注册
function checkPerson(){
	var flag=true;
	var phone=$("input[name='phone']").val()
	$.get("/commonweal/login/checkPerson/"+phone,function(data){
		if(data=='false'){
			$("input[name='phone']").next().text("手机号已被注册").show();
			flag=false;
			return false;
		}else{
			$("input[name='phone']").next().hide();
			flag=true;
			return true;
		}
	});
	return flag;
}
//3.发送验证码
var start=10;
function sendPhoneCode(){	
		if(start==10){
			start=start-1;
			var phone=$("input[name='phone']").val()
			$.get("/commonweal/login/getiphone/"+phone,function(data){
				alert("验证码"+data);
			});
			var timeSum=setInterval(function(){
				start--;
				$("#checkPhoneCode").text(start);
				if(start<0){
					 clearInterval(timeSum); 
					 start=10;
					 $("#checkPhoneCode").text("重新发送");
				}
			}, 1000);	
		}
		
    	
	
}

//4.验证手机号
function checkPhone($this){

	var phoneReg = /^1[0-9]{10}$/;
	var flag=phoneReg.test($this.val());

	if(flag==false){
		$this.next().text("手机号码格式错误").show();
		$this.next().show();
		return  false;
	}else{
		$this.next().hide();
		return true;
	}

}
//5.检查密码长度
function checkPwdLen($this){
	var password=$this.val();
	if(password.length<=6){
		$this.next().text("密码至少六位").show();
		return false;
	}
	return true;
}
//注册前检查
function beforeRegister(){
	var flag=true;
	$("input").each(function(){
		if(checkInputNull($(this))==false){
			//空值false
			/*alert("空值false");*/
			flag=false;
			return false;
		}else{
			if($(this).attr("name")=="phone"){
				if(checkPhone($(this))==false){
					//手机号格式验证false
					/*alert("手机号格式验证false");*/
					flag=false;
					return false;
				}else{
					/*alert(checkPerson());*/
					if(checkPerson()==false){
						//手机号存在验证false
						/*alert("手机号存在验证false");*/
						flag=false;
						return false;
					}
				}
			}
			if($(this).attr("name")=="password"){
				if(checkPwdLen($(this))==false){
					//密码长度
					/*alert("密码长度");*/
					flag=false;
					return false;
				}
			}
		}
		
	});
	/*alert(flag);*/
	return true;
}
//6.注册
function register(){
	var nickname = $('input[name=name]').val();
	var phone = $('input[name=phone]').val();
	var passwords = $('input[name=password]').val();
	var yanzhengma = $('input[name=yanzhengma]').val();

	$.get("/commonweal/login/register.html",
			{name:nickname,iphone:phone,password:passwords,yanzhengma:yanzhengma},function(data){
				data=JSON.parse(data);
				if(data.error==null){
				/*	alert("注册成功");*/
					//跳转到登陆页面
					window.location.href="/yungongyi/login.html";
				}
			});
}