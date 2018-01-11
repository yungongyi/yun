package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends HibernateDaoSupport implements ResourceDao {

	public ResourceDaoImpl() {
	}

	@Autowired
	public ResourceDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public int saveResource(Resource resource) {
		int res = (int) this.getHibernateTemplate().save(resource);
		return res;
	}

	@Override
	public Resource getResourceById(int id) {
		System.out.println("dao" + id);
		return (Resource) this.getHibernateTemplate().find(
				"from Resource r where r.resourceId =" + id);
	}



	/**
	 * 分页查询资源
	 * @param first
	 * @param pageSize
	 * @return
	 */
	public List<Resource> getResourceList() {
		try {		
			return  (List<Resource>) this.getHibernateTemplate().find("from Resource r");

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;


	}


	/**
	 * 新曾资源
	 */
	@Override
	public Resource addResource(Resource resource) {
		Resource res = resource;
		this.getHibernateTemplate().setCheckWriteOperations(false);
		this.getHibernateTemplate().save(res);
		return res;
	}

	
	/**
	 * 根据ID查询所有
	 */
	@Override
	public List<Resource> getResourceById(Integer id) {	
		return (List<Resource>) this.getHibernateTemplate().find("from Resource r where r.resourceId=?", id);
	}

}
