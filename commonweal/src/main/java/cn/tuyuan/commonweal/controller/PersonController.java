package cn.tuyuan.commonweal.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.service.PersonService;

@RestController("personController")
@RequestMapping("/person")
public class PersonController {

	@Resource
	public PersonService personService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView getPerson() {
		System.out.println("你考虑尽快了dasd解来asaas看经济考虑好");
		return new ModelAndView("hello");
		
	}
}
