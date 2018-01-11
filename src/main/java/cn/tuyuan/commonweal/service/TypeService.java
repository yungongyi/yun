package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Type;
/**
 * @version 1.0
 * @author 陈嘉伟
 *
 */
public interface TypeService {

	//根据tableId 查询type
	public List<Type> getTypeByTableId(int tableId);
	public List<Type> findTypeByTypeId(String id);
	int insertType(Type type);
}
