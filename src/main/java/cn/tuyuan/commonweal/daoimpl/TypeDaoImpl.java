package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.TypeDao;
import cn.tuyuan.commonweal.pojo.Type;
@Repository("typeDao")
public class TypeDaoImpl extends HibernateDaoSupport implements TypeDao  {

	public  TypeDaoImpl(){};
	
	@Autowired
	public  TypeDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	};
	/*
	 * 通过id查询表如果id为空，如果为空就让他查询所有哦，否则按id查询
	 */
	@Override
	public List<Type> getTypeByTypeId(int id) {
		List<Type> tli=null;
		if(id==-1){
			tli=(List<Type>) this.getHibernateTemplate().find("from Type");
		}else{
			 
			tli=(List<Type>) this.getHibernateTemplate().find("from Type  where typeId = ?",id);
		}
		return tli;
	}
	/*
	 * 按表id查询所有类型
	 */
	@Override
	public List<Type> getTypeByTableId(int tableId) {
		 List<Type> ll= (List<Type>) this.getHibernateTemplate().find("from Type  where tableId = ?",tableId);
		System.out.println("底层"+ll.get(0).getTypeId());
		 return ll;
	}

	/*
	 * 新增类型
	 */
	@Override
	public void addType(Type type) {
		Session session= this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		 Transaction tx=null;
		 try {
			  tx= session.beginTransaction();
			  session.save(type);
			  tx.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
			
		}  
			
		 }	
	}
