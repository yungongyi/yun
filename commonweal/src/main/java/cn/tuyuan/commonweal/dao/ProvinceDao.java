package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Province;


/**
 * 
 * @author 高俊东
 *
 */
public interface ProvinceDao {
	
	/**
	 * @describe 查询所有省份
	 * @return all Province 集合
	 */
	List<Province> getProvince();
	
	/**
	 * 
	 * @param provinceName 添加省份
	 * @return  int 0 1
	 */
	int addProvince(Province province);

}
