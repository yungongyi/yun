package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.RegionDao;
import cn.tuyuan.commonweal.pojo.Region;
@Repository("regionDao")
public class RegionDaoImpl extends HibernateDaoSupport implements RegionDao {
	
	public  RegionDaoImpl() {}
	
	@Autowired
	public  RegionDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {this.setSessionFactory(sessionFactory);}
	
	@Override
	public List<Region> getAllRegion(String id){
		return (List<Region>) this.getHibernateTemplate().find("from Region r where r.parentId = ?",(double)Integer.parseInt(id));
	}

}
