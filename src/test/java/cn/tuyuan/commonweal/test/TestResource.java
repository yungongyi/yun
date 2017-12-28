package cn.tuyuan.commonweal.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.service.ResourceService;

public class TestResource {

	private ApplicationContext app;
	
	@Before
	public void Before(){
		
	
	}
	@Test
	public void test() {
	try {
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		Resource re=new Resource();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
