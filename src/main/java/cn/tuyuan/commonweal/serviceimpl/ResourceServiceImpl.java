package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.service.ResourceService;

/*import cn.tuyuan.commonweal.util.PageSupport;*/

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource()
	private ResourceDao resourcedao;

	@Override
	public boolean save(Resource resource) {
		if (resourcedao.saveResource(resource) > 0) {
			return true;
		}
		return false;
	}

	// 按照id查询
	public Resource getResourceById(int id) {
		return resourcedao.getResourceById(id);
	}


	/**
	 * 分页查询
	 */
	public List<Resource> findResourceList() {
	
		return resourcedao.getResourceList();
	}

	@Override
	public Resource saveResource(Resource resource) {
		return resourcedao.addResource(resource);
	}


	/**
	 * 根据ID查询所有
	 */
	@Override
	public List<Resource> getResourceByresourceId(Integer id) {		
		return resourcedao.getResourceById(id);
	}

}
