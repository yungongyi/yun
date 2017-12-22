package cn.tuyuan.commonweal.controller;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tuyuan.commonweal.service.PersonService;

@Controller("personController")
public class PersonController {

	@Resource
	public PersonService personService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String getPerson() {
		System.out.println("你好");
		return "hello";
		
	}
}
