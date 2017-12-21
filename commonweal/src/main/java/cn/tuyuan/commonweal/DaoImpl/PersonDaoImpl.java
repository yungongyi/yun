package cn.tuyuan.commonweal.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.Dao.PersonDao;
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

	@Override
	public List<Person> getAllPerson() {
		List<Person>  p=null;
		try {
		p= (List<Person>) this.getHibernateTemplate().find("from Person");					

		if(p!=null) {
			p.get(0);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}


	
	
	@Override
	public Person getPerson(Person person) {
		List<Person> li= (List<Person>)this.getHibernateTemplate().findByExample(person);
		if(li!=null) {
			System.out.println(li.get(0));
		}
		return li.get(0);
	}

}
