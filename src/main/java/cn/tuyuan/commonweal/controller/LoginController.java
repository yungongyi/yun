package cn.tuyuan.commonweal.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.util.Constants;
import cn.tuyuan.commonweal.util.HttpSessionManager;
import cn.tuyuan.commonweal.util.sendphone.sendsms;
@RestController("loginController")
@RequestMapping("/login")
public class LoginController {

	@Resource
	private PersonService personService;

	//普通登录
	@PostMapping("/doLogin.html")
	public Map<String,String> doLogin(@RequestParam("iphone")String phone,
			@RequestParam("password")String userPassword,
			HttpSession  session, HttpServletRequest request){
		Map<String,String>  m=new HashMap<String,String>();
		try {
			Person p = personService.getPerson(phone, userPassword);	
			if(p!=null){
				HttpSessionManager.setCurrentUserId(p.getPersonid());
				HttpSessionManager.setCurrentIphone(p.getIphone());
				m.put("id", p.getPersonid().toString());
				m.put("Iphone", p.getIphone());		
			}else{
				//否则跳转回登录页面
				m.put("id", null);
				m.put("Iphone",null);	
				m.put("error","用户名或密码错误");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	//获取验证码的方法 
	@GetMapping("/getiphone/{iphone}")
	public int getiphone(@PathVariable String iphone){
		int yanzhengma= sendsms.getiphone(iphone);
		System.out.println("yanzhengma"+yanzhengma);
		HttpSessionManager.setTempCode(yanzhengma);
		return yanzhengma;
	}

	//快速登录
	@PostMapping("/fastLogin.html")
	public Map fastLogin(String fphone,String fyanzhengma,HttpServletRequest request){
		//获取手机发送的验证码  
		int  personyanzhengma  =HttpSessionManager.getTempCode();
		Person p = personService.fastLogin(fphone);
		Map m=new HashMap();
		int Fyanzhengma=Integer.parseInt(fyanzhengma);
		if(p!=null){
			if(Fyanzhengma==personyanzhengma){
				//如果账号密码正确
				HttpSessionManager.setCurrentUserId(p.getPersonid());
				HttpSessionManager.setCurrentIphone(p.getIphone());
				m.put("id", p.getPersonid());
				m.put("Iphone", p.getIphone());		
			}else{
				//否则跳转回登录页面
				m.put("id",null);
				m.put("error","请输入正确的验证码");	
			}
		}	
		System.out.println(m.toString());
		return m;
	}

	//注册之前先查询该用户是否存在
	@GetMapping("/checkPerson/{iphone}")
	public boolean checkPerson(@PathVariable String iphone ){
		//通过用户输入的电话号码判断是否注册过
		boolean  exists = personService.getPersonById(iphone);
		System.out.println("person是否为空："+exists); 
		return exists;
	} 
	//用户注册
	@GetMapping("/register.html")
	public Map savePerson(
			@RequestParam("name")String name ,
			@RequestParam("iphone")String iphone,
			@RequestParam("password")String password  , 
			@RequestParam("yanzhengma")String yanzhengma,
			HttpServletRequest request) { 
		Map<String,Object> map=new HashMap<String,Object>();
		String  registeryanzhengma  = HttpSessionManager.getTempCode().toString();
		if(yanzhengma.equals(registeryanzhengma)){
			Timestamp d = new Timestamp(System.currentTimeMillis()); 
			Person person = new Person();
			person.setName(name);

			person.setPassword(password);
			person.setIphone(iphone);
			person.setPersonCreateDate(d);
			person.setSex(0);
			int savePerson = personService.savePerson(person);
			if(savePerson>=0){
				map.put("error",null);			
			}else{
				map.put("error", "创建失败!");
			} 
		}else{
			map.put("error", "验证码错误!");
		}
		return map;
	}
}

