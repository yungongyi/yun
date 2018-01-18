package cn.tuyuan.yungongyi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageJump {

	public static int i = 0;

	// 首页
	@GetMapping("/")
	public String main() {
		// 生成默认用户
		return "main";
	}

	// 登录
	@GetMapping("/loginSuccess.html/{id}")
	public String main(@PathVariable String id, HttpSession session) {
		session.setAttribute("userId", id);
		return "main";
	}

	// 登录
	@GetMapping("/login.html")
	public String login() {
		// 生成默认用户
		return "loginpage";
	}

	// 注册
	@GetMapping("/registerpage.html")
	public String registerpage() {
		// 生成默认用户
		return "registerpage";
	}

	// 底部详情
	@GetMapping("/footerdetail.html/{id}")
	public ModelAndView footerdetail(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("footerdetail");
		mv.addObject("id", id);
		return mv;
	}

	// 系统推送
	@GetMapping("/literacy.html")
	public String literacy() {
		// 生成默认用户
		return "literacy";
	}

	// 启事
	@GetMapping("/notice.html/{Content}")
	public String notice() {
		// 生成默认用户
		return "notice";
	}

	// 启事详情
	@GetMapping("/noticeinfo/{noticeid}")
	public String noticeinfo(@PathVariable("noticeid") String noticeId) {
		return "noticeinfo";
	}

	// 个人中心
	@GetMapping("/personcenter.html")
	public String personcenter(HttpSession session) {
		System.out.println(session.getAttribute("id") + "用户");
		;
		// 生成默认用户
		return "personcenter";
	}

	// 全民公益
	@GetMapping("/welfare.html")
	public String welfare() {
		// 生成默认用户
		return "welfare";
	}

	// 全民公益
	@GetMapping("/textAjax.html")
	public String textAjax() {
		// 生成默认用户
		return "testAjax";
	}

	@GetMapping("/index.html")
	public String getIndex() {
		return "after/index";
	}
}
