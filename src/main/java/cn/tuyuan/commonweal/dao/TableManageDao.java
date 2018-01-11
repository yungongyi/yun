package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.pojo.Type;


/**
 * @version 1.0
 * @author 孙家伟
 *
 */
public interface TableManageDao {

	 
	/**
	 * @param table
	 * @return
	 * 获取所有模块列表
	 */
	List<TableManage>  getTable();
	 
    int  addTable(TableManage tableManage);
    
    /**
     * 根据表名称查询表信息
     */
    List<TableManage> getTableByName(String name);
}
