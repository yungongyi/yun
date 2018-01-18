/**
 * 
 */
// 初始化加载
$(function() {

	// 获取意见内容
	var content = $("textarea[name='message']");
	// 获取邮箱
	var email = $("input[name='email']");

	// 验证意见内容
	function checkContent(data) {
		if (data == '') {
			return false;
		} else {
			return true;
		}
	};

	// 验证邮箱
	function checkEmail(date) {
		if (date == '') {
			return false;
		} else {
			return true;
		}
	};

	// 提交单击事件
	$("button[type='button']").click(
			function() {
				// 判断非空
				if (checkContent(content.val()) == false
						|| checkEmail(email.val()) == false) {
					alert("内容或邮箱不能为空!");
				} else {
					$.ajax({
						url : '/commonweal/idea/saveIdea',
						data : {
							content : content.val(),
							eamil : email.val()
						},
						dataType : 'JSON',
						success : function(data) {
							if (data == 1) {
								alert("提交成功!");
							} else if (data == 0) {
								alert("提交失败!");
							}
						}
					});
				}
			});

	// 添加样式
	var btnId = $("button[name='btnId']").val();
	alert("btnId是个这:" + btnId);
	$(".f_left").eq(btnId - 1).focus();
	$(".tab-pane").eq(0).removeClass("in active");
	$(".tab-pane").eq(btnId - 1).addClass("in active");

});