package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.CityDao;
import cn.tuyuan.commonweal.pojo.City;

/**
 * 
 * @author 高俊东
 *
 */
@Repository("CityDao")
public class CityDaoImpl extends HibernateDaoSupport implements CityDao {

	//无参构造
	public CityDaoImpl(){}

	//为hibernate注入sessionFactory
	@Autowired
	public CityDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * 查询所有城市
	 */
	@Override
	public List<City> getCity() {
		List<City> c=(List<City>) this.getHibernateTemplate().find("from City");
		return c;
	}

	/**
	 * 添加城市
	 */
	@Override
	public int addCity(City city) {
		int count=(int) this.getHibernateTemplate().save(city);
		return count;
	}

}
