package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.City;

/**
 * 
 * @author 高俊东
 *
 */
public interface CityDao {

	/**
	 * 查询所有城市
	 * @return 集合
	 */
	List<City> getCity();
	
	
	/**
	 * 添加城市
	 * @param city
	 * @return 0 1
	 */
	int addCity(City city);
}
