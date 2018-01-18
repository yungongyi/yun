package cn.tuyuan.yungongyi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageJump {

	public static int i = 0;

	// 棣栭〉
	@GetMapping("/")
	public String main() {
		// 鐢熸垚榛樿鐢ㄦ埛
		session.removeAttribute("userId");
		return "main";
	}
	// 鐧诲綍
	@GetMapping("/loginSuccess.html/{id}")
	public String main(@PathVariable String id, HttpSession session) {
		session.setAttribute("userId", id);
		return "main";
	}
	
	@GetMapping("/updatesuccess.html")
	public String updateMain(HttpSession session) {
		
		return "main";
	}
	
	// 鐧诲綍
	@GetMapping("/login.html")
	public String login() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "loginpage";
	}
	// 娉ㄥ唽
	@GetMapping("/registerpage.html")
	public String registerpage() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "registerpage";
	}

	// 搴曢儴璇︽儏
	@GetMapping("/footerdetail.html/{id}")
	public ModelAndView footerdetail(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("footerdetail");
		mv.addObject("id", id);
		return mv;
	}

	// 绯荤粺鎺ㄩ��
	@GetMapping("/literacy.html")
	public String literacy() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "literacy";
	}

	// 鍚簨
	@GetMapping("/notice.html/{Content}")
	public String notice() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "notice";
	}

	// 鍚簨璇︽儏
	@GetMapping("/noticeinfo/{noticeid}")
	public String noticeinfo(@PathVariable("noticeid") String noticeId) {
		return "noticeinfo";
	}

	// 涓汉涓績
	// 启事详情
		@GetMapping("/noticeinfo/{noticeid}") 
		public ModelAndView noticeinfo(@PathVariable("noticeid") String noticeId,Model m) {		 
			ModelAndView mv =new ModelAndView();
			mv.addObject("noticeid",noticeId);
			mv.addObject(m);
			mv.setViewName("noticeinfo");
			return mv;
		}

	// 鍏ㄦ皯鍏泭
	@GetMapping("/welfare.html")
	public String welfare() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "welfare";
	}

	// 鍏ㄦ皯鍏泭
	@GetMapping("/textAjax.html")
	public String textAjax() {
		// 鐢熸垚榛樿鐢ㄦ埛
		return "testAjax";
	}

	@GetMapping("/index.html")
	public String getIndex() {
		return "after/index";
	}
	
}
