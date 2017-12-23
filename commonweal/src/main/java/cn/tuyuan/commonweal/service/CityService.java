package cn.tuyuan.commonweal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.City;

/**
 * 
 * @author 高俊东
 *
 */
@Transactional
public interface CityService {

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
