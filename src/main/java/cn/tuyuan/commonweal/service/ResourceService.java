package cn.tuyuan.commonweal.service;

import cn.tuyuan.commonweal.pojo.Resource;

public interface ResourceService {

	boolean save(Resource resource);
	public Resource getResourceById(int	 id) ;
}
