package cn.tuyuan.commonweal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.service.ResourceService;

@Controller("pageJumpController")
@RequestMapping("/")
public class PageJumpController {

	//
	@javax.annotation.Resource
	private ResourceService resourceService;
	//1.主页
	@GetMapping("/main.html")
	public String enterMain(){
		return "main";		
	}
	//2.进入个人中心
	@GetMapping("/personCenter.html")
	public String enterPersonCenter(){
		return "personcenter";		
	}

	//3.全民公益读取图片和链接
	 

	//4.进入注册页面
	@RequestMapping("/registerpage.html")
	public String register(){
		return "registerpage";
	}

	//5.进入登录页面
	@RequestMapping("/login.html")
	public String login(){
		return "loginpage";
	}
	//6.底部详情
	@RequestMapping("/footerdatail.html")
	public String getFooterdatail(HttpServletRequest request){
		//request.setAttribute("id", id);
		return "footerdetail";
	}
	//7.进入后台
	@RequestMapping("/index.html")
	public String enterIndex(){
		return "index";
	}
	//8.进入启示大厅
	@RequestMapping("/notice.html")
	public String notice(){
		return "notice";
	}
	//9.进入启示详细信息页面
	@RequestMapping("/noticeinfo.html")
	public String noticeinfo(){
		return "noticeinfo";
	}
	
}
