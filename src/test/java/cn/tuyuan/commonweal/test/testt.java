package cn.tuyuan.commonweal.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;

public class testt {

	@Test
	public void test() {
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService personService=(PersonService) app.getBean("personService");
		Person p=personService.getPerson("18437127648", "123456");
		System.out.println(p.getType().getTypeName());
		System.out.println(p.getState().getStateName());
		System.out.println(p.getResource().getResourcePath());
	}

}
