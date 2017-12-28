package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.TableManage;

/**
 * @version 1.0
 * @author陈家伟
 *
 */
public interface TableManageService {

	
	 /**
	  * 查询所有表
	  */
	List<TableManage> getTableManage(TableManage tableManage);
}
