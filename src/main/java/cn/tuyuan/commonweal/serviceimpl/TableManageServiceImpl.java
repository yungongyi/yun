package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.TableManageDao;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.service.TableManageService;

@Service("tableManageService")
public class TableManageServiceImpl implements TableManageService {

	@Resource
	TableManageDao tableManageDao;
	
	@Override
	public List<TableManage> getTableManage(TableManage tableManage) {
		// TODO Auto-generated method stub
		return tableManageDao.getTable(tableManage);
	}

	

}
