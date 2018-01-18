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
import cn.tuyuan.commonweal.pojo.Info;
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
		String hql = " from Message order by sendDate desc";
		return (List<Message>) this.getHibernateTemplate().find(hql);
	}

	/**
	 * @describe 查询消息信息
	 * @param personId
	 *            发送人id
	 * @return Message
	 */

	public List<Message> getAllMessageByPersonId(Integer personId) {
		return (List<Message>) this.getHibernateTemplate().find("from Message m where m.personId=?", personId);
	}

	@Override
	public Message getMessage(Integer personId) {
		String hql = "from Message where messageId =?";
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(
				hql, personId);
		Message message = list.get(0);
		return message;
	}

	@Override
	public String delMessage(Integer messageId) {
		Session session = null;
		int num = 0;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			String hql = "delete Message where messageId = ?";
			Query query = session.createQuery(hql);
			query.setInteger(0, messageId);
			num = query.executeUpdate();
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			if (session != null)
				session.close();
		}
		if (num > 0) {
			return "true";
		}
		return "false";

	}

	// 删除指定的消息
	public int deleteMessagebyPersonId(Integer personId, Integer messageId) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		String hql = "delete from Message where messageId =? and personId =?";
		Query query = session.createQuery(hql);
		query.setInteger(0, messageId);
		query.setInteger(1, personId);
		int result = query.executeUpdate();
		return result;
	}

	// 插入一条消息信息
	public int insertMessage(Message message) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		int count = (int) session.save(message);
		return count;
	}

}
