package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.TbArea;

/**
 * 
 * @author 高俊东
 *
 */
public interface AreaDao {
	
	/**
	 * 查询所有区、县
	 * @return 集合
	 */
	List<TbArea> getArea();
	
	
	/**
	 * 添加区、县
	 * @param area
	 * @return  0  1
	 */
	int addArea(TbArea area);
}
