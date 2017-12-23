package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.AreaDao;
import cn.tuyuan.commonweal.pojo.TbArea;


/**
 * 
 * @author 高俊东
 *
 */
@Repository("AreaDao")
public class AreaDaoImpl extends HibernateDaoSupport implements AreaDao {

	//无参构造
	public AreaDaoImpl(){}

	//为hibernate注入sessionFactory
	@Autowired
	public AreaDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}


	/**
	 * 查询所有区、县
	 */
	@Override
	public List<TbArea> getArea() {
		List<TbArea> a=(List<TbArea>) this.getHibernateTemplate().find("from TbArea");
		return a;
	}

	/**
	 * 添加所有区、县
	 */
	@Override
	public int addArea(TbArea area) {
		int count=(int) this.getHibernateTemplate().save(area);		
		return count;
	}

}
