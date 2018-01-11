package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Resource;

/**
 * 
 * @author 陈嘉伟
 *
 */
public interface ResourceDao {

	/**
	 * 新增加资源
	 * 
	 * @param resource
	 * @return
	 */
	public Resource addResource(Resource resource);

	/**
	 * 新增资源
	 * 
	 * @param resource
	 * @return 1 or 0
	 */
	public int saveResource(Resource resource);

	/**
	 * 查询资源
	 * 
	 * @param resource
	 * @return 1 or 0
	 */
	public Resource getResourceById(int id);



	/**
	 * 查询所有 分页
	 * 
	 * @return
	 */
	public List<Resource> getResourceList();
	
	/**
	 * 根据Id查询所有
	 */
	public List<Resource> getResourceById(Integer id);
}
