package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.TableManageDao;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.TableManageService;

@Service("tableManageService")
public class TableManageServiceImpl implements TableManageService {

	@Resource
	TableManageDao tableManageDao;

	//根据条件查询模块列表
	public List<TableManage> getTableManage() {
		// TODO Auto-generated method stub
		return tableManageDao.getTable();
	}
	/*
	 * 新增表 
	 *  
	 */
	@Override
	public int insertTable(TableManage tableManage) {
		int  count= 0;
		try {
			tableManageDao.addTable(tableManage);
			count=1;
		} catch (Exception e) {
            count = 0;
		}
		return count;
	}
	
	/**
	 * 根据表名称查询表信息
	 */
	@Override
	public List<TableManage> getTableByName(String name) {
		return tableManageDao.getTableByName(name);
	} 
}
