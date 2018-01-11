package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Resource;

public interface ResourceService {

	/**
	 * 新增加
	 */
	Resource saveResource(Resource resource);
	
	/**
	 * 新增资源
	 * @param resource
	 * @return
	 */
	boolean save(Resource resource);
	
	/**
	 * 根据资源id查询资源
	 * @param id
	 * @return
	 */
	public Resource getResourceById(int	 id) ;

	
	/**
	 * 查询所有资源
	 * @return
	 */
	public List<Resource> findResourceList();
	
	/**
	 * 根据Id查询所有
	 */
	public List<Resource> getResourceByresourceId(Integer id);
}
