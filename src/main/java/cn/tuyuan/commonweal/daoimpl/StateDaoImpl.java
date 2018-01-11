package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.StateDao;
import cn.tuyuan.commonweal.pojo.State;

@Repository("stateDao")
public class StateDaoImpl extends HibernateDaoSupport implements StateDao {

	// 无参构造
	public StateDaoImpl() {
	}

	// 为hibernate注入sessionFactory
	@Autowired
	public StateDaoImpl(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * @describe 查询所有状态
	 * @return all state
	 */
	@Override
	public List<State> getAllState() {
		String hql = "from State";
		return (List<State>) this.getHibernateTemplate().find(hql);
	}
	/**
	 * @describe 根据状态Id查询状态
	 * @param 状态Id
	 * @return stateName 状态名
	 */
	@Override
	public String getStateNameByStateId(Integer stateId) {
		State state = (State) this.getHibernateTemplate().getSessionFactory().getCurrentSession().get(State.class,
				stateId);
		return state.getStateName();
	}
	/*
	 * 通过id过去状态；
	 */
	@Override
	public List<State> getStateById(int id) {
		//如果id==null就让他为-1，表示查询所有否则按id查询
		if(id==-1){
			return (List<State>) this.getHibernateTemplate().find("from State");
		}else{
			 
			return (List<State>) this.getHibernateTemplate().find("from State t where stateId = ?",id);
		}
	}
	/*
	 * 通过表的id查询所有
	 */
	@Override
	public List<State> getStateByTableId(Integer tableId) {
		return (List<State>) this.getHibernateTemplate().find("from State t where tableId = ?",tableId);
		
	}
	/*
	 * 添加状态
	 */
	@Override
	public void addState(State state) {
		 Session session= this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		 Transaction tx=null;
		 try {
			  tx= session.beginTransaction();
			  session.save(state);
			  tx.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
			
		}  
			
		}

}
