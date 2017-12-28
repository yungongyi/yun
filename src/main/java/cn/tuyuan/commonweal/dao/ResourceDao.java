package cn.tuyuan.commonweal.dao;

import cn.tuyuan.commonweal.pojo.Resource;

/**
 * 
 * @author 陈嘉伟
 *
 */
public interface ResourceDao {

	/**
	 * 新增资源 
	 * @param resource
	 * @return  1 or 0 
	 */
	public int saveResource(Resource resource);
	

	/**
	 * 查询资源 
	 * @param resource
	 * @return  1 or 0 
	 */
	public Resource getResourceById(int id);
}
