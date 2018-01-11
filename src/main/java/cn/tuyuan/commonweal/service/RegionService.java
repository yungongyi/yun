package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Region;

public interface RegionService {

	/**
	 * 根据parentId查询地址
	 * @param first
	 * @param pageSize
	 * @param id
	 * @return
	 */
	List<Region> getRegionByParentId(int currentPage,int pageSize,int id);
	
	/**
	 * 根据id查询地区
	 * @param RegionId
	 * @return
	 */
	Region getRegionByRegionId(int RegionId);
	

	/**
	 * 新增地区
	 * @param region
	 * @return
	 */
	Region saveRegion(Region region);
	
	/**
	 * 删除地区
	 * @param region
	 * @return
	 */
	boolean delRegionById(int RegionId);
	
	public List<Region> getAllRegion(String parentid);
}
