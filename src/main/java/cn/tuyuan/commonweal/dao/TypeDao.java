package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Type;
/**
 * @version 1.0
 * @author 陈嘉伟
 *
 */
public interface TypeDao {

	/**
	 * @see 根据表Id查询对应类型
	 * @param id
	 * @return
	 */
	List<Type> getTypeByTableId(int id);
}
