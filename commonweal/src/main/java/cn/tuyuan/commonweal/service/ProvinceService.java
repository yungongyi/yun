package cn.tuyuan.commonweal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.Province;

/**
 * 
 * @author 高俊东
 *
 */
@Transactional
public interface ProvinceService {

	/**
	 * @describe 查询所有省份
	 * @return all Province
	 */
	List<Province> getProvince();
	
	/**
	 * 
	 * @param provinceName 添加省份
	 * @return  int
	 */
	int addProvince(Province province);
}
