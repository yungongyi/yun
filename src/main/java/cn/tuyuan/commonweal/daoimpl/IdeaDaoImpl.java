package cn.tuyuan.commonweal.daoimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.IdeaDao;
import cn.tuyuan.commonweal.pojo.Idea;
import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.util.HttpSessionManager;

@Repository("ideaDao")
public class IdeaDaoImpl extends HibernateDaoSupport implements IdeaDao {

	// 无参构造
	public IdeaDaoImpl() {
	}

	// 为hibernate注入sessionFactory
	@Autowired
	public IdeaDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * @describe 查询所有意见信息
	 * @return all Idea
	 */
	public List<Idea> getAllIdea() {
		String hql = " from Idea order by ideaCreateDate desc";
		return (List<Idea>) this.getHibernateTemplate().find(hql);

	}

	/**
	 * @describe 查询意见信息
	 * @param ideaId
	 *            意见信息id
	 * @return Idea
	 */
	@Override
	public Idea getIdea(Integer ideaId) {
		String hql = "from Idea where ideaId =?";
		List<Idea> list = (List<Idea>) this.getHibernateTemplate().find(hql,
				ideaId);
		Idea idea = list.get(0);
		return idea;
	}

	/**
	 * @describe 修改意见信息（只能修改状态）
	 * @param ideaId
	 *            stateId
	 */
	@Override
	public void updateIdea(Integer ideaId, Integer stateId) {
		Session session = null;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			Query q = session
					.createQuery(
							"update Idea i set i.state.stateId=? where i.ideaId=?")
					.setParameter(0, stateId).setParameter(1, ideaId);
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			if (session != null)
				session.close();
		}
	}

	/**
	 * @describe 删除意见反馈信息
	 * @param ideaId
	 *            消息id
	 */
	@Override
	public String delIdea(Integer ideaId) {
		int num = 0;
		Session session = null;
		session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		try {
			String hql = "delete Idea where ideaId = ?";
			Query query = session.createQuery(hql);
			query.setInteger(0, ideaId);
			num = query.executeUpdate();
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

	/**
	 * @describe 添加一条意见信息
	 * @param content意见内容
	 *            email邮箱
	 */

	@Override
	public int saveIdea(String content, String eamil, HttpSession se) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Idea idea = new Idea();
		idea.setIdeaContent(content);
		System.out.println(HttpSessionManager.getCurrentUserId());
		idea.setPersonId(HttpSessionManager.getCurrentUserId());
		idea.setPersonEmail(eamil);
		idea.setIdeaCreateDate(new Timestamp((new Date()).getTime()));
		State state = new State();
		state.setStateId(4);
		idea.setState(state);
		int count = (int) session.save(idea);
		return count;
	}
}
