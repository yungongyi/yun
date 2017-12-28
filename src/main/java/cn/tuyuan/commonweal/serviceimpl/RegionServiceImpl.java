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
	@Override
	public List<Region> getAllRegion(String id) {
		return regionDao.getAllRegion(id);
	}

}
