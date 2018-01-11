package cn.tuyuan.commonweal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import cn.tuyuan.commonweal.dao.OperationDao;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.pojo.Operation;
import cn.tuyuan.commonweal.service.OperationService;

/**
 * @author 孙家伟
 * 2017年12月31日
 *
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService {

	@Resource
	OperationDao OperationDao;
	//获取所有数据库操作记录
	public List<Operation> getOperation() {
		return OperationDao.getOperation();
	}
	//根据管理员名称查询操作记录
	public List<Operation> getOperationByPersonName(String personName) {
		if(personName.equals("all")){
			return getOperation();
		}else{
			List<Operation> operationByPersonNames  = OperationDao.getOperationByPersonName(personName);
			return operationByPersonNames;
		}
	}
	//插入管理员操作记录
	public int saveOperation(Operation operation) { 
		return OperationDao.saveOperation(operation);
	}

} 
