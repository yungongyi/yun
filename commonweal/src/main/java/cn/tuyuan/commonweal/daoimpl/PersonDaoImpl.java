package cn.tuyuan.commonweal.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.PersonDao;
import cn.tuyuan.commonweal.pojo.Person;

@Repository("personDao")
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	//无参构造
	public PersonDaoImpl(){}

	//为hibernate注入sessionFactory
	@Autowired
	public PersonDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	} 
	//根据手机号查询用户
	public Person getPerson(String iphone) {

		try {
			String hql ="from Person where iphone = ?";
			Person persons= (Person) this.getHibernateTemplate().find(hql, iphone).get(0);
			System.out.println(persons.getIphone());
			if(persons!=null){
				return persons;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
