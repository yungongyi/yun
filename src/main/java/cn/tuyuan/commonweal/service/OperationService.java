package cn.tuyuan.commonweal.service; 
import java.util.List;

import cn.tuyuan.commonweal.pojo.Operation;
/**
 * @author 孙家伟
 * 2017年12月31日
 *
 */
public interface OperationService {

	/**
	 * 获取所有操作记录
	 */
	List<Operation> getOperation();
	
	/**
	 * @param personName
	 * @return
	 */
	List<Operation> getOperationByPersonName(String personName);
	
	/**
	 * 插入用户操作记录
	 */
	int saveOperation(Operation operation);
} 
