package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.MessageDao;
import cn.tuyuan.commonweal.pojo.Message;

@Repository("messageDao")
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	// 无参构造
	public MessageDaoImpl() {
	}

	// 为hibernate注入sessionFactory
	@Autowired
	public MessageDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * @describe 查询所有消息信息
	 * @return all Message
	 */
	@Override
	public List<Message> getAllMessage() {
		String hql = "from Message";
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(
				hql);
		return list;
	}

	/**
	 * @describe 查询消息信息
	 * @param personId
	 *            发送人id
	 * @return Message
	 */
	@Override
	public Message getMessage(Integer personId) {
		String hql = "from Message where messageId =?";
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(
				hql, personId);
		Message message = list.get(0);
		return message;
	}

	@Override
	public void delMessage(Integer messageId) {
		Session session = null;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			String hql = "delete Message where messageId = ?";
			Query query = session.createQuery(hql);
			query.setInteger(0, messageId);
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
