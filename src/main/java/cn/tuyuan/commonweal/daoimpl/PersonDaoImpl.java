package cn.tuyuan.commonweal.daoimpl;


import java.util.List;

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
		Person persons= null;
		try {
			String hql ="from Person where iphone = ? ";
			if( this.getHibernateTemplate().find(hql, iphone).isEmpty()){
				System.out.println("psersons:"+persons);
		      return null;
			}
			persons = (Person) this.getHibernateTemplate().find(hql, iphone).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return persons;
	}

	//新增一条用户信息
	public int savePerson(Person person) {
		return (int) this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(person);
	}

	//根据手机号码判断该用户是否存在
	public boolean getPersonByid(String iphone) {
		boolean empty = this.getHibernateTemplate().find("from Person where iphone = ? ", iphone).isEmpty();
		return empty;
	}

// 根据用户id查询单个用户（直接过去手机号） （景子铭）
	@Override
	public String getPerson(Integer personId) {
		String hql = "from Person where personid = ?";
		List<Person> list = (List<Person>) this.getHibernateTemplate().find(
				hql, personId);
		return list.get(0).getIphone();
	}

}
