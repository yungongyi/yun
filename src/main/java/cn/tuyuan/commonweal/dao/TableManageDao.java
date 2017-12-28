package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.TableManage;


/**
 * @version 1.0
 * @author 陈嘉伟
 *
 */
public interface TableManageDao {

	/**
	 * 查询表
	 * @param table
	 * @return 
	 */
	List<TableManage>  getTable(TableManage table);
}
