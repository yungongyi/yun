package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.RegionDao;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.service.RegionService;
@Service("regionService")
public class RegionServiceImpl implements RegionService {

	@Resource()
	private RegionDao  regionDao;

	//根据父id分页查询地址
	@Override
	public List<Region> getRegionByParentId(int currentPage, int pageSize,
			int id) {
		int pageNo=(currentPage-1)*pageSize;
		return regionDao.getRegionByParentId(pageNo, pageSize, id);
	}

	//根据regionid查询地区
	@Override
	public Region getRegionByRegionId(int RegionId) {
		return regionDao.getRegionByRegionId(RegionId);
	}

	@Override
	public Region saveRegion(Region region) {
		System.out.println("service");
		return regionDao.saveRegion(region);
	}

	@Override
	public boolean delRegionById(int RegionId) {
	
		return regionDao.delRegionById(RegionId);
	}

	@Override
	public List<Region> getAllRegion(String parentid){
		return regionDao.getAllRegion(parentid);
	}
	
}
