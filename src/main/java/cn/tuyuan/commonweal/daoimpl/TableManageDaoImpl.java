package cn.tuyuan.commonweal.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.tuyuan.commonweal.dao.TableManageDao;
import cn.tuyuan.commonweal.pojo.TableManage;

@Repository("tableManageDao")
public class TableManageDaoImpl extends HibernateDaoSupport implements TableManageDao {

	public TableManageDaoImpl(){}
	
	@Autowired
	public TableManageDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);}
	
	@Override
	public List<TableManage> getTable(TableManage table) {
		 List<TableManage> li=null;
		if(table==null){
			li=(List<TableManage>) this.getHibernateTemplate().find("from TableManage");
		}else{
			li=(List<TableManage>) this.getHibernateTemplate().findByExample(table);
		}
		return li;
	}

}
