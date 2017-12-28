package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends HibernateDaoSupport implements ResourceDao {

	public  ResourceDaoImpl() {}
	@Autowired
	public  ResourceDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {this.setSessionFactory(sessionFactory);}
	@Override
	public int saveResource(Resource resource) {
		int res=(int) this.getHibernateTemplate().save(resource);
		return res;
	}
	
	@Override
	public Resource getResourceById(int id) {	
		return (Resource) this.getHibernateTemplate().find("from Resource r where r.resourceId", id);
	}

}
