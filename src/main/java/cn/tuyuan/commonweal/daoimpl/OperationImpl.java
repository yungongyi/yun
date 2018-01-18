package cn.tuyuan.commonweal.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.OperationDao;
import cn.tuyuan.commonweal.pojo.Operation;

/**
 * @author 孙家伟
 * 2017年12月31日
 *
 */
@Repository("operationDao")
public class OperationImpl extends HibernateDaoSupport implements OperationDao{
	// 无参构造
	public OperationImpl() {
	}

	// 为hibernate注入sessionFactory
	@Autowired
	public OperationImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	//获取所有操作记录
	public List<Operation> getOperation() {

		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		List<Operation> operations= session.createQuery("from Operation order by operationDate desc").list();
		return operations;
	}

	//根据用户名称查询用户操作记录
	public List<Operation> getOperationByPersonName(String PersonName) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Operation where personId in( select personid from Person where name like ? order by operationDate desc)");
		query.setString(0,"%"+PersonName+"%"); 
		List<Operation> lists = query.list();
		System.out.println(lists.size());
		return lists;
	}
	
	//插入管理员操作记录
	public int saveOperation(Operation operation) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		int count = (int) session.save(operation);
		return count;
	}

} 
