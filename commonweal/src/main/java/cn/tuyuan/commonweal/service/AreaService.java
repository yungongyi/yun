package cn.tuyuan.commonweal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.TbArea;

/**
 * 
 * @author 高俊东
 *
 */
@Transactional
public interface AreaService {

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
