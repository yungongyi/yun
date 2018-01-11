package cn.tuyuan.commonweal.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.TableManageDao;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.pojo.Type;

/**
 * @author 孙家伟
 * 2018年1月5日
 *
 */
@Repository("tableManageDao")
public class TableManageDaoImpl extends HibernateDaoSupport implements TableManageDao {

	public TableManageDaoImpl(){}

	@Autowired
	public TableManageDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);}

	//获取所有模块列表
	public List<TableManage> getTable() {
		//获取session对象
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from TableManage");
		return query.list();
	}
	/*
	 *添加表 
	 */
	//添加模块
	public int addTable(TableManage tableManage) {
		Session session= this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		int count  = (int) session.save(tableManage);
		System.out.println("影响行数"+count);
		return count;
	}

	/**
	 * 根据表名称查询表信息
	 */
	@Override
	public List<TableManage> getTableByName(String name) {		
		return (List<TableManage>) this.getHibernateTemplate().find("from TableManage where tableNameZh='?'", name);
	} 
}
