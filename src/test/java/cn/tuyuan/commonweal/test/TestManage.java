package cn.tuyuan.commonweal.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.service.TableManageService;

public class TestManage {

	private static ApplicationContext app;
	
	@Before
	public  void  before() throws Exception {
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void test() {
		try {
			TableManageService tb=(TableManageService) app.getBean("tableManageService");
			List<TableManage> li=tb.getTableManage(null);
			for(TableManage l:li){
				System.out.println(l.getTableNameUk()+"\n"+l.getTableNameZh()+"\n"+l.getTableId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
