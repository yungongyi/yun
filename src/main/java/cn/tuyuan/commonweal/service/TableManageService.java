package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.pojo.Type;

/**
 * @version 1.0
 * @author孙家伟
 *
 */
public interface TableManageService {

	
	 	/**
	 * @param tableManage
	 * @return
	 * 获取所有的模块列表
	 */
	List<TableManage> getTableManage();
	
	/**
	 * @param tableManage
	 * @return
	 * 新增模块
	 */
	int  insertTable(TableManage tableManage);
	
	 
    /**
     * 根据表名称查询表信息
     */
    List<TableManage> getTableByName(String name);
}
