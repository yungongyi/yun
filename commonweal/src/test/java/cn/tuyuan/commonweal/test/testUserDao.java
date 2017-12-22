package cn.tuyuan.commonweal.test;

import java.util.List;




import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;

public class testUserDao {

	
	@Test
	public void Test01(){
		try {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			PersonService persondao=(PersonService) ctx.getBean("personService");
/*			
			Person p=new Person();
			p.setName("cjw");
			Person per=persondao.getPerson(p);
			System.out.println(per.getIphone());*/
			List<Person> pLsit=persondao.getAllPerson();
			if(pLsit!=null){
				for(Person pl:pLsit) {
					System.out.println(pl.getName());
				}
			}else{
				System.out.println("错的");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
}
