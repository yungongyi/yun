package cn.tuyuan.commonweal.daoimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.InfoDao;
import cn.tuyuan.commonweal.pojo.Info;

@Repository("infoDao")
public class InfoDaoImpl extends HibernateDaoSupport implements InfoDao {

	// 无参构造
	public InfoDaoImpl() {
	}

	// 为hibernate注入sessionFactory
	@Autowired
	public InfoDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * @describe 查询所有通知信息
	 * @return all info
	 */
	@Override
	public List<Info> getAllInfo() {
		String hql = "from Info";
		List<Info> list = (List<Info>) this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * @describe 根据通知Id查询通知信息
	 * @param 通知Id
	 * @return info
	 */
	@Override
	public Info getInfo(Integer infoId) {
		String hql = "from Info where infoId =?";
		List<Info> list = (List<Info>) this.getHibernateTemplate().find(hql,
				infoId);
		Info info = list.get(0);
		return info;
	}

	/**
	 * @describe 添加通知信息
	 * @param 通知内容
	 */
	@Override
	public void saveInfo(String content) {
		Info info = new Info();
		// 获取当前时间
		info.setInfoCreateDate(new Timestamp((new Date()).getTime()));
		info.setInfoContent(content);
		this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.save(info);
	}

	/**
	 * @describe 删除通知信息
	 * @param 通知Id
	 */
	@Override
	public void delInfo(Integer id) {
		Session session = null;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			String hql = "delete Info where infoId = ?";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);
			query.executeUpdate();
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			if (session != null)
				session.close();
		}

	}

}
