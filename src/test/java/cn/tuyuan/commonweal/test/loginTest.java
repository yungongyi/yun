package cn.tuyuan.commonweal.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tuyuan.commonweal.daoimpl.PersonDaoImpl;
import cn.tuyuan.commonweal.pojo.Person;

public class loginTest {
	@Autowired
	public PersonDaoImpl pd;

	@Test
	public void logintest(){
		 
		try {
			// 读取配置文件 
			 Person person = pd.getPerson("18437127648");
			 System.out.println(person.getName());
		} catch (Exception e) {
			// ts.rollback();
			e.printStackTrace();
		} finally {
			 
		}
	}
}