package cn.tuyuan.commonweal.serviceimpl;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	
	@javax.annotation.Resource()
	private ResourceDao  resourcedao;
	@Override
	public boolean save(Resource resource) {
		// TODO Auto-generated method stub
		if(resourcedao.saveResource(resource)>0){
			return true;
		}
		return false;
	}
	public Resource getResourceById(int id) {
		return resourcedao.getResourceById(id);
		
	}
}
