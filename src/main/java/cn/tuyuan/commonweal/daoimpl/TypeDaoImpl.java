package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
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
	
	@Override
	public List<Type> getTypeByTableId(int id) {
		List<Type> tli=null;
		if(id==0){
			tli=(List<Type>) this.getHibernateTemplate().find("from Type");
		}else{
			System.out.println(id);
			tli=(List<Type>) this.getHibernateTemplate().find("from Type t where t.tableId = ?",id);
		}
		return tli;
	}

}
