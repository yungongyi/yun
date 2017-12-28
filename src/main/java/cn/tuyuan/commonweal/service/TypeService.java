package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Type;
/**
 * @version 1.0
 * @author 陈嘉伟
 *
 */
public interface TypeService {

	public List<Type> getTypeByTableId(int id);
}
