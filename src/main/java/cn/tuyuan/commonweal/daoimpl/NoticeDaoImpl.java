package cn.tuyuan.commonweal.daoimpl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.NoticeDao;
import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.util.FormateParse;
import cn.tuyuan.commonweal.util.GetDate;

/**
 * @author 孙家伟 2017年12月27日
 *
 */
@Repository("noticeDao")
public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	public NoticeDaoImpl() {

	}

	@Autowired
	public NoticeDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	// 根据用户id查询启示列表
	public List<Notice> getNoticeByPersonId(Integer id) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Notice where personId = :personId order by noticeCreateDate DESC");
		query.setInteger("personId", id);
		List<Notice> notices = query.list();
		return notices;
	}

	// 根据用户id 启示id 删除启示信息
	public int deleteNoticeByPersonIdAndNoticeId(Integer personId,
			Integer noticeId) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		String hql = "delete from Notice where noticeId =? and personId =?";
		Query query = session.createQuery(hql);
		query.setInteger(0, noticeId);
		query.setInteger(1, personId);
		int result = query.executeUpdate();
		return result;
	}

	/**
	 * 分页查询
	 * 
	 * @throws ParseException
	 * @throws DataAccessException
	 */
	@Override
	public List<Notice> getNoticeList(Integer stateId, String date) {
		System.out.println(date);
		String hql = "from Notice n where n.state.stateId =" + stateId;
		String hql2 = "from Notice n where  n.noticeCreateDate like '"+date+"%'";
		String hql3 = "from Notice n where n.state.stateId ="+stateId+" and n.noticeCreateDate like '"+date+"%'";
		String hql4 = "from Notice n";
		if (stateId != null && stateId != 0) {
			return (List<Notice>) this.getHibernateTemplate().find(hql);
		} else if (date != null && !date.equals("")) {
			return (List<Notice>) this.getHibernateTemplate().find(hql2);
		} else if (stateId != null && stateId != 0 && date != null) {
			return (List<Notice>) this.getHibernateTemplate().find(hql3);
		}
		return (List<Notice>) this.getHibernateTemplate().find(hql4);

	}

	/**
	 * 根据启事标题查询启事信息
	 */
	@Override
	public List<Notice> getNoticeBynoticeTittle(String noticeTittle) {
		String hql = "from Notice as n where n.noticeTittle  like ?";
		return (List<Notice>) this.getHibernateTemplate().find(hql,
				"%" + noticeTittle + "%");
	}

	/**
	 * 删除启事
	 */
	@Override
	public void delNotice(Integer id) {
		Query q = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession()
				.createQuery("delete from Notice where noticeId=?");
		q.setInteger(0, id);
		q.executeUpdate();
	}

	/**
	 * 根据启事ID查询启事信息
	 */
	@Override
	public List<Notice> getNoticeById(Integer id) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Notice where personId = :personId order by noticeCreateDate DESC");
		query.setInteger("personId", id);
		List<Notice> notices = query.list();
		return notices;
	}

	//无条件查询所有启事
	@Override
	public List<Notice> getNotice() {		
		return this.getHibernateTemplate().loadAll(Notice.class);
	}

	@Override
	public List<Notice> searchAllOfNotice(String content) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		String hql= "from Notice where noticeDetail  like :noticeDetail  or noticeTittle like  :noticeTittle or region = :region ";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		Region r = new Region();
		r.setRegionName("%"+content+"%");
		Type t = new Type();
		t.setTypeName("%"+content+"%");
		Notice n = new Notice();
		n.setRegion(r);
		n.setNoticeDetail("%"+content+"%");
		n.setNoticeTittle("%"+content+"%");
		query.setProperties(n);
		List<Notice> notices = query.list();
		return notices;
	}
	//保存一条启事信息
	public int saveNotice(Notice notice) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		int count = (int) session.save(notice);
		return count;
	}

	@Override
	public List<Notice> getNoticeByQ(Integer regionId, String describe,
			Integer noticeType, Integer noticeState) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		StringBuilder hql = new StringBuilder("from Notice where 1=1 ");
		System.out.println("后台："+regionId+  describe + noticeType+ noticeState);
		Query query = session.createSQLQuery(hql.toString());
		Notice  n = new Notice();

		if(regionId !=0 ){
			hql.append(" and regionId = :regionId"); 
			Region r= new Region();
			r.setRegionId(regionId);
			n.setRegion(r);
		}else if(describe !=null && describe !=""){
			hql.append(" and noticeTittle like :noticeTittle"); 
			n.setNoticeTittle("%"+describe+"%");
		}else if(noticeType!=0){  
			hql.append(" and type = :type"); 
			Type type = new Type();
			type.setTypeId(noticeType);
			n.setType(type);
		}else if(noticeState !=0 ){
			hql.append(" and state = :state"); 
			State state = new State();
			state.setStateId(noticeState);
			n.setState(state);
		}
		hql.append(" order by noticeCreateDate DESC"); 

		//query对象
		query = session.createQuery(hql.toString());
		query.setProperties(n);
		List<Notice> notices = query.list(); 
		return notices;
	}
	//修改启事状态
	public int updateNoticeByPersonIdAndNoticeId(Notice notice) { 
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		String hql = "update Notice set state =:state where noticeId =:noticeId";
		Query query = session.createQuery(hql);
		query.setEntity("state", notice.getState() );
		query.setInteger("noticeId",notice.getNoticeId());
		int count = query.executeUpdate();
		return count;
	}
	//根据启示id查询启示信息
	public Notice getNoticeByid(Integer NoticeId) {
		//根据id
		Notice notice = (Notice) this.getHibernateTemplate().getSessionFactory().getCurrentSession().get(Notice.class,NoticeId);
		return notice;
	}
}
