package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.PartnerDao;
import cn.tuyuan.commonweal.pojo.Partner;


/**
 * 
 * @author 高俊东
 *
 */

@Repository("partnerDao")
public class PartnerDaoImpl extends HibernateDaoSupport implements PartnerDao {

	public PartnerDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired 
	public PartnerDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 查询所有合作对象
	 */
	@Override
	public List<Partner> getPartner() {
		return (List<Partner>) this.getHibernateTemplate().find("from Partner");
	}
	/**
	 * 根据合作姓名查询合作对象
	 */
	@Override
	public List<Partner> getPartnerByName(String name) {
		String hql="from Partner as p where p.partnerName  like ?";
		return (List<Partner>) this.getHibernateTemplate().find(hql,"%"+name+"%");
	}
	/**
	 * 添加合作对象
	 */
	@Override
	public void addPartner(Partner p) {
	
		this.getHibernateTemplate().setCheckWriteOperations(false);
		this.getHibernateTemplate().save(p);
		System.err.println("遗鸥");
	}
	/**
	 * 删除合作对象
	 */
	@Override
	public void delPartner(int id) {
		System.out.println("a阿萨德"+id);
		Query q= this.getHibernateTemplate().getSessionFactory().
				getCurrentSession().createQuery("delete from Partner where partnerId=?");
		q.setInteger(0, id);
		q.executeUpdate();
	}


	/**
	 *根据合作ID查询合作对象
	 */
	@Override
	public List<Partner> getPartnerById(Integer id) {
		String hql="from Partner as p where p.partnerId=?";
		return (List<Partner>) this.getHibernateTemplate().find(hql,id);
	}
}
