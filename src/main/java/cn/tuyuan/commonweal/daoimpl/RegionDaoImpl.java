package cn.tuyuan.commonweal.daoimpl;

import java.util.List;






import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.RegionDao;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.pojo.Resource;
@Repository("regionDao")
public class RegionDaoImpl extends HibernateDaoSupport implements RegionDao {

	public  RegionDaoImpl() {}

	@Autowired
	public  RegionDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {this.setSessionFactory(sessionFactory);}


	/**
	 * 根据parentId分页查询地址
	 */
	@Override
	public List<Region> getRegionByParentId(final int first,final int pageSize,final int id) {
		if(pageSize==0){
			return  (List<Region>) this.getHibernateTemplate().find("from Region r where r.parentId = ?",id);
		}

		return 	(List<Region>)  this.getHibernateTemplate().execute(
				new HibernateCallback<List<Region>>()  {
					public List<Region> doInHibernate(Session session){					
						Query q=session.createQuery("from Region r where r.parentId = ?").setParameter(0, id);
						q.setFirstResult(first);
						q.setMaxResults(pageSize);
						return q.list();
					}
				}
				);

	}

	//根据RegionID查询region
	@Override
	public Region getRegionByRegionId(int RegionId) {
		List<Region> rli= (List<Region>) this.getHibernateTemplate().find("from Region r where r.regionId ="+RegionId);
		if(rli!=null){
			return rli.get(0);
		}
		return null;
	}

	//新增
	@Override
	public Region saveRegion(Region region) {
	try {
		System.out.println(region.getRegionNameEn());
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(region);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return  region;
	}

	//删除
	@Override
	public boolean delRegionById(int RegionId) {
		try {
			this.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(this.getHibernateTemplate().load(Region.class, RegionId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	return true;
	}
	//根据fuid查询区域列表
			public List<Region> getAllRegion(String parentid){
				return (List<Region>) this.getHibernateTemplate().find("from Region r where r.parentId = ?",Integer.parseInt(parentid));
			}
}
