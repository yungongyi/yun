package cn.tuyuan.commonweal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.util.Constants;
import cn.tuyuan.commonweal.util.sendphone.sendsms;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private PersonService ps;


	//进入主页面
	@RequestMapping("/main.html")
	public String main(){
		return "main";
	}

	//进入登录页面
	@RequestMapping("/login.html")
	public String login(){
		return "loginpage";
	}
	//普通登录
	@RequestMapping(value="/doLogin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam("phone")String iphone,
			@RequestParam("password")String userPassword,
			HttpSession  session, HttpServletRequest request){
		Person p = ps.getPerson(iphone, userPassword);
		if(p!=null){
			//如果账号密码正确
			session.setAttribute(Constants.SESSION, p);
			System.out.println("用户对象是否为空:" +p==null); 
			return "redirect:/login/main.html";
		}else{
			//否则跳转回登录页面
			request.setAttribute("error","请输入正确的用户名和密码");
			return "/login/login.html";
		}
	}

	//获取验证码的方法 
	@RequestMapping(value="/getiphone/{iphone}",method=RequestMethod.GET)
	@ResponseBody
	public int getiphone(@PathVariable String iphone,HttpSession session){
		int yanzhengma= sendsms.getiphone(iphone);
		System.out.println(yanzhengma);
		session.setAttribute("loginyanzhengma",yanzhengma);
		return yanzhengma;
	}

	//快速登录
	@RequestMapping(value="/fastLogin.html",method=RequestMethod.GET)
	public String fastLogin(@RequestParam("fphone")String fphone,@RequestParam("fyanzhengma")String fyanzhengma, HttpSession session,HttpServletRequest request){
		//获取手机发送的验证码  
		int  personyanzhengma  = (int) session.getAttribute("loginyanzhengma");
		Person p = ps.fastLogin(fphone);
		   int Fyanzhengma=Integer.parseInt(fyanzhengma);
		if(p!=null){
			if(Fyanzhengma==personyanzhengma){
				//如果账号密码正确
				session.setAttribute(Constants.SESSION, p);
				session.removeAttribute("yanzhengma");
				System.out.println("用户对象是否为空:" +p==null); 
				return "redirect:/login/main.html";
			}
		}
		//否则跳转回登录页面
		request.setAttribute("error","请输入正确的验证码");
		return "/login/login.html";
	}
}
	 
	 