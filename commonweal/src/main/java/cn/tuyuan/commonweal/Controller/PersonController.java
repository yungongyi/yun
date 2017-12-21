package cn.tuyuan.commonweal.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tuyuan.commonweal.Service.PersonService;

@Controller("personController")
public class PersonController {

	@Resource
	public PersonService personService;
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String getPerson(String criJson) {
		System.out.println("你好");
		return "index";
		
	}
}
