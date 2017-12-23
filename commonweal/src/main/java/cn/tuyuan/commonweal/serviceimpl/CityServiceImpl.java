package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.CityDao;
import cn.tuyuan.commonweal.pojo.City;
import cn.tuyuan.commonweal.service.CityService;

@Service("CityService")
public class CityServiceImpl implements CityService{

	//注入CityDao接口
	@Autowired
	private CityDao cityDao ;
	
	/**
	 * 查询所有城市
	 */
	@Override
	public List<City> getCity() {
		return cityDao.getCity();
	}

	/**
	 * 添加城市
	 */
	@Override
	public int addCity(City city) {
		return cityDao.addCity(city);
	}

}
