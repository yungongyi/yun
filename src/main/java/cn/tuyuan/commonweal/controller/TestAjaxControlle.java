package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.service.RegionService;

@RestController
public class TestAjaxControlle {
	
	@Resource
	PersonService personService;
	
	@Resource
	private RegionService regionService;
	
	
	@GetMapping("/testPerson")
	public Person testPerson(){
		Person p= personService.getPerson("18437127648", "123456");
		System.out.println(p.getType().getTypeName());
		System.out.println(p.getState().getStateName());
		System.out.println(p.getResource().getResourcePath());
		return p;
	}
	@GetMapping("/test")
	public  Person test(){
		Person p=null;
		try {
			p= personService.getPerson("18437127648", "123456");
			System.out.println(p.getType().getTypeName());
			System.out.println(p.getState().getStateName());
			System.out.println(p.getResource().getResourcePath());
			System.out.println(p.getIphone());
			System.out.println(p.getName());
			System.out.println(p.getPassword());
			System.out.println(p.getPersonid());
			System.out.println(p.getPersonCreateDate());
			System.out.println(p.getSex());
			System.out.println(p.getNoticeSet().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@GetMapping("/testRegion")
	public List<Region> testRegion(){
		return regionService.getAllRegion("0");
	}
}
