package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.ProvinceDao;
import cn.tuyuan.commonweal.pojo.Province;


/**
 * 
 * @author 高俊东
 *
 */
@Repository("ProvinceDao")
public class ProvinceDaoImpl extends HibernateDaoSupport implements ProvinceDao {

	//无参构造
	public ProvinceDaoImpl(){}

	//为hibernate注入sessionFactory
	@Autowired
	public ProvinceDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * 查看所有省份
	 */
	@Override
	public List<Province> getProvince() {
		List<Province> p=null;
		p=(List<Province>) this.getHibernateTemplate().find("from Province");
		return p;
	}
	
	/**
	 * 添加省份
	 */
	@Override
	public int addProvince(Province province) {
		int count= (int) this.getHibernateTemplate().save(province);
		return count;
	}
	
}
