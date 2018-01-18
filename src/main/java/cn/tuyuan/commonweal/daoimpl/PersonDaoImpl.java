package cn.tuyuan.commonweal.daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.PersonDao;
import cn.tuyuan.commonweal.pojo.Partner;
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

	// 根据用户id查询单个用户 （景子铭）
	@Override
	public String getPerson(Integer personId) {
		String hql = "from Person where personid = ?";
		List<Person> list = (List<Person>) this.getHibernateTemplate().find(
				hql, personId);
		return list.get(0).getIphone();
	}

	// 根据用户id查询单个用户 （景子铭）
	@Override
	public Person getPersonbyId(Integer personId) {
		String hql = "from Person where personid = ?";
		List<Person> list = (List<Person>) this.getHibernateTemplate().find(
				hql, personId);
		return list.get(0);
	}


	//修改用户密码
	public boolean updatePersonPassword(Integer personId,String password) {

		try {
			Session session =this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			//先查询
			Person p = (Person) session.load(Person.class,personId);
			Query query = session.createQuery("update Person  SET password = :password where personid = :personId");
			query.setInteger("personId", personId);
			query.setString("password",password);
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//修改用户信息
	public boolean updatePerson(Person person) { 
		try {
			Session session =this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			//先查询
			Person p = (Person) session.get(Person.class, person.getPersonid());
			if(person.getName()!=null){
				p.setName(person.getName());
			}
			if(person.getSex()!=null){
				p.setSex(person.getSex());
			}
			if(person.getIphone()!=null){
				p.setIphone(person.getIphone());
			}
			if(person.getRegion()!=null){
				p.setRegion(person.getRegion());
			}
			if(person.getResource()!=null){
				p.setResource(person.getResource());
			}
			Query query=session.createQuery("update Person SET name=:name, sex=:sex, iphone=:iphone,region=:region,resource=:resource where personid=:personid");
			query.setProperties(p);

			int count = query.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;

		}
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<Person> getPerson() {
		try {
			return (List<Person>) this.getHibernateTemplate().find("from Person") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据手机号查询用户信息
	 */
	@Override
	public List<Person> getPersonByiphone(String iphone) {
		String hql="from Person as p where p.iphone  like ?";
		return (List<Person>) this.getHibernateTemplate().find(hql,"%"+iphone+"%");
	}

	/**
	 * 根据用户Id查询用户信息
	 */
	@Override
	public List<Person> getPersonBypersonid(int id) {
		String hql="from Person as p where p.personid=?";
		System.out.println("不能玫瑰花");
		List<Person> p = (List<Person>) this.getHibernateTemplate().find(hql, id);
		System.out.println("不错吧"+p.get(0).getName());
		return p;
	}

	/**
	 * 修改用户状态
	 */
	@Override
	public void updatePersonBystate(int pid,int sid) {
		Session session = null;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			Query q = session
					.createQuery(
							"update Person p set p.state.stateId=? where p.personid=?")
					.setParameter(0, sid).setParameter(1, pid);
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}


}
