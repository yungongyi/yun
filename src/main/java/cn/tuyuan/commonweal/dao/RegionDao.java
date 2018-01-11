package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Region;

/**
 * 
 * @author 陈嘉伟
 *
 */
public interface RegionDao {

	/**
	 * 根据parentid分页查询地点
	 * @param first
	 * @param pageSize
	 * @param id
	 * @return
	 */
	List<Region> getRegionByParentId(int first,int pageSize,int id);
	
	/**
	 * 根据regionId查询region
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
