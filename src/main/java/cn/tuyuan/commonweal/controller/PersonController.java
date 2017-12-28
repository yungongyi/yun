package cn.tuyuan.commonweal.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.service.PersonService;

@RestController("personController")
@RequestMapping("/person")
public class PersonController {

	@Resource
	public PersonService personService;

	//根据用户Id查询电话
	@RequestMapping(value = "/getTelphone", method = RequestMethod.GET)
	public String getPerson(@RequestParam("personId") Integer personId) {
		return personService.getPerson(personId);
	}
}
